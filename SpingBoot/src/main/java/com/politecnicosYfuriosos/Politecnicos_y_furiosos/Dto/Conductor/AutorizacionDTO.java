package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor;




public class AutorizacionDTO {

    private Integer clienteId; // ID del conductor Cat B (PREMIUM)
    private String nombreModelo;
    private double costo;

    // Getters y Setters
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public String getNombreModelo() { return nombreModelo; }
    public void setNombreModelo(String nombreModelo) { this.nombreModelo = nombreModelo; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}