package com.example.clinicaodontologica.service;
import com.example.clinicaodontologica.model.Paciente;

import java.util.List;
import java.util.Optional;


public interface PacienteService {

    Optional<Paciente> buscarPaciente (Long id);
    Paciente crearPaciente(Paciente paciente);
    Paciente modificarPaciente(Paciente paciente);
    String eliminarPaciente(Long id);
    List<Paciente> buscarTodos();
}
