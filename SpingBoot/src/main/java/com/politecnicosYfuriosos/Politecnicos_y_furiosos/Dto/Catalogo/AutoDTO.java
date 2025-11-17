package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Catalogo;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Auto;
import java.math.BigDecimal;

public class AutoDTO {

    private Integer id;
    private String marca;
    private String modelo;
    private Integer anio;
    private BigDecimal precioPorDia;
    private String tipo;
    private Boolean disponible;
    private String descripcion;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;

    // Constructores
    public AutoDTO() {}

    public AutoDTO(Integer id, String marca, String modelo, Integer anio, BigDecimal precioPorDia,
                   String tipo, Boolean disponible, String descripcion, String imagen1,
                   String imagen2, String imagen3, String imagen4) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioPorDia = precioPorDia;
        this.tipo = tipo;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.imagen4 = imagen4;
    }

    // ✅ Conversión de entidad a DTO - SIN BUILDER
    public static AutoDTO fromEntity(Auto auto) {
        if (auto == null) return null;

        AutoDTO dto = new AutoDTO();
        dto.setId(auto.getId());
        dto.setMarca(auto.getMarca());
        dto.setModelo(auto.getModelo());
        dto.setAnio(auto.getAnio());
        dto.setPrecioPorDia(BigDecimal.valueOf(auto.getPrecioPorDia()));
        dto.setTipo(auto.getTipo() != null ? auto.getTipo().name() : null);
        dto.setDisponible(auto.isDisponible());
        dto.setDescripcion(auto.getDescripcion());
        dto.setImagen1(auto.getImagen1());
        dto.setImagen2(auto.getImagen2());
        dto.setImagen3(auto.getImagen3());
        dto.setImagen4(auto.getImagen4());

        return dto;
    }

    // ✅ Conversión inversa de DTO a entidad
    public Auto toEntity() {
        Auto auto = new Auto();
        auto.setId(this.id);
        auto.setMarca(this.marca);
        auto.setModelo(this.modelo);
        auto.setAnio(this.anio != null ? this.anio : 0);
        auto.setPrecioPorDia(this.precioPorDia != null ? this.precioPorDia.doubleValue() : 0.0);

        // Manejo seguro del tipo
        if (this.tipo != null) {
            try {
                auto.setTipo(Auto.TipoAuto.valueOf(this.tipo.toUpperCase()));
            } catch (IllegalArgumentException e) {
                auto.setTipo(null);
            }
        }

        auto.setDisponible(this.disponible != null ? this.disponible : false);
        auto.setDescripcion(this.descripcion);
        auto.setImagen1(this.imagen1);
        auto.setImagen2(this.imagen2);
        auto.setImagen3(this.imagen3);
        auto.setImagen4(this.imagen4);
        return auto;
    }

    // Getters y Setters (necesarios sin Lombok)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public BigDecimal getPrecioPorDia() { return precioPorDia; }
    public void setPrecioPorDia(BigDecimal precioPorDia) { this.precioPorDia = precioPorDia; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Boolean getDisponible() { return disponible; }
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

    @Override
    public String toString() {
        return "AutoDTO{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioPorDia=" + precioPorDia +
                ", tipo='" + tipo + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}