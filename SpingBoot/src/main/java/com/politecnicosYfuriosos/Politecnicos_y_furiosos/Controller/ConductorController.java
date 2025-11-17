package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConductorRankingDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.TrayectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
@CrossOrigin(origins = "*")
public class ConductorController {

    @Autowired
    private TrayectosService trayectosService;

    @GetMapping("/ranking")
    public ResponseEntity<List<ConductorRankingDTO>> obtenerRankingConductores() {
        try {
            List<ConductorRankingDTO> ranking = trayectosService.obtenerRankingConductores();
            return ResponseEntity.ok(ranking);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}