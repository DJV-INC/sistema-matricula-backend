package com.pi.simus.servico;
import java.util.Optional;

import java.util.List;
import com.pi.simus.model.Disciplina;

public interface IDisciplinaServico{
    public List<Disciplina> consultaDisciplina();
    public Optional<Disciplina> consultarPorNome(String nome);
    public Optional<Disciplina> cadastrarDisciplina(Disciplina disciplina);
    public Optional<Disciplina> atualizarDisciplina(Disciplina disciplina);
    public void excluirPorId(Long id);
}