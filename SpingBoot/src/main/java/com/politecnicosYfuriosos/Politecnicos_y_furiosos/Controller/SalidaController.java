package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/salidas") // Ruta base del documento
public class SalidaController {

    // 1. Inyectamos el servicio que creamos en el Paso 2
    @Autowired
    private DisponibilidadService disponibilidadService;

    /**
     * Endpoint para verificar la disponibilidad de un auto en una fecha específica.
     * Ruta: GET /api/salidas/disponibilidad?autoId=ID&fecha=YYYY-MM-DDTHH:mm
     *
     */
    @GetMapping("/disponibilidad")
    public ResponseEntity<Boolean> verificarDisponibilidad(

            // 2. Capturamos los parámetros de la URL
            @RequestParam("autoId") Long autoId,

            // 3. Capturamos la fecha y la formateamos a LocalDateTime
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {

        // 4. Llamamos al servicio para que haga la lógica
        boolean estaDisponible = disponibilidadService.verificarDisponibilidadAuto(autoId, fecha);

        // 5. Devolvemos la respuesta (true o false) al cliente
        return ResponseEntity.ok(estaDisponible);
    }
}