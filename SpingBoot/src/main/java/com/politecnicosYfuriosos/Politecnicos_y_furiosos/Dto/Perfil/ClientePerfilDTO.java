package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Perfil;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.MembershipPlan;

// Este DTO SÍ se puede enviar al frontend de forma segura. No tiene contraseña.
public class ClientePerfilDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private String direccion;
    private String usuario; // email
    private String codigo_postal;
    private String pais;
    private MembershipPlan membresia;

    // --- Getters y Setters para todos los campos ---

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getCodigo_postal() { return codigo_postal; }
    public void setCodigo_postal(String codigo_postal) { this.codigo_postal = codigo_postal; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public MembershipPlan getMembresia() { return membresia; }
    public void setMembresia(MembershipPlan membresia) { this.membresia = membresia; }
}
