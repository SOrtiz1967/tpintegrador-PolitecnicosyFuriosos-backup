package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking;



public class ConteoViajesAutoDTO {
    private String marca;
    private String modelo;
    private Long cantidadViajes;

    public ConteoViajesAutoDTO(String marca, String modelo, Long cantidadViajes) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadViajes = cantidadViajes;
    }

    // Getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Long getCantidadViajes() { return cantidadViajes; }
    public void setCantidadViajes(Long cantidadViajes) { this.cantidadViajes = cantidadViajes; }
}
