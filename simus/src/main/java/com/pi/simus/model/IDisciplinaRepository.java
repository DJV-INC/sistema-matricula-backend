package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.simus.model.Disciplina.Tipo;

import java.util.List;
import java.util.Optional;

public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long>{
    public Optional<Disciplina> findByNome(String nome);
    public List<Disciplina> findByTipo(Tipo tipo);
    public void deleteById(Long id);
}

