package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;


import jakarta.persistence.*;


@Entity
public class ModeloAutorizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "registrar los modelos de autos que están autorizados a manejar"
    private String nombreModelo;

    // "junto con el costo que deben abonar"
    private double costo;

    // "Relaciono ModeloAutorizado con Cliente"
    // Esto crea la columna 'cliente_id' para saber de quién es esta autorización
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Constructores, Getters y Setters
    public ModeloAutorizado() {}

    public ModeloAutorizado(String nombreModelo, double costo, Cliente cliente) {
        this.nombreModelo = nombreModelo;
        this.costo = costo;
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreModelo() { return nombreModelo; }
    public void setNombreModelo(String nombreModelo) { this.nombreModelo = nombreModelo; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}