package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.AutorizacionDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor.SuscripcionDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.ModeloAutorizado;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
// 🚨 CORRECCIÓN CORS: Permite solicitudes desde tu frontend (localhost:5500)
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    // POST /api/conductoresA (Suscribe a EMPRESARIAL / Categoría A)
    @PostMapping("/conductoresA")
    public ResponseEntity<?> suscribirA(@RequestBody SuscripcionDTO suscripcionDTO) {
        try {
            Cliente clienteActualizado = membresiaService.suscribirConductorA(suscripcionDTO);
            // Devuelve el objeto Cliente actualizado (incluyendo la membresía)
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            // Si falla (ej. cliente no encontrado), devuelve un 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // POST /api/conductoresB (Suscribe a PREMIUM / Categoría B)
    @PostMapping("/conductoresB")
    public ResponseEntity<?> suscribirB(@RequestBody SuscripcionDTO suscripcionDTO) {
        try {
            Cliente clienteActualizado = membresiaService.suscribirConductorB(suscripcionDTO);
            // Devuelve el objeto Cliente actualizado
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            // Si falla, devuelve un 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // POST /api/modelos/autorizados (Autorizar un modelo para conductor B)
    @PostMapping("/modelos/autorizados")
    public ResponseEntity<?> autorizarModeloParaConductorB(@RequestBody AutorizacionDTO autorizacionDTO) {
        try {
            ModeloAutorizado nuevaAutorizacion = membresiaService.autorizarModelo(autorizacionDTO);
            return ResponseEntity.ok(nuevaAutorizacion);
        } catch (Exception e) {
            // Si falla (ej. el conductor no es PREMIUM), devuelve un 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
