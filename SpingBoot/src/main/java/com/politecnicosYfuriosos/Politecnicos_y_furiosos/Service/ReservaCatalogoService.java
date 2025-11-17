package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.ReservaReqDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.ReservaRespDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.ClienteRepository;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.AutoRepository;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.ReservaRepository;

@Service
@Transactional
public class ReservaCatalogoService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutoRepository autoRepository;

    private static final int MINIMO_CONDUCTORES = 1;

    public ReservaRespDTO registrarReserva(ReservaReqDTO request) {
        // 1. Validar datos básicos
        validarDatosBasicos(request);

        // 2. Obtener entidades
        Cliente clientePrincipal = clienteRepository.findById(request.getIdClientePrincipal())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Auto auto = autoRepository.findById(request.getIdAuto())
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        // 3. Validar disponibilidad del auto
        validarDisponibilidadAuto(auto, request.getFechaInicio(), request.getFechaFin(), clientePrincipal.isVip());

        // 4. Validar conductores
        List<Cliente> conductoresAdicionales = validarConductores(request.getIdsConductoresAdicionales(), auto);

        // 5. Calcular total
        double total = calcularTotal(auto, request.getFechaInicio(), request.getFechaFin());

        // 6. Crear y guardar reserva
        Reserva reserva = crearReserva(clientePrincipal, auto, request, conductoresAdicionales, total);
        Reserva reservaGuardada = reservaRepository.save(reserva);

        return crearResponseDTO(reservaGuardada, "Reserva registrada exitosamente");
    }

    private void validarDatosBasicos(ReservaReqDTO request) {
        if (request.getFechaInicio() == null || request.getFechaFin() == null) {
            throw new RuntimeException("Las fechas de inicio y fin son obligatorias");
        }
        if (request.getFechaInicio().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha de inicio no puede ser en el pasado");
        }
        if (request.getFechaFin().isBefore(request.getFechaInicio())) {
            throw new RuntimeException("La fecha de fin debe ser posterior a la fecha de inicio");
        }
        if (request.getMetodoPago() == null || request.getMetodoPago().trim().isEmpty()) {
            throw new RuntimeException("El método de pago es obligatorio");
        }
    }

    private void validarDisponibilidadAuto(Auto auto, LocalDate fechaInicio, LocalDate fechaFin, boolean esVip) {
        // Verificar si el auto está disponible
        if (!auto.isDisponible()) {
            throw new RuntimeException("El auto no está disponible para reserva");
        }

        // Buscar reservas superpuestas
        List<Reserva> reservasSuperpuestas = reservaRepository.findReservasSuperpuestas(auto.getId(), fechaInicio, fechaFin);

        if (!reservasSuperpuestas.isEmpty()) {
            // Si hay reservas VIP superpuestas, no se puede reservar
            List<Reserva> reservasVip = reservaRepository.findReservasVipSuperpuestas(auto.getId(), fechaInicio, fechaFin);

            if (!reservasVip.isEmpty()) {
                throw new RuntimeException("No hay disponibilidad. Existen reservas VIP en las fechas seleccionadas");
            }

            // Si el cliente actual es VIP, tiene prioridad sobre reservas no VIP
            if (esVip) {
                // Cancelar reservas no VIP superpuestas
                for (Reserva reserva : reservasSuperpuestas) {
                    if (!reserva.getClientePrincipal().isVip()) {
                        reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
                        reservaRepository.save(reserva);
                    }
                }
            } else {
                throw new RuntimeException("No hay disponibilidad en las fechas seleccionadas");
            }
        }
    }

    private List<Cliente> validarConductores(List<Integer> idsConductores, Auto auto) {
        List<Cliente> conductores = new ArrayList<>();

        if (idsConductores != null) {
            for (Integer idConductor : idsConductores) {
                Cliente conductor = clienteRepository.findById(idConductor)
                        .orElseThrow(() -> new RuntimeException("Conductor no encontrado: " + idConductor));

                // Validar que el conductor esté habilitado
                if (!conductor.isHabilitado()) {
                    throw new RuntimeException("El conductor " + conductor.getNombre() + " no está habilitado");
                }

                // Validar categoría de licencia para autos especiales
                if (auto.getTipo() == Auto.TipoAuto.DEPORTIVO &&
                        conductor.getCategoriaLicencia() == Cliente.CategoriaLicencia.B) {
                    throw new RuntimeException("El conductor " + conductor.getNombre() +
                            " no tiene la categoría necesaria para este auto deportivo");
                }

                conductores.add(conductor);
            }
        }

        // Validar cantidad mínima de conductores
        if (conductores.size() + 1 < MINIMO_CONDUCTORES) {
            throw new RuntimeException("Se requiere al menos " + MINIMO_CONDUCTORES + " conductor(es)");
        }

        return conductores;
    }

    private double calcularTotal(Auto auto, LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (dias < 1) dias = 1; // Mínimo 1 día

        return auto.getPrecioPorDia() * dias;
    }

    private Reserva crearReserva(Cliente clientePrincipal, Auto auto, ReservaReqDTO request,
                                 List<Cliente> conductoresAdicionales, double total) {
        Reserva reserva = new Reserva();
        reserva.setClientePrincipal(clientePrincipal);
        reserva.setAuto(auto);
        reserva.setFechaInicio(request.getFechaInicio());
        reserva.setFechaFin(request.getFechaFin());
        reserva.setTotal(total);
        reserva.setEstado(Reserva.EstadoReserva.CONFIRMADA);

        // Manejo seguro del método de pago
        try {
            reserva.setMetodoPago(Reserva.MetodoPago.valueOf(request.getMetodoPago()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Método de pago inválido: " + request.getMetodoPago());
        }

        reserva.setConductoresAdicionales(conductoresAdicionales);

        return reserva;
    }

    private ReservaRespDTO crearResponseDTO(Reserva reserva, String mensaje) {
        ReservaRespDTO response = new ReservaRespDTO();
        response.setId(reserva.getId());

        // ✅ LÍNEA CORREGIDA
        response.setClientePrincipal(reserva.getClientePrincipal().getNombre() + " " +
                reserva.getClientePrincipal().getApellido());

        response.setAuto(reserva.getAuto().getMarca() + " " + reserva.getAuto().getModelo());
        response.setFechaInicio(reserva.getFechaInicio());
        response.setFechaFin(reserva.getFechaFin());
        response.setEstado(reserva.getEstado().name());
        response.setTotal(reserva.getTotal());
        response.setMensaje(mensaje);

        return response;
    }

    // 🔹 Método para verificar disponibilidad de un auto
    public Boolean verificarDisponibilidad(Integer idAuto, LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            Auto auto = autoRepository.findById(idAuto)
                    .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

            if (!auto.isDisponible()) {
                return false;
            }

            List<Reserva> reservasSuperpuestas = reservaRepository.findReservasSuperpuestas(idAuto, fechaInicio, fechaFin);
            return reservasSuperpuestas.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Método para obtener reservas de un cliente
    public List<ReservaRespDTO> obtenerReservasPorCliente(Integer idCliente) {
        List<Reserva> reservas = reservaRepository.findByClientePrincipalId(idCliente);
        List<ReservaRespDTO> responseList = new ArrayList<>();

        for (Reserva reserva : reservas) {
            ReservaRespDTO response = crearResponseDTO(reserva, "");
            response.setMensaje("Reserva encontrada");
            responseList.add(response);
        }

        return responseList;
    }

    // 🔹 Método para cancelar una reserva
    public ReservaRespDTO cancelarReserva(Integer idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // Solo se pueden cancelar reservas pendientes o confirmadas
        if (reserva.getEstado() != Reserva.EstadoReserva.PENDIENTE &&
                reserva.getEstado() != Reserva.EstadoReserva.CONFIRMADA) {
            throw new RuntimeException("No se puede cancelar una reserva en estado: " + reserva.getEstado());
        }

        // No se puede cancelar una reserva que ya comenzó
        if (reserva.getFechaInicio().isBefore(LocalDate.now())) {
            throw new RuntimeException("No se puede cancelar una reserva que ya comenzó");
        }

        reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
        Reserva reservaCancelada = reservaRepository.save(reserva);

        return crearResponseDTO(reservaCancelada, "Reserva cancelada exitosamente");
    }

    // 🔹 Método para calcular precio de reserva sin guardarla
    public Double calcularPrecioReserva(Integer idAuto, LocalDate fechaInicio, LocalDate fechaFin) {
        Auto auto = autoRepository.findById(idAuto)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        return calcularTotal(auto, fechaInicio, fechaFin);
    }
}