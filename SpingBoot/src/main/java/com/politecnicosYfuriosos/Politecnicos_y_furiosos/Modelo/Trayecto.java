package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Trayecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrayecto;  // ← Cambié a camelCase

    private String direccionOrigen;  // ← camelCase
    private String direccionDestino; // ← camelCase
    private LocalDate fechaInicio;   // ← camelCase
    private LocalDate fechaFin;      // ← camelCase

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    // Constructor
    public Trayecto(Integer idTrayecto, String direccionOrigen, String direccionDestino,
                    LocalDate fechaInicio, LocalDate fechaFin, Reserva reserva) {
        this.idTrayecto = idTrayecto;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.reserva = reserva;
    }

    public Trayecto() {}

    // Getters y Setters con nombres consistentes
    public Integer getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}