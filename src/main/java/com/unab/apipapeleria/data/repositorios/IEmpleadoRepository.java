package com.unab.apipapeleria.data.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.apipapeleria.data.entidades.EmpleadoEntity;
@Repository
public interface IEmpleadoRepository extends CrudRepository<EmpleadoEntity,Long> {
    public EmpleadoEntity findByEmail(String email);
    public EmpleadoEntity findByNombre(String nombre);
   
    
}
