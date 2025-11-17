package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo;



import java.time.LocalDateTime;

public class AlertaSinRetornoDTO {
    private Integer idTrayecto;  // CAMBIAR de idSalida a idTrayecto
    private Integer idReserva;
    private Integer idAuto;
    private String placaAuto;
    private Integer idCliente;
    private String nombreCliente;
    private LocalDateTime fechaHoraSalida;
    private Long horasTranscurridas;
    private String contacto;

    // Constructor
    public AlertaSinRetornoDTO() {}

    // Getters and Setters - CAMBIAR getIdSalida por getIdTrayecto
    public Integer getIdTrayecto() { return idTrayecto; }
    public void setIdTrayecto(Integer idTrayecto) { this.idTrayecto = idTrayecto; }

    public Integer getIdReserva() { return idReserva; }
    public void setIdReserva(Integer idReserva) { this.idReserva = idReserva; }

    public Integer getIdAuto() { return idAuto; }
    public void setIdAuto(Integer idAuto) { this.idAuto = idAuto; }

    public String getPlacaAuto() { return placaAuto; }
    public void setPlacaAuto(String placaAuto) { this.placaAuto = placaAuto; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }

    public Long getHorasTranscurridas() { return horasTranscurridas; }
    public void setHorasTranscurridas(Long horasTranscurridas) { this.horasTranscurridas = horasTranscurridas; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }
}