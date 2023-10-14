package com.pi.simus.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IProfessorRepository extends JpaRepository<Professor, Long> {
    public Optional<Professor> findByCpf(String cpf);
    public List<Professor> findByNomeCompleto(String nomeCompleto);
}
