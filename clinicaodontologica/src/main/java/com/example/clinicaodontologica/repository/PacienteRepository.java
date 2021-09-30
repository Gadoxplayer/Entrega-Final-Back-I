package com.example.clinicaodontologica.repository;
import com.example.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
