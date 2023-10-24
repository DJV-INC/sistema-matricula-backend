package com.pi.simus.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Disciplina;
import com.pi.simus.model.IDisciplinaRepository;
import com.pi.simus.model.IProfessorRepository;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.model.Turma;


@Service
public class TurmaServico implements ITurmaServico {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    ITurmaRepository turmaRepository;

    @Autowired
    IDisciplinaRepository disciplinaRepository;

    @Autowired
    IProfessorRepository professorRepository;

    @Override
    public List<Turma> consultaPorDisciplina(Optional<Disciplina> disciplina) {
        logger.info("Serviço 'Turma' consultaPorDisciplina iniciado");

        List<Turma> turmas = turmaRepository.findByDisciplina(disciplina);

        return turmas;
    }

    @Override
    public Optional<Turma> consultaPorId(Long id) {
        logger.info("Serviço 'Turma' consultaPorId iniciado");

        return turmaRepository.findById(id);
    }

    @Override
    public Optional<Turma> cadastrarTurma(Turma turma) {
        logger.info("Serviço 'Turma' consultaPorDisciplina iniciado");

        return Optional.ofNullable(turmaRepository.save(turma));
    }

    @Override
    public Optional<Turma> atualizarTurma(Turma newTurma) {
        logger.info("Serviço 'Turma' atualizarTurma");

        return turmaRepository.findById(newTurma.getId())
        .map(turma -> {
            turma.setProfessor(newTurma.getProfessor());
            turma.setHorario(newTurma.getHorario());
            turma.setNumeroVagas(newTurma.getNumeroVagas());
            turma.setNumeroAlunos(newTurma.getNumeroAlunos());
            turma.setDiaSemana(newTurma.getDiaSemana());
            return turmaRepository.save(turma);
        });
    }

    @Override
    public void excluirTurma(Long id) {
        logger.info("Serviço 'Turma' ExcluirTurma");

        turmaRepository.deleteById(id);
    }


}
