package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo;

import java.time.LocalDate;

public class ReservaRespDTO {
    private Integer id;
    private String clientePrincipal;
    private String auto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Double total;
    private String mensaje;

    // Constructor vacío
    public ReservaRespDTO() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getClientePrincipal() { return clientePrincipal; }
    public void setClientePrincipal(String clientePrincipal) { this.clientePrincipal = clientePrincipal; }

    public String getAuto() { return auto; }
    public void setAuto(String auto) { this.auto = auto; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}