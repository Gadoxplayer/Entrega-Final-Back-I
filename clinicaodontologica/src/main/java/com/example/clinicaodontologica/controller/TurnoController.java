package com.example.clinicaodontologica.controller;

import com.example.clinicaodontologica.exceptions.BadRequestException;
import com.example.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaodontologica.model.Odontologo;
import com.example.clinicaodontologica.model.Paciente;
import com.example.clinicaodontologica.model.Turno;
import com.example.clinicaodontologica.service.OdontologoService;
import com.example.clinicaodontologica.service.PacienteService;
import com.example.clinicaodontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        ResponseEntity<Turno> response;

        Paciente paciente = pacienteService.buscarPaciente(turno.getPaciente().getId()).orElse(null);
        Odontologo odongotologo = odontologoService.buscarOdontologo(turno.getOdontologo().getId()).orElse(null);

        turno.setOdontologo(odongotologo);
        turno.setPaciente(paciente);

        response = ResponseEntity.ok(turnoService.crearTurno(turno));


        return response;

    }

    @GetMapping
    public ResponseEntity<Collection<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id) {
        Turno turno = turnoService.buscarTurno(id).orElse(null);

        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {

        turnoService.eliminarTurno(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.modificarTurno(turno));

    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
