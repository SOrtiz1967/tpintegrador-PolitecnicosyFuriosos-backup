package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AlertaSinRetornoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Trayecto.Trayecto_DTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConductorRankingDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConteoViajesAutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Trayecto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.TrayectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrayectosService {

    @Autowired
    private TrayectosRepository trayectosRepository;


    public ArrayList<Trayecto_DTO> obtenerHistorialPorConductor(Integer clienteId) {

        // 1. Llamar al repositorio para buscar los trayectos
        ArrayList<Trayecto> trayectos = (ArrayList<Trayecto>) trayectosRepository.findTrayectosByClienteId(clienteId);

        // 2. Convertir la lista de Entidades a una lista de DTOs
        ArrayList<Trayecto_DTO> historialDTOs = new ArrayList<>();
        for (Trayecto trayecto : trayectos) {
            historialDTOs.add(convertirEntidadADTO(trayecto));
        }

        return historialDTOs;
    }

    public int obtenerHistorialPorFechas(Integer clienteId, LocalDate desde, LocalDate hasta) {
        // Validar fechas
        if (desde.isAfter(hasta)) {
            throw new IllegalArgumentException("La fecha desde no puede ser posterior a la fecha hasta");
        }

        ArrayList<Trayecto> trayectos = (ArrayList<Trayecto>) trayectosRepository.findTrayectosByClienteIdAndFechas(clienteId, desde, hasta);
        return cant_trayectos(trayectos);
    }

    /**
     Metodo para hacer la conversión de Entidad a DTO
     */

    private int cant_trayectos(ArrayList<Trayecto> trayectos) {
        ArrayList<Trayecto_DTO> historialDTOs = new ArrayList<>();
        for (Trayecto trayecto : trayectos) {
            historialDTOs.add(convertirEntidadADTO(trayecto));
        }
        return historialDTOs.size();
    }

    // Agrego(santi) este metodo para el ranking
    public List<ConductorRankingDTO> obtenerRankingConductores() {
        return trayectosRepository.findConductoresRanking();
    }

    //agrego este metodo(santi otra ve) para el punto d
    public List<ConteoViajesAutoDTO> obtenerConteoViajesPorAuto() {
        return trayectosRepository.countTrayectosPorAuto();
    }


    private Trayecto_DTO convertirEntidadADTO(Trayecto trayecto) {

        // Obtenemos los objetos relacionados
        Reserva reserva = trayecto.getReserva();
        Auto auto = reserva.getAuto();

        // Creamos el DTO de respuesta
        Trayecto_DTO dto = new Trayecto_DTO();

        dto.setOrigen(trayecto.getDireccionOrigen());
        dto.setDestino(trayecto.getDireccionDestino());
        dto.setFecha(trayecto.getFechaInicio());

        // Combinamos marca y modelo para el DTO
        dto.setAutoUtilizado(auto.getMarca() + " " + auto.getModelo());

        return dto;
    }
    public List<AlertaSinRetornoDTO> obtenerTrayectosSinRetorno24Horas() {
        return trayectosRepository.findTrayectosSinRetorno24Horas();
    }
}