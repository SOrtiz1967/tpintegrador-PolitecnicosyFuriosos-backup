package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    private double monto;

    @Column(name = "fecha_pago")
    private LocalDateTime fecha;

    private String descripcion;

    private String numeroTransaccion;

    @Enumerated(EnumType.STRING)
    private Metodo metodo;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    // Constructor vacío
    public Pago() {}

    // Constructor con parámetros
    public Pago(Reserva reserva, double monto, LocalDateTime fecha, Metodo metodo, EstadoPago estado) {
        this.reserva = reserva;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
        this.estado = estado;
    }

    public enum Metodo {
        EFECTIVO, TARJETA, TARJETA_DEBITO, TRANSFERENCIA
    }

    public enum EstadoPago {
        PENDIENTE, COMPLETADO, RECHAZADO, REEMBOLSADO
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    // Métodos utilitarios
    public boolean isCompletado() {
        return estado == EstadoPago.COMPLETADO;
    }

    public boolean isPendiente() {
        return estado == EstadoPago.PENDIENTE;
    }

    public boolean isRechazado() {
        return estado == EstadoPago.RECHAZADO;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", reserva=" + (reserva != null ? reserva.getId() : "null") +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", metodo=" + metodo +
                ", estado=" + estado +
                '}';
    }
}