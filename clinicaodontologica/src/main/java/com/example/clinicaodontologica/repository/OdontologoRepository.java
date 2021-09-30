package com.example.clinicaodontologica.repository;
import com.example.clinicaodontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
