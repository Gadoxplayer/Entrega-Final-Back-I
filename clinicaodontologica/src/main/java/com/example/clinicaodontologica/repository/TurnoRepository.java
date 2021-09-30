package com.example.clinicaodontologica.repository;
import com.example.clinicaodontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
