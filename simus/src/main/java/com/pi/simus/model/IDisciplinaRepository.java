package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.simus.model.Disciplina.Tipo;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long>{
    public Optional<Disciplina> findByNome(String nome);
    public List<Disciplina> findByTipo(Tipo tipo);
    public void deleteById(Long id);
}

