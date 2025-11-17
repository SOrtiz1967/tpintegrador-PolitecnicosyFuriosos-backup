package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AlertaSinRetornoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Trayecto.Trayecto_DTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.TrayectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "*")
public class TrayectosController {

    @Autowired
    private TrayectosService trayectosService;
    // ELIMINAR ESTA LINEA: private TrayectosService salidaService;

    @GetMapping("/alertas-sin-retorno")
    public ResponseEntity<List<AlertaSinRetornoDTO>> obtenerAlertasSinRetorno() {
        try {
            List<AlertaSinRetornoDTO> alertas = trayectosService.obtenerTrayectosSinRetorno24Horas();
            return ResponseEntity.ok(alertas);
        } catch (Exception e) {
            e.printStackTrace(); // Agregar esto para ver el error
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/por-conductor/{id}")
    public ResponseEntity<ArrayList<Trayecto_DTO>> obtenerSalidasPorConductor(
            @PathVariable ("id") Integer id) {

        ArrayList<Trayecto_DTO> historial = trayectosService.obtenerHistorialPorConductor(id);

        // Devuelve 200 OK con la lista (la lista puede estar vacía si no hay historial)
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/por-fechas/{id}")
    public ResponseEntity<?> obtenerSalidasPorFechas(
            @PathVariable("id") Integer id,
            @RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam("hasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {



        int historial = trayectosService.obtenerHistorialPorFechas(id, desde, hasta);
        return ResponseEntity.ok(historial);
    }
}