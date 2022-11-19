package com.unab.apipapeleria.models.respuestas;

public class EmpleadoDataResModel {
    private String IdEmpleado;
    private String nombre;
    private String apellidos;
    private String email;

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
  
}
