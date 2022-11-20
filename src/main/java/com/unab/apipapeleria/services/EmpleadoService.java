package com.unab.apipapeleria.services;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        if(iEmpleadoRepository.findByEmail(empleadoCrearDto.getEmail())!=null){
            throw new RuntimeException("Este correo ya se encuantra registrado");
        }
     


        EmpleadoEntity empleadoEntityDto=modelMapper.map(empleadoCrearDto, EmpleadoEntity.class);

        empleadoEntityDto.setIdEmpleado(UUID.randomUUID().toString());
        empleadoEntityDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(empleadoCrearDto.getPassword()));

        EmpleadoEntity empleadoEntity=iEmpleadoRepository.save(empleadoEntityDto);

        EmpleadoDto empleadoDto=modelMapper.map(empleadoEntity, EmpleadoDto.class);
       
         return empleadoDto;
    }

    @Override
    public EmpleadoDto leerEmpleado(String nombre) {
       EmpleadoEntity empleadoEntity=iEmpleadoRepository.findByNombre(nombre);
       if(empleadoEntity==null){
            throw new UsernameNotFoundException(nombre);

       }
       EmpleadoDto empleadoDto=modelMapper.map(empleadoEntity, EmpleadoDto.class);
        return empleadoDto;
    }

    @Override
    public EmpleadoDto actualizarEmpleado(EmpleadoDto actualizarEmpleado, String IdEmpleado) {
        EmpleadoEntity empleadoEntity=iEmpleadoRepository.findByNombre(IdEmpleado);
        if(empleadoEntity.getNombre()!=empleadoEntity.getNombre()){
            throw new RuntimeException("No se puede actualizar este empleado");
        }
        empleadoEntity.setNombre(actualizarEmpleado.getNombre());
        empleadoEntity.setApellidos(actualizarEmpleado.getApellidos());
        empleadoEntity.setEmail(actualizarEmpleado.getEmail());
        empleadoEntity.setPasswordEncriptada(actualizarEmpleado.getPassword());

        EmpleadoEntity empleadoEntityActualizado=iEmpleadoRepository.save(empleadoEntity);

        EmpleadoDto empleadoDto=modelMapper.map(empleadoEntityActualizado, EmpleadoDto.class);
        
        return empleadoDto;
    }

    @Override
    public void eliminarEmpleado(String nombre) {
      EmpleadoEntity empleadoEntity=iEmpleadoRepository.findByNombre(nombre);
      empleadoEntity.setNombre(nombre);

      if(empleadoEntity.getNombre()!=empleadoEntity.getNombre()){
        throw new RuntimeException("No puede eleiminar esten Empleado");


      }
      iEmpleadoRepository.delete(empleadoEntity);
        
    }

  
    
}
