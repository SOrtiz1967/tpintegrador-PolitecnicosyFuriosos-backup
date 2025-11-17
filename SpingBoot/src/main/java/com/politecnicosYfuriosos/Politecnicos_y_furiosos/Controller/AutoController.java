package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Controller;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
    @GetMapping("/catalogo")
    public ResponseEntity<List<AutoDTO>> obtenerCatalogo(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) Boolean disponible,
            @RequestParam(required = false) String search) {

        List<AutoDTO> autos;

        // Si hay búsqueda, priorizar eso
        if (search != null && !search.trim().isEmpty()) {
            autos = autoService.buscarPorMarcaOModelo(search);
        }
        // Si hay tipo y disponibilidad
        else if (tipo != null && disponible != null) {
            autos = autoService.filtrarPorTipoYDisponibilidad(tipo, disponible);
        }
        // Si solo hay tipo
        else if (tipo != null) {
            autos = autoService.filtrarPorTipo(tipo);
        }
        // Si solo hay disponibilidad
        else if (disponible != null) {
            autos = autoService.filtrarPorDisponibilidad(disponible);
        }
        // Sin filtros, devolver todos
        else {
            autos = autoService.obtenerTodosParaCatalogo();
        }

        return ResponseEntity.ok(autos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<AutoDTO>> filtrarPorTipo(@PathVariable String tipo) {
        List<AutoDTO> autos = autoService.filtrarPorTipo(tipo);
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<AutoDTO>> obtenerDisponibles() {
        List<AutoDTO> autos = autoService.filtrarPorDisponibilidad(true);
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/destacados")
    public ResponseEntity<List<AutoDTO>> obtenerDestacados(
            @RequestParam(defaultValue = "4") int limit) {
        List<AutoDTO> autos = autoService.obtenerDestacados(limit);
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/ultimo-lanzamiento")
    public ResponseEntity<AutoDTO> obtenerUltimoLanzamiento() {
        AutoDTO auto = autoService.obtenerUltimoLanzamiento();
        return ResponseEntity.ok(auto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> obtenerDetalle(@PathVariable Integer id) {
        AutoDTO auto = autoService.obtenerDetallePorId(id);
        return ResponseEntity.ok(auto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AutoDTO>> buscar(@RequestParam String q) {
        List<AutoDTO> autos = autoService.buscarPorMarcaOModelo(q);
        return ResponseEntity.ok(autos);
    }

    @PostMapping
    public ResponseEntity<AutoDTO> crearAuto(@RequestBody AutoDTO autoDTO) {
        AutoDTO nuevoAuto = autoService.crearAuto(autoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAuto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> actualizarAuto(
            @PathVariable Integer id,
            @RequestBody AutoDTO autoDTO) {
        AutoDTO autoActualizado = autoService.actualizarAuto(id, autoDTO);
        return ResponseEntity.ok(autoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable Integer id) {
        autoService.eliminarAuto(id);
        return ResponseEntity.noContent().build();
    }
}