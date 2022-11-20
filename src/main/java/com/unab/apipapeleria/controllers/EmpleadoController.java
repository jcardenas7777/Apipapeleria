package com.unab.apipapeleria.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apipapeleria.models.peticiones.EmpleadoActualizarRequestModel;
import com.unab.apipapeleria.models.peticiones.EmpleadoCrearRequestModel;
import com.unab.apipapeleria.models.respuestas.EmpleadoDataResModel;
import com.unab.apipapeleria.models.respuestas.MensajeRestModel;
import com.unab.apipapeleria.services.IEmpleadoService;
import com.unab.apipapeleria.shared.EmpleadoDto;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpleadoService iEmpleadoService;


    @GetMapping
    public EmpleadoDataResModel leerUsuario(){
        String nombre="Jonatan Estiben";

        EmpleadoDto empleadoDto=iEmpleadoService.leerEmpleado(nombre);

        EmpleadoDataResModel empleadoDataResModel= modelMapper.map(empleadoDto, EmpleadoDataResModel.class);

        return empleadoDataResModel;
    }
    
    @PostMapping
    public EmpleadoDataResModel crearEmpleado(@RequestBody EmpleadoCrearRequestModel empleadoCrearRequestModel){

        EmpleadoDto empleadoCrearDto=modelMapper.map(empleadoCrearRequestModel, EmpleadoDto.class);

        EmpleadoDto empleadoDto=iEmpleadoService.crearEmpleado(empleadoCrearDto);

        EmpleadoDataResModel empleadoDataResModel=modelMapper.map(empleadoDto, EmpleadoDataResModel.class);

        return empleadoDataResModel;
    }
      
  @PutMapping(path = "/{nombre}")
  public EmpleadoDataResModel actualizarEmpleado(@PathVariable String nombre,@RequestBody EmpleadoActualizarRequestModel empleadoActualizarRequestModel){
  nombre="Jonatan Estiben";     

  EmpleadoDto empleadoActualizarDto=modelMapper.map(empleadoActualizarRequestModel, EmpleadoDto.class);
  empleadoActualizarDto.setNombre(nombre);

  EmpleadoDto empleadoDto=iEmpleadoService.actualizarEmpleado(empleadoActualizarDto, nombre);

  EmpleadoDataResModel empleadoDataResModel=modelMapper.map(empleadoDto, EmpleadoDataResModel.class);

        return empleadoDataResModel;     
   }


   @DeleteMapping(path = "/{nombre}")
   public MensajeRestModel eliminarEmpleado(@PathVariable String nombre){
    EmpleadoDto empleadoDto=iEmpleadoService.leerEmpleado(nombre);
    MensajeRestModel mensajeRestModel=new MensajeRestModel();
    mensajeRestModel.setNombre("Eliminar");
    iEmpleadoService.eliminarEmpleado(empleadoDto.getNombre());
    mensajeRestModel.setResultado("Empleado eliminado");
    return mensajeRestModel;

 
   }
   
}
