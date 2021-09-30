package com.example.clinicaodontologica;

import com.example.clinicaodontologica.model.Domicilio;
import com.example.clinicaodontologica.model.Odontologo;
import com.example.clinicaodontologica.model.Paciente;
import com.example.clinicaodontologica.model.Turno;
import com.example.clinicaodontologica.service.OdontologoService;
import com.example.clinicaodontologica.service.PacienteService;
import com.example.clinicaodontologica.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Santiago", "Paz", "88888888", "hoy", domicilio));
        Odontologo o = odontologoService.crearOdontologo(new Odontologo("Santiago", "Paz", 3455647));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Santiago", "Paz", "88888888", "hoy", domicilio));
        Odontologo o = odontologoService.crearOdontologo(new Odontologo("Santiago", "Paz", 3455647));
        Turno t= turnoService.crearTurno(new Turno("15/5441/4",p,o));
        Assert.assertNotNull(turnoService.buscarTurno(t.getId()));
    }
    @Test
    public void buscarTurnoTest(){
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Santiago", "Paz", "88888888", "hoy", domicilio));
        Odontologo o = odontologoService.crearOdontologo(new Odontologo("Santiago", "Paz", 3455647));
        Turno t= turnoService.crearTurno(new Turno("15/5441/4",p,o));

        Assert.assertNotNull(turnoService.buscarTurno(t.getId()));
    }
    @Test
    public void eliminarTurnoTest(){
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Santiago", "Paz", "88888888", "hoy", domicilio));
        Odontologo o = odontologoService.crearOdontologo(new Odontologo("Santiago", "Paz", 3455647));
        Turno t= turnoService.crearTurno(new Turno("15/5441/4",p,o));
        turnoService.eliminarTurno(t.getId());
        Assert.assertFalse(turnoService.buscarTurno(t.getId()).isPresent());
    }
}
