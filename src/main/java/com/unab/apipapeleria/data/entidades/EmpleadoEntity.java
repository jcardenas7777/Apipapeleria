package com.unab.apipapeleria.data.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;



@Entity(name = "empleado")
@Table(indexes = {
    @Index(columnList = "IdEmpleado",name = "index_IdEmpleado",unique = true),
    @Index(columnList = "email",name = "index_email",unique = true),

})
public class EmpleadoEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String IdEmpleado;

    @Column(nullable = false , length = 100)
    private String nombre;

    @Column(nullable = false,length = 50)
    private String apellidos;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false,length = 100)
    private String passwordEncriptada;

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


    public String getPasswordEncriptada() {
        return this.passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }
    
}
