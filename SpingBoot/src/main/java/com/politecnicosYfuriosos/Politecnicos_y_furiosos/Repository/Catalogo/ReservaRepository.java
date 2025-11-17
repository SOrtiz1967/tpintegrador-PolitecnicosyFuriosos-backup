package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // 🔹 Buscar reservas superpuestas para un auto en fechas específicas
    @Query("SELECT r FROM Reserva r WHERE r.auto.id = :idAuto " +
            "AND r.estado IN ('CONFIRMADA', 'PENDIENTE') " +
            "AND ((r.fechaInicio BETWEEN :fechaInicio AND :fechaFin) " +
            "OR (r.fechaFin BETWEEN :fechaInicio AND :fechaFin) " +
            "OR (:fechaInicio BETWEEN r.fechaInicio AND r.fechaFin))")
    List<Reserva> findReservasSuperpuestas(@Param("idAuto") Integer idAuto,
                                           @Param("fechaInicio") LocalDate fechaInicio,
                                           @Param("fechaFin") LocalDate fechaFin);

    // 🔹 Buscar reservas VIP superpuestas
    @Query("SELECT r FROM Reserva r WHERE r.auto.id = :idAuto " +
            "AND r.clientePrincipal.vip = true " +
            "AND r.estado IN ('CONFIRMADA', 'PENDIENTE') " +
            "AND ((r.fechaInicio BETWEEN :fechaInicio AND :fechaFin) " +
            "OR (r.fechaFin BETWEEN :fechaInicio AND :fechaFin) " +
            "OR (:fechaInicio BETWEEN r.fechaInicio AND r.fechaFin))")
    List<Reserva> findReservasVipSuperpuestas(@Param("idAuto") Integer idAuto,
                                              @Param("fechaInicio") LocalDate fechaInicio,
                                              @Param("fechaFin") LocalDate fechaFin);

    // 🔹 Buscar reservas por cliente
    @Query("SELECT r FROM Reserva r WHERE r.clientePrincipal.id = :idCliente ORDER BY r.fechaInicio DESC")
    List<Reserva> findByClienteId(@Param("idCliente") Integer idCliente);

    // 🔹 Buscar reservas por auto
    @Query("SELECT r FROM Reserva r WHERE r.auto.id = :idAuto ORDER BY r.fechaInicio DESC")
    List<Reserva> findByAutoId(@Param("idAuto") Integer idAuto);

    // 🔹 Buscar reservas por estado
    List<Reserva> findByEstado(Reserva.EstadoReserva estado);

    // 🔹 Buscar reservas activas (fecha actual dentro del rango)
    @Query("SELECT r FROM Reserva r WHERE r.estado = 'CONFIRMADA' " +
            "AND :fechaActual BETWEEN r.fechaInicio AND r.fechaFin")
    List<Reserva> findReservasActivas(@Param("fechaActual") LocalDate fechaActual);

    // 🔹 Buscar reservas que empiezan hoy
    @Query("SELECT r FROM Reserva r WHERE r.estado = 'CONFIRMADA' AND r.fechaInicio = :fecha")
    List<Reserva> findReservasQueInicianHoy(@Param("fecha") LocalDate fecha);

    // 🔹 Buscar reservas que finalizan hoy
    @Query("SELECT r FROM Reserva r WHERE r.estado = 'CONFIRMADA' AND r.fechaFin = :fecha")
    List<Reserva> findReservasQueFinalizanHoy(@Param("fecha") LocalDate fecha);

    // 🔹 Contar reservas por cliente
    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.clientePrincipal.id = :idCliente")
    Long countByClienteId(@Param("idCliente") Integer idCliente);

    // 🔹 Calcular ingresos totales por auto
    @Query("SELECT SUM(r.total) FROM Reserva r WHERE r.auto.id = :idAuto AND r.estado = 'FINALIZADA'")
    Double calcularIngresosPorAuto(@Param("idAuto") Integer idAuto);

    // 🔹 Buscar reservas por rango de fechas
    @Query("SELECT r FROM Reserva r WHERE r.fechaInicio BETWEEN :fechaInicio AND :fechaFin ORDER BY r.fechaInicio")
    List<Reserva> findByRangoFechas(@Param("fechaInicio") LocalDate fechaInicio,
                                    @Param("fechaFin") LocalDate fechaFin);

    // 🔹 Buscar reservas por método de pago
    List<Reserva> findByMetodoPago(Reserva.MetodoPago metodoPago);

    // 🔹 Verificar si un cliente tiene reservas activas
    @Query("SELECT COUNT(r) > 0 FROM Reserva r WHERE r.clientePrincipal.id = :idCliente " +
            "AND r.estado = 'CONFIRMADA' AND :fechaActual BETWEEN r.fechaInicio AND r.fechaFin")
    Boolean tieneReservasActivas(@Param("idCliente") Integer idCliente,
                                 @Param("fechaActual") LocalDate fechaActual);

    // 🔹 Obtener reservas con conductores adicionales
    @Query("SELECT DISTINCT r FROM Reserva r JOIN r.conductoresAdicionales c WHERE c.id = :idConductor")
    List<Reserva> findReservasComoConductorAdicional(@Param("idConductor") Integer idConductor);

    // 🔹 Buscar próximas reservas (próximos 7 días)
    @Query("SELECT r FROM Reserva r WHERE r.estado = 'CONFIRMADA' " +
            "AND r.fechaInicio BETWEEN :hoy AND :proximaSemana ORDER BY r.fechaInicio")
    List<Reserva> findProximasReservas(@Param("hoy") LocalDate hoy,
                                       @Param("proximaSemana") LocalDate proximaSemana);

    List<Reserva> findByClientePrincipalId(Integer idCliente);
}