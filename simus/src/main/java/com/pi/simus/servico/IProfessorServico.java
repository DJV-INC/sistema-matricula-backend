package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;


import com.pi.simus.model.Professor;

public interface IProfessorServico {
    public Optional<Professor> consultaPorId(Long Id);
    public Optional<Professor> consultaPorCpf(String cpf);
    public List<Professor> consultaPorNomeCompleto(String nomeCompleto);
    public List<Professor> consultaProfessor();
    public Optional<Professor> cadastrarProfessor(Professor professor);
    public Optional<Professor> atualizarProfessor(Professor professor);
    public void excluirProfessor(Long id);
}
