package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITurmaRepository extends JpaRepository<Turma, Long>{
    public List<Turma> findByDisciplina(Optional<Disciplina> disciplina);
}