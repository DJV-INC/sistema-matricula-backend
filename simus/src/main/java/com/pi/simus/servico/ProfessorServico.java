package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.IProfessorRepository;
import com.pi.simus.model.Professor;

@Service
public class ProfessorServico implements IProfessorServico {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IProfessorRepository professorRepository;

    @Override
    public Optional<Professor> consultaPorCpf(String cpf) {
        logger.info("Serviço 'Professor' consultaPorCpf iniciado");

        Optional<Professor> professor = professorRepository.findByCpf(cpf);

        return professor;
    }

    @Override
    public List<Professor> consultaPorNomeCompleto(String nomeCompleto) {
        logger.info("Serviço 'Professor' consultaPorNomeCompleto iniciado");

        List<Professor> professor = professorRepository.findByNomeCompleto(nomeCompleto);

        return professor;
    }

    @Override
    public List<Professor> consultaProfessor() {
        logger.info("Serviço 'Professor' consulta todos iniciado");

        List<Professor> professores = professorRepository.findAll();

        return professores;
    }

    @Override
    public Optional<Professor> cadastrarProfessor(Professor professor) {
        logger.info("Serviço 'Professor' cadastrarProfessor iniciado");

        return Optional.ofNullable(professorRepository.save(professor));
    }

    @Override
    public Optional<Professor> atualizarProfessor(Professor newProfessor) {
        logger.info("Serviço 'Professor' atualizarProfessor iniciado");

        return professorRepository.findById(newProfessor.getId())
      .map(professor -> {
        professor.setNomeCompleto(newProfessor.getNomeCompleto());
        professor.setCpf(newProfessor.getCpf());
        professor.setTelefone(newProfessor.getTelefone());
        return professorRepository.save(professor);
      });
    }

    @Override
    public void excluirProfessor(Long id) {
        logger.info("Serviço 'Professor' excluirProfessor iniciado");

        professorRepository.deleteById(id);
    }
    
}
