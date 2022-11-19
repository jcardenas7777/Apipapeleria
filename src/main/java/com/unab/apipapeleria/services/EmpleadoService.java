package com.unab.apipapeleria.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unab.apipapeleria.data.entidades.EmpleadoEntity;
import com.unab.apipapeleria.data.repositorios.IEmpleadoRepository;
import com.unab.apipapeleria.shared.EmpleadoDto;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEmpleadoRepository iEmpleadoRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public EmpleadoDto crearEmpleado(EmpleadoDto empleadoCrearDto) {
        EmpleadoEntity empleadoEntityDto=modelMapper.map(empleadoCrearDto, EmpleadoEntity.class);

        empleadoEntityDto.setIdEmpleado(UUID.randomUUID().toString());
        empleadoEntityDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(empleadoCrearDto.getPassword()));

        EmpleadoEntity empleadoEntity=iEmpleadoRepository.save(empleadoEntityDto);

        EmpleadoDto empleadoDto=modelMapper.map(empleadoEntity, EmpleadoDto.class);
       
         return empleadoDto;
    }
    
}
