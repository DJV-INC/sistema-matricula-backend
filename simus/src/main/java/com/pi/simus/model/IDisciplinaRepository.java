package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long>{
    public Optional<Disciplina> findById(Long id);
    public Optional<Disciplina> findByNome(String nome);
    public void deleteById(Long id);
}

