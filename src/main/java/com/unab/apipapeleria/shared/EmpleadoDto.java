package com.unab.apipapeleria.shared;

import java.io.Serializable;

public class EmpleadoDto implements Serializable {

    private static final long serialVersionUID=1L;
    private long id;
    private String IdEmpleado;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String passworEncriptada;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdEmpleado() {
        return this.IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassworEncriptada() {
        return this.passworEncriptada;
    }

    public void setPassworEncriptada(String passworEncriptada) {
        this.passworEncriptada = passworEncriptada;
    }

}
