package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.Boletim;

public interface IBoletimServico {
    public List<Boletim> consultaPorAluno(Long id);
    public List<Boletim> consultarPorSemestre(String semestre);
    public Optional<Boletim> cadastrarBoletim(Boletim boletim, Long id);
    public Optional<Boletim> atualizarBoletim(Boletim boletim);
    public void deletarBoletim(Long id);
}
