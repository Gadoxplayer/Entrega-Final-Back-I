package com.example.clinicaodontologica.repository;
import com.example.clinicaodontologica.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
