package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo.AlertaSinRetornoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConductorRankingDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConteoViajesAutoDTO;
import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrayectosRepository extends JpaRepository<Trayecto, Integer> {

    // Trayectos por ID de cliente
    @Query(value = "SELECT t.* FROM trayecto t " +
            "INNER JOIN reserva r ON t.id_reserva = r.id " +
            "WHERE r.id_cliente = :clienteId",
            nativeQuery = true)
    List<Trayecto> findTrayectosByClienteId(@Param("clienteId") Integer clienteId);

    //agregado de santi para el punto h, ranking de conductores
    @Query("SELECT new com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConductorRankingDTO(" +
            "CONCAT(c.nombre, ' ', c.apellido), " +
            "c.dni, " +
            "COUNT(t)) " +
            "FROM Trayecto t " +
            "JOIN t.reserva r " +
            "JOIN r.clientePrincipal c " +
            "GROUP BY c.id, c.nombre, c.apellido, c.dni " +
            "ORDER BY COUNT(t) DESC")
    List<ConductorRankingDTO> findConductoresRanking();

    //Agregado de santi para el punto d.
    @Query("SELECT new com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking.ConteoViajesAutoDTO(" +
            "a.marca, " +
            "a.modelo, " +
            "COUNT(t)) " +
            "FROM Trayecto t " +
            "JOIN t.reserva r " +
            "JOIN r.auto a " +
            "GROUP BY a.marca, a.modelo " +
            "ORDER BY COUNT(t) DESC")
    List<ConteoViajesAutoDTO> countTrayectosPorAuto();


    // Trayectos por cliente y rango de fechas CON LocalDate
    @Query(value = "SELECT t.* FROM trayecto t " +
            "INNER JOIN reserva r ON t.id_reserva = r.id " +
            "WHERE r.id_cliente = :clienteId " +
            "AND t.fecha_inicio BETWEEN :fechaInicio AND :fechaFin",
            nativeQuery = true)
    List<Trayecto> findTrayectosByClienteIdAndFechas(
            @Param("clienteId") Integer clienteId,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin
    );
    @Query(value = "SELECT " +
            "t.id_trayecto as idTrayecto, " +
            "t.id_reserva as idReserva, " +
            "r.id_auto as idAuto, " +
            "a.modelo as placaAuto, " +  // CAMBIAR: usar 'modelo' en lugar de 'placa'
            "r.id_cliente as idCliente, " +
            "c.nombre as nombreCliente, " +
            "t.fecha_inicio as fechaHoraSalida, " +
            "TIMESTAMPDIFF(HOUR, t.fecha_inicio, NOW()) as horasTranscurridas, " +
            "c.telefono as contacto " +
            "FROM trayecto t " +
            "JOIN reserva r ON t.id_reserva = r.id " +
            "JOIN auto a ON r.id_auto = a.id " +
            "JOIN cliente c ON r.id_cliente = c.id " +
            "WHERE t.fecha_fin IS NULL " +
            "AND TIMESTAMPDIFF(HOUR, t.fecha_inicio, NOW()) > 24",
            nativeQuery = true)
    List<AlertaSinRetornoDTO> findTrayectosSinRetorno24Horas();
}