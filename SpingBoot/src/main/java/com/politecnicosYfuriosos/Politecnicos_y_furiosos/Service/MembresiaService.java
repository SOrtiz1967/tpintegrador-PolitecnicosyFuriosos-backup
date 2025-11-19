package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;


import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.AutorizacionDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.MembershipPlan;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.ModeloAutorizado;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.ClienteRepository;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.ModeloAutorizado.ModeloAutorizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembresiaService { // <-- NOMBRE CAMBIADO

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModeloAutorizadoRepository modeloAutorizadoRepository;

    // Lógica para POST /api/conductoresA (Suscribe a EMPRESARIAL)
    public Cliente suscribirConductorA(com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.SuscripcionDTO dto) throws Exception {
        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        if (clienteOpt.isEmpty()) {
            throw new Exception("Cliente no encontrado con ID: " + dto.getClienteId());
        }

        Cliente cliente = clienteOpt.get();
        cliente.setMembresia(MembershipPlan.EMPRESARIAL); // "Categoría A" (VIP)

        return clienteRepository.save(cliente);
    }

    // Lógica para POST /api/conductoresB (Suscribe a PREMIUM)
    public Cliente suscribirConductorB(com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.SuscripcionDTO dto) throws Exception {
        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        if (clienteOpt.isEmpty()) {
            throw new Exception("Cliente no encontrado con ID: " + dto.getClienteId());
        }

        Cliente cliente = clienteOpt.get();
        cliente.setMembresia(MembershipPlan.PREMIUM); // "Categoría B"

        return clienteRepository.save(cliente);
    }

    // Lógica para POST /api/modelos/autorizados (La prueba de Postman)
    public ModeloAutorizado autorizarModelo(AutorizacionDTO dto) throws Exception {
        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        if (clienteOpt.isEmpty()) {
            throw new Exception("Cliente no encontrado con ID: " + dto.getClienteId());
        }

        Cliente cliente = clienteOpt.get();

        if (cliente.getMembresia() != MembershipPlan.PREMIUM) {
            throw new Exception("El cliente no tiene la membresía PREMIUM (Categoría B)");
        }

        ModeloAutorizado autorizacion = new ModeloAutorizado(
                dto.getNombreModelo(),
                dto.getCosto(),
                cliente
        );

        return modeloAutorizadoRepository.save(autorizacion);
    }
}