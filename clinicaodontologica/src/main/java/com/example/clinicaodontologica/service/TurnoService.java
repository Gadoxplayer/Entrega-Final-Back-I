package com.example.clinicaodontologica.service;

import com.example.clinicaodontologica.model.Odontologo;
import com.example.clinicaodontologica.model.Turno;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TurnoService {

    Optional<Turno> buscarTurno (Long id);
    Turno crearTurno(Turno turno);
    Turno modificarTurno(Turno turno);
    String eliminarTurno(Long id);
    Collection<Turno> listar();

}
