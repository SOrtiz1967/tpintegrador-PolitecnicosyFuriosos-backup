package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modelo;
    private Integer anio;
    private Double precioPorDia;

    @Enumerated(EnumType.STRING)
    private TipoAuto tipo;

    private Boolean disponible;
    private String descripcion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;

    @OneToMany(mappedBy = "auto")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "auto")
    private List<Resenia> resenias;

    public enum TipoAuto {
        DEPORTIVO, SUV, SEDAN, CLASICO, COUPE, CONVERTIBLE
    }

    // Constructor vacío
    public Auto() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public Double getPrecioPorDia() { return precioPorDia; }
    public void setPrecioPorDia(Double precioPorDia) { this.precioPorDia = precioPorDia; }

    public TipoAuto getTipo() { return tipo; }
    public void setTipo(TipoAuto tipo) { this.tipo = tipo; }

    public Boolean isDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagen1() { return imagen1; }
    public void setImagen1(String imagen1) { this.imagen1 = imagen1; }

    public String getImagen2() { return imagen2; }
    public void setImagen2(String imagen2) { this.imagen2 = imagen2; }

    public String getImagen3() { return imagen3; }
    public void setImagen3(String imagen3) { this.imagen3 = imagen3; }

    public String getImagen4() { return imagen4; }
    public void setImagen4(String imagen4) { this.imagen4 = imagen4; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public List<Resenia> getResenias() { return resenias; }
    public void setResenias(List<Resenia> resenias) { this.resenias = resenias; }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioPorDia=" + precioPorDia +
                ", tipo=" + tipo +
                ", disponible=" + disponible +
                '}';
    }
}