package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {
    public List<Matricula> findByAluno(Optional<Aluno> aluno);
    public List<Matricula> findByTurma(Optional<Turma> turma);
    public void deleteByAluno(Aluno aluno);
    public void deleteByTurma(Turma turma);
}
