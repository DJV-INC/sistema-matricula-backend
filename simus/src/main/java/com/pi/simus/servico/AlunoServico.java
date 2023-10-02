package com.pi.simus.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.IAlunoRepository;
import com.pi.simus.model.Aluno.StatusMatricula;

@Service
public class AlunoServico implements IAlunoServico {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoRepository alunoRepository;

    @Override
    public Optional<Aluno> consultarPorCpf(String cpf) {
        logger.info("Serviço 'Aluno' consultarPorCpf iniciado");
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
        logger.info("Serviço 'Aluno' consulta todos iniciado");
        List<Aluno> alunos = alunoRepository.findAll();

        return alunos;
    }

    @Override
    public Optional<Aluno> cadastrarAluno(Aluno aluno) {
        logger.info("Serviço 'Aluno' cadastrarAluno iniciado");

        return Optional.ofNullable(alunoRepository.save(aluno));
    }

    @Override
    public Optional<Aluno> atualizarAluno(Aluno newAluno) {
        logger.info("Serviço 'Aluno' atualizarAluno iniciado");

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
        aluno.setDataNasc(newAluno.getDataNasc());
        aluno.setTelefone(newAluno.getTelefone());
        aluno.setStatusMatricula(StatusMatricula.ATIVA);
        return alunoRepository.save(aluno);
      });
    }

    @Override
    public String excluirAluno(String cpf) {
        logger.info("Serviço 'Aluno' excluirAluno iniciado");

        return alunoRepository.deleteByCpf(cpf);
    }

}
