package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.ReservaReqDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.ReservaRespDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.ReservaCatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas/catalogo")
@CrossOrigin(origins = "*")
public class ReservaCatalogoController {

    @Autowired
    private ReservaCatalogoService reservaCatalogoService;

    @PostMapping("/crearReserva")
    public ResponseEntity<ReservaRespDTO> crearReserva(@RequestBody ReservaReqDTO request) {
        try {
            ReservaRespDTO response = reservaCatalogoService.registrarReserva(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ReservaRespDTO errorResponse = new ReservaRespDTO();
            errorResponse.setMensaje(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ReservaRespDTO>> obtenerReservasPorCliente(@PathVariable Integer idCliente) {
        List<ReservaRespDTO> reservas = reservaCatalogoService.obtenerReservasPorCliente(idCliente);
        return ResponseEntity.ok(reservas);
    }

    @PostMapping("/{idReserva}/cancelar")
    public ResponseEntity<ReservaRespDTO> cancelarReserva(@PathVariable Integer idReserva) {
        try {
            ReservaRespDTO response = reservaCatalogoService.cancelarReserva(idReserva);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ReservaRespDTO errorResponse = new ReservaRespDTO();
            errorResponse.setMensaje(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/disponibilidad/{idAuto}")
    public ResponseEntity<Boolean> verificarDisponibilidad(
            @PathVariable Integer idAuto,
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        Boolean disponible = reservaCatalogoService.verificarDisponibilidad(idAuto, fechaInicio, fechaFin);
        return ResponseEntity.ok(disponible);
    }

    @GetMapping("/calcular-precio/{idAuto}")
    public ResponseEntity<Double> calcularPrecio(
            @PathVariable Integer idAuto,
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        Double precio = reservaCatalogoService.calcularPrecioReserva(idAuto, fechaInicio, fechaFin);
        return ResponseEntity.ok(precio);
    }
}
