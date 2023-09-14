package com.um.practicoPersistencia.repositorios;

import com.um.practicoPersistencia.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
