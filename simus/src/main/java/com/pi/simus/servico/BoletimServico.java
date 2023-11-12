package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.Boletim;
import com.pi.simus.model.IBoletimRepository;
import com.pi.simus.model.IAlunoRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletimServico implements IBoletimServico {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IBoletimRepository boletimRepository;

    @Autowired
    IAlunoRepository alunoRepository;

    @Override
    public List<Boletim> consultaPorAluno(Long id) {
        logger.info("Serviço 'Boletim' consultaPorAluno iniciado");
        
        Optional<Aluno> aluno = alunoRepository.findById(id);

        List<Boletim> boletim = boletimRepository.findByAluno(aluno.get());

        return boletim;

    }

    @Override
    public List<Boletim> consultarPorSemestre(String semestre) {
        logger.info("Serviço 'Boletim' consultaPorSemestre iniciado");

        List<Boletim> boletim = boletimRepository.findBySemestre(semestre);
        
        return boletim;
    }

    @Override
    public Optional<Boletim> cadastrarBoletim(Boletim boletim, Long id) {
        logger.info("Serviço 'Boletim' cadastrar boletim");

        Optional<Aluno> aluno = alunoRepository.findById(id);

        boletim.setAluno(aluno.get());

        return Optional.ofNullable(boletimRepository.save(boletim));
    }

    @Override
    public Optional<Boletim> atualizarBoletim(Boletim newBoletim) {
       
       logger.info("Serviço 'Boletim' atualizarBoletim iniciado");
       
       return boletimRepository.findById(newBoletim.getId())
       .map(boletim -> {
        boletim.setDisciplina(newBoletim.getDisciplina());
        boletim.setProfessor(newBoletim.getProfessor());
        boletim.setFaltas(newBoletim.getFaltas());
        boletim.setSemestre(newBoletim.getSemestre());
        boletim.setNotaFinal(newBoletim.getNotaFinal());
        boletim.setConceito(newBoletim.getConceito());
        return boletimRepository.save(boletim);
       });
    }

    @Override
    public void deletarBoletim(Long id) {
        logger.info("Serviço 'Boletim' deletarBoletim iniciado");

        boletimRepository.deleteById(id);
    }
    
}
