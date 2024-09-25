package com.ingenieria_de_software.repository;

import com.ingenieria_de_software.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
    // Aquí puedes definir consultas personalizadas si es necesario.
}
