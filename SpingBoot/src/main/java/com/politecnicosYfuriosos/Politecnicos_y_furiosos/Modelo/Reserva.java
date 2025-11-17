package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente clientePrincipal;

    @ManyToOne
    @JoinColumn(name = "id_auto", nullable = false)
    private Auto auto;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    private double total;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @ManyToMany
    @JoinTable(
            name = "reserva_conductores",
            joinColumns = @JoinColumn(name = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_conductor")
    )
    private List<Cliente> conductoresAdicionales;

    public enum EstadoReserva {
        PENDIENTE, CONFIRMADA, CANCELADA, FINALIZADA
    }

    public enum MetodoPago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }

    // Constructor vacío
    public Reserva() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cliente getClientePrincipal() { return clientePrincipal; }
    public void setClientePrincipal(Cliente clientePrincipal) { this.clientePrincipal = clientePrincipal; }

    public Auto getAuto() { return auto; }
    public void setAuto(Auto auto) { this.auto = auto; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public List<Cliente> getConductoresAdicionales() { return conductoresAdicionales; }
    public void setConductoresAdicionales(List<Cliente> conductoresAdicionales) { this.conductoresAdicionales = conductoresAdicionales; }
}