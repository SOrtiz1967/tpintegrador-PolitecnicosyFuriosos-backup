package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConteoViajesAutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.TrayectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "*")
public class SalidasController {

    @Autowired
    private TrayectosService trayectosService;

    @GetMapping("/conteo-por-auto")
    public ResponseEntity<List<ConteoViajesAutoDTO>> obtenerConteoViajesPorAuto() {
        try {
            List<ConteoViajesAutoDTO> conteo = trayectosService.obtenerConteoViajesPorAuto();
            return ResponseEntity.ok(conteo);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
