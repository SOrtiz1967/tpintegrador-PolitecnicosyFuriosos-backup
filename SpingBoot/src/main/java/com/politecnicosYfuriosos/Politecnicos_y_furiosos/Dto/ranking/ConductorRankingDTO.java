package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.ranking;


public class ConductorRankingDTO {
    private String nombreCompleto;
    private String dni;
    private Long cantidadTrayectos;

    public ConductorRankingDTO(String nombreCompleto, String dni, Long cantidadTrayectos) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.cantidadTrayectos = cantidadTrayectos;
    }

    // Getters y setters
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public Long getCantidadTrayectos() { return cantidadTrayectos; }
    public void setCantidadTrayectos(Long cantidadTrayectos) { this.cantidadTrayectos = cantidadTrayectos; }
}