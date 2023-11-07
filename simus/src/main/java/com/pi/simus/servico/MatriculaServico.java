package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.IMatriculaRepository;
import com.pi.simus.model.Matricula;
import com.pi.simus.model.Turma;


@Service
public class MatriculaServico implements IMatriculaServico {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IMatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> consultaPorAluno(Optional<Aluno> aluno) {
       logger.info("Serviço 'Matricula' consulta por aluno");

       return matriculaRepository.findByAluno(aluno);
    }

    @Override
    public List<Matricula> consultaPorTurma(Optional<Turma> turma) {
       logger.info("Serviço 'Matricula' consulta por turma");

       return matriculaRepository.findByTurma(turma);
    }

    @Override
    public Optional<Matricula> cadastrarMatricula(Matricula matricula) {
        logger.info("Serviço 'Matricula' cadastrar matricula");

        return Optional.ofNullable(matriculaRepository.save(matricula));
    }

    @Override
    public Optional<Matricula> atualizarMatricula(Matricula newMatricula) {
        logger.info("Serviço 'Matricula' atualizar matricula");

        return matriculaRepository.findById(newMatricula.getId())
        .map(matricula -> {
            matricula.setTurma(newMatricula.getTurma());
            return matriculaRepository.save(matricula);
        });
    }

    @Override
    public void excluirMatricula(Long id) {
        logger.info("Serviço 'Matricula' excluir matricula");

        matriculaRepository.deleteById(id);
    }

    @Override
    public void excluirPorAluno(Aluno aluno) {
        logger.info("Serviço 'Matricula' excluir por aluno");

        matriculaRepository.deleteByAluno(aluno);
    }

    @Override
    public void excluirPorTurma(Turma turma) {
        logger.info("Serviço 'Matricula' excluir por turma");

        matriculaRepository.deleteByTurma(turma);
    }
    
}
