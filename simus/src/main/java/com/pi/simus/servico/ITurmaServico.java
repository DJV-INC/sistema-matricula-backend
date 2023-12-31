package com.pi.simus.servico;

import java.util.Optional;
import java.util.List;
import com.pi.simus.model.Turma;
import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Professor;

public interface ITurmaServico{
    public Optional<Turma> consultaPorId(Long id);
    public List<Turma> consultaPorDisciplina(Optional<Disciplina> disciplina);
    public List<Turma> consultaPorProfessor(Optional<Professor> professor);
    public Optional<Turma> cadastrarTurma(Turma turma);
    public Optional<Turma> atualizarTurma(Turma turma);
    public void excluirTurma(Long id);
}