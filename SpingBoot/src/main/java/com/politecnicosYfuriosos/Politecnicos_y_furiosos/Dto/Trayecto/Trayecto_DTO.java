package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Trayecto;

import java.time.LocalDate;

public class Trayecto_DTO {
    private String origen;
    private String destino;
    private String autoUtilizado;
    private LocalDate fecha;

    public Trayecto_DTO(String origen, String destino, String autoUtilizado, LocalDate fecha) {
        this.origen = origen;
        this.destino = destino;
        this.autoUtilizado = autoUtilizado;
        this.fecha = fecha;
    }

    public Trayecto_DTO(){}

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAutoUtilizado() {
        return autoUtilizado;
    }

    public void setAutoUtilizado(String autoUtilizado) {
        this.autoUtilizado = autoUtilizado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}