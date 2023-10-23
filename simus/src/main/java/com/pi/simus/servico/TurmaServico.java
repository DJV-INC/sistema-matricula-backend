package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Disciplina;
import com.pi.simus.model.IDisciplinaRepository;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.model.Turma;


@Service
public class TurmaServico implements ITurmaServico {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    ITurmaRepository turmaRepository;

    @Autowired
    IDisciplinaRepository disciplinaRepository;

    @Override
    public List<Turma> consultaPorDisciplina(Optional<Disciplina> disciplina) {

        List<Turma> turmas = turmaRepository.findByDisciplina(disciplina);

        return turmas;
    }

    @Override
    public Optional<Turma> cadastrarTurma(Turma turma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarTurma'");
    }

    @Override
    public Optional<Turma> atualizarTurma(Turma turma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarTurma'");
    }

    @Override
    public void excluirTurma(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirTurma'");
    }


}
