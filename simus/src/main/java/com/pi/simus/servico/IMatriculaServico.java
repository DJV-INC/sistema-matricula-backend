package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;


import com.pi.simus.model.Aluno;
import com.pi.simus.model.Matricula;
import com.pi.simus.model.Turma;

public interface IMatriculaServico {
    public List<Matricula> consultaPorAluno(Optional<Aluno> aluno);
    public List<Matricula> consultaPorTurma(Optional<Turma> turma);
    public Optional<Matricula> cadastrarMatricula(Matricula matricula);
    public Optional<Matricula> atualizarMatricula(Matricula matricula);
    public void excluirMatricula(Long id);
    public void excluirPorAluno(Aluno aluno);
    public void excluirPorTurma(Turma turma);
}
