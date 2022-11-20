package com.unab.apipapeleria.services;

import com.unab.apipapeleria.shared.EmpleadoDto;

public interface IEmpleadoService {
    public EmpleadoDto crearEmpleado(EmpleadoDto empleadoCrearDto);
    public EmpleadoDto leerEmpleado(String nombre);
    public EmpleadoDto actualizarEmpleado(EmpleadoDto actualizarEmpleado,String nombre);
    public void eliminarEmpleado(String nombre);
}
