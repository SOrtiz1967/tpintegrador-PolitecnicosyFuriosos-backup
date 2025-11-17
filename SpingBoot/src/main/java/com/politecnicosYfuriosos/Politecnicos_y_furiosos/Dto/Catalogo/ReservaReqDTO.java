package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo;

import java.time.LocalDate;
import java.util.List;

public class ReservaReqDTO {
    private Integer idClientePrincipal;
    private Integer idAuto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Integer> idsConductoresAdicionales;
    private String metodoPago;

    // Constructor vacío
    public ReservaReqDTO() {}

    // Getters y Setters
    public Integer getIdClientePrincipal() { return idClientePrincipal; }
    public void setIdClientePrincipal(Integer idClientePrincipal) { this.idClientePrincipal = idClientePrincipal; }

    public Integer getIdAuto() { return idAuto; }
    public void setIdAuto(Integer idAuto) { this.idAuto = idAuto; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public List<Integer> getIdsConductoresAdicionales() { return idsConductoresAdicionales; }
    public void setIdsConductoresAdicionales(List<Integer> idsConductoresAdicionales) { this.idsConductoresAdicionales = idsConductoresAdicionales; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}