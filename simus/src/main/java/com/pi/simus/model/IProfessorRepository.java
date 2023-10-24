package com.pi.simus.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
    public Optional<Professor> findById(Long id);
    public Optional<Professor> findByCpf(String cpf);
    public List<Professor> findByNomeCompleto(String nomeCompleto);
}
