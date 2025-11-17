package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Service;



import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
// Importa el repositorio que ya confirmaste que sirve
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.ReservaDisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DisponibilidadService {

    // 1. Inyectamos el repositorio que SÍ tiene la lógica correcta
    @Autowired
    private ReservaDisponibilidadRepository reservaRepository;

    /**
     * [cite_start]Implementa la lógica de: GET /api/salidas/disponibilidad [cite: 57-60]
     * Verifica si existe un trayecto/reserva para un auto en una fecha dada.
     */
    public boolean verificarDisponibilidadAuto(Long autoId, LocalDateTime fechaHoraSolicitada) {

        // 2. Convertimos el LocalDateTime (fecha y hora) a un LocalDate (solo fecha)
        // Esto es necesario porque tu repositorio y tu entidad 'Reserva' usan LocalDate.
        LocalDate fechaSolicitada = fechaHoraSolicitada.toLocalDate();

        // 3. Consultamos al repositorio si hay reservas que se superpongan
        List<Reserva> overlaps = reservaRepository.findOverlappingReservas(autoId, fechaSolicitada);

        // 4. Si la lista está vacía (overlaps.isEmpty() == true),
        //    significa que NO hay trayectos, por lo tanto ESTÁ disponible.
        //    Si la lista tiene algo, ESTÁ ocupado (devuelve false).
        return overlaps.isEmpty();
    }
}