package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import com.pi.simus.model.Aluno;

public interface IAlunoServico {
    public Optional<Aluno> consultarPorCpf(String cpf);
    public Optional<Aluno> consultarPorRg(String rg);
    public Optional<Aluno> consultarPorStatus(boolean status);
    public List<Aluno> consultaAluno();
    public Optional<Aluno> cadastrarAluno(Aluno aluno);
    public Optional<Aluno> atualizarAluno(Aluno aluno);
    public void excluirAluno(Aluno aluno);
}
