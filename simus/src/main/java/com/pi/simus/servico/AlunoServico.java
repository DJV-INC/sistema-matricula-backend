package com.pi.simus.servico;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.IAlunoRepository;

@Service
public class AlunoServico implements IAlunoServico {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoRepository alunoRepository;

    @Override
    public Optional<Aluno> consultarPorCpf(String cpf) {
        logger.info("serviço consulta por cpf iniciado");
        Optional<Aluno> aluno = alunoRepository.findByCpf(cpf);

        return aluno;

    }

    @Override
    public Optional<Aluno> consultarPorRg(String rg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorRg'");
    }

    @Override
    public Optional<Aluno> consultarPorStatus(boolean status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorStatus'");
    }

    @Override
    public List<Aluno> consultaAluno() {
        logger.info("serviço consulta todos iniciado");
        List<Aluno> alunos = alunoRepository.findAll();

        return alunos;
    }

    @Override
    public Optional<Aluno> cadastrarAluno(Aluno aluno) {
        logger.info("serviço cadastrar aluno iniciado");

        return Optional.ofNullable(alunoRepository.save(aluno));
    }

    @Override
    public Optional<Aluno> atualizarAluno(Aluno newAluno) {
        logger.info("serviço atualizar aluno iniciado");

        return alunoRepository.findByCpf(newAluno.getCpf())
      .map(aluno -> {
        aluno.setCep(newAluno.getCep());
        aluno.setEstado(newAluno.getEstado());
        aluno.setCidade(newAluno.getCidade());
        aluno.setBairro(newAluno.getBairro());
        aluno.setLogradouro(newAluno.getLogradouro());
        aluno.setNumero(newAluno.getNumero());
        aluno.setEmail(newAluno.getEmail());
        aluno.setNomeCompleto(newAluno.getNomeCompleto());
        aluno.setRg(newAluno.getRg());
        aluno.setStatus(true);
        return alunoRepository.save(aluno);
      });
    }

    @Override
    public String excluirAluno(String cpf) {
        logger.info("serviço excluir aluno iniciado");

        return alunoRepository.deleteByCpf(cpf);
    }

}
