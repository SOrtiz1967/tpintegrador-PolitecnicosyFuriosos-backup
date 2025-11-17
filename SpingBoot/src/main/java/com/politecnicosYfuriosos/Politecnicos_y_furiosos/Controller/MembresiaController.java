package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.AutorizacionDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.ModeloAutorizado;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin; // Asegúrate de importar esto
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
// --- ¡ESTE ES EL CAMBIO! ---
// Le damos permiso tanto a "localhost" como a "127.0.0.1"
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping("/conductoresA")
    public ResponseEntity<?> suscribirA(@RequestBody com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.SuscripcionDTO suscripcionDTO) {
        try {
            Cliente clienteActualizado = membresiaService.suscribirConductorA(suscripcionDTO);
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/conductoresB")
    public ResponseEntity<?> suscribirB(@RequestBody com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.SuscripcionDTO suscripcionDTO) {
        try {
            Cliente clienteActualizado = membresiaService.suscribirConductorB(suscripcionDTO);
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/modelos/autorizados")
    public ResponseEntity<?> autorizarModeloParaConductorB(@RequestBody AutorizacionDTO autorizacionDTO) {
        try {
            ModeloAutorizado nuevaAutorizacion = membresiaService.autorizarModelo(autorizacionDTO);
            return ResponseEntity.ok(nuevaAutorizacion);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}