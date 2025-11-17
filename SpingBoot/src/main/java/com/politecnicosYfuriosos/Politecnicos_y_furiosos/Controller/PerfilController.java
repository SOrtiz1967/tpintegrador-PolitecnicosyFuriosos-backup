package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Perfil.ClientePerfilDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfil")
@CrossOrigin(origins = "*")
public class PerfilController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Endpoint para OBTENER los datos del perfil.
     * El frontend llamará a: GET /api/perfil/5 (si el ID del usuario es 5)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientePerfilDTO> obtenerPerfil(@PathVariable Integer id) {
        try {
            ClientePerfilDTO perfil = clienteService.obtenerPerfil(id);
            return ResponseEntity.ok(perfil);
        } catch (RuntimeException e) {
            // Si el ID no existe, devuelve 404
            return ResponseEntity.notFound().build();
        }
    }
}