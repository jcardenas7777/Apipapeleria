package com.unab.apipapeleria.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apipapeleria.models.peticiones.EmpleadoCrearRequestModel;
import com.unab.apipapeleria.models.respuestas.EmpleadoDataResModel;
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
    public String leerUsuario(){

        return "Jonatan Cardenas";
    }
    
    @PostMapping
    public EmpleadoDataResModel crearEmpleado(@RequestBody EmpleadoCrearRequestModel empleadoCrearRequestModel){

        EmpleadoDto empleadoCrearDto=modelMapper.map(empleadoCrearRequestModel, EmpleadoDto.class);

        EmpleadoDto empleadoDto=iEmpleadoService.crearEmpleado(empleadoCrearDto);

        EmpleadoDataResModel empleadoDataResModel=modelMapper.map(empleadoDto, EmpleadoDataResModel.class);

        return empleadoDataResModel;
    }
}
