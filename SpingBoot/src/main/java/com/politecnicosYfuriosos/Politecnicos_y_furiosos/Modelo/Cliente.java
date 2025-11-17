package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String pais;
    private String telefono;
    private String dni;
    private String direccion;
    private String usuario;
    private String contrasena;
    private String codigo_postal;
    private boolean vip;
    private boolean habilitado;

    @Enumerated(EnumType.STRING)
    private CategoriaLicencia categoriaLicencia;

    @Enumerated(EnumType.STRING)
    private MembershipPlan membresia;

    @OneToMany(mappedBy = "clientePrincipal")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "cliente")
    private List<ReservaGaraje> reservasGaraje;

    public void setMembresia(com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.MembershipPlan membershipPlan) {
    }

    public enum CategoriaLicencia {
        A, B, C, D, E
    }

    public enum MembershipPlan {
        NULL, BASICO, PREMIUM, VIP
    }

    // Constructor vacío
    public Cliente() {}

    // Getters y Setters COMPLETOS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getCodigo_postal() { return codigo_postal; }
    public void setCodigo_postal(String codigo_postal) { this.codigo_postal = codigo_postal; }

    public boolean isVip() { return vip; }
    public void setVip(boolean vip) { this.vip = vip; }

    public boolean isHabilitado() { return habilitado; }
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }

    public CategoriaLicencia getCategoriaLicencia() { return categoriaLicencia; }
    public void setCategoriaLicencia(CategoriaLicencia categoriaLicencia) { this.categoriaLicencia = categoriaLicencia; }

    public MembershipPlan getMembresia() { return membresia; }
    public void setMembresia(MembershipPlan membresia) { this.membresia = membresia; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public List<ReservaGaraje> getReservasGaraje() { return reservasGaraje; }
    public void setReservasGaraje(List<ReservaGaraje> reservasGaraje) { this.reservasGaraje = reservasGaraje; }
}