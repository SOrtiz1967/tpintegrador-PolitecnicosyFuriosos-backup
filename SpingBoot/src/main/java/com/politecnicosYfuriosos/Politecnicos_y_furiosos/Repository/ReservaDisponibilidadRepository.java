package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository;


import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaDisponibilidadRepository extends JpaRepository<Reserva, Integer> {

    /**
     * Busca reservas 'CONFIRMADAS' para un auto específico en una fecha dada.
     * Comprueba si la fecha solicitada está DENTRO del rango de una reserva.
     */
    @Query("SELECT r FROM Reserva r WHERE r.auto.id = :autoId " +
            "AND r.estado = 'CONFIRMADA' " +
            "AND :fecha >= r.fechaInicio AND :fecha <= r.fechaFin")
    List<Reserva> findOverlappingReservas(
            @Param("autoId") Long autoId, // Asumo que el ID de Auto es Long
            @Param("fecha") LocalDate fecha // <-- Recibimos solo la fecha
    );
}