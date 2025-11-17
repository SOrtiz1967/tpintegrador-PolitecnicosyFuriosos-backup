package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AutoService {

    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // ❌ ELIMINADO: Constructor duplicado - Lombok @RequiredArgsConstructor lo genera automáticamente

    public List<AutoDTO> obtenerTodosParaCatalogo() {
        return autoRepository.findAll()
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AutoDTO> filtrarPorTipo(String tipo) {
        try {
            Auto.TipoAuto tipoAuto = Auto.TipoAuto.valueOf(tipo.toUpperCase());
            return autoRepository.findByTipo(tipoAuto)
                    .stream()
                    .map(AutoDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de auto inválido: " + tipo);
        }
    }

    public List<AutoDTO> filtrarPorDisponibilidad(Boolean disponible) {
        return autoRepository.findByDisponible(disponible)
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AutoDTO> filtrarPorTipoYDisponibilidad(String tipo, Boolean disponible) {
        try {
            Auto.TipoAuto tipoAuto = Auto.TipoAuto.valueOf(tipo.toUpperCase());
            return autoRepository.findByTipoAndDisponible(tipoAuto, disponible)
                    .stream()
                    .map(AutoDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de auto inválido: " + tipo);
        }
    }

    public List<AutoDTO> buscarPorMarcaOModelo(String search) {
        if (search == null || search.trim().isEmpty()) {
            return obtenerTodosParaCatalogo();
        }

        return autoRepository.searchByMarcaOrModelo(search)
                .stream()
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public AutoDTO obtenerDetallePorId(Integer id) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado con ID: " + id));
        return AutoDTO.fromEntity(auto);
    }

    public List<AutoDTO> obtenerDestacados(int limit) {
        return autoRepository.findDestacados()
                .stream()
                .limit(limit)
                .map(AutoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public AutoDTO obtenerUltimoLanzamiento() {
        Auto auto = autoRepository.findFirstByOrderByAnioDescIdDesc();
        if (auto == null) {
            throw new RuntimeException("No hay autos disponibles");
        }
        return AutoDTO.fromEntity(auto);
    }

    @Transactional
    public AutoDTO crearAuto(AutoDTO autoDTO) {
        Auto auto = autoDTO.toEntity();
        Auto autoGuardado = autoRepository.save(auto);
        return AutoDTO.fromEntity(autoGuardado);
    }

    @Transactional
    public AutoDTO actualizarAuto(Integer id, AutoDTO autoDTO) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado con ID: " + id));

        actualizarEntidadDesdeDTO(auto, autoDTO);
        Auto autoActualizado = autoRepository.save(auto);
        return AutoDTO.fromEntity(autoActualizado);
    }

    @Transactional
    public void eliminarAuto(Integer id) {
        if (!autoRepository.existsById(id)) {
            throw new RuntimeException("Auto no encontrado con ID: " + id);
        }
        autoRepository.deleteById(id);
    }

    private void actualizarEntidadDesdeDTO(Auto auto, AutoDTO dto) {
        auto.setMarca(dto.getMarca());
        auto.setModelo(dto.getModelo());
        auto.setAnio(dto.getAnio());
        auto.setPrecioPorDia(dto.getPrecioPorDia() != null ? dto.getPrecioPorDia().doubleValue() : 0.0);

        // Manejo seguro del tipo
        if (dto.getTipo() != null) {
            try {
                auto.setTipo(Auto.TipoAuto.valueOf(dto.getTipo().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Tipo de auto inválido: " + dto.getTipo());
            }
        }

        auto.setDisponible(dto.getDisponible() != null ? dto.getDisponible() : false);
        auto.setDescripcion(dto.getDescripcion());
        auto.setImagen1(dto.getImagen1());
        auto.setImagen2(dto.getImagen2());
        auto.setImagen3(dto.getImagen3());
        auto.setImagen4(dto.getImagen4());
    }
}