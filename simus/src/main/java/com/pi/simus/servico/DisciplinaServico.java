package com.pi.simus.servico;

import java.util.Optional;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Disciplina.Tipo;
import com.pi.simus.model.IDisciplinaRepository;
import com.pi.simus.servico.IDisciplinaServico;

@Service
public class DisciplinaServico implements IDisciplinaServico{
    
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IDisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> consultaDisciplina() {
        logger.info("Serviço 'Disciplina' consultar iniciado");  
        
        List<Disciplina> disciplina = disciplinaRepository.findAll();

        return disciplina;

    }

    

    @Override
    public Optional<Disciplina> consultarPorNome(String nome) {
        logger.info("Serviço 'Disciplina' consultar por nome iniciado");

        Optional<Disciplina> disciplina = disciplinaRepository.findByNome(nome);

        return disciplina;

    }

    @Override
    public List<Disciplina> consultaPorTipo(Tipo tipo) {
        logger.info("Serviço 'Disciplina' consultar por tipo iniciado");

        List<Disciplina> disciplinas = disciplinaRepository.findByTipo(tipo);

        return disciplinas;
    }

    @Override
    public Optional<Disciplina> consultaPorId(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        return disciplina;
    }

    @Override
    public Optional<Disciplina> cadastrarDisciplina(Disciplina disciplina) {
       logger.info("Serviço 'Disciplina' cadastrar disciplina iniciado");

       return Optional.ofNullable(disciplinaRepository.save(disciplina));
    }

    @Override
    public Optional<Disciplina> atualizarDisciplina(Disciplina newDisciplina) {
        logger.info("Serviço 'Disciplina' atualizar iniciado");

        return disciplinaRepository.findById(newDisciplina.getId())
        .map(disciplina -> {
            disciplina.setNome(newDisciplina.getNome());
            disciplina.setTipo(newDisciplina.getTipo());
            return disciplinaRepository.save(disciplina);
        });
    }

    @Override
    public void excluirPorId(Long id) {
        logger.info("Serviço 'Disciplina' excluir por id iniciado");

        disciplinaRepository.deleteById(id);
    }



    

    

}