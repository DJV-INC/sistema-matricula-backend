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
        List<Aluno> alunos = alunoRepository.findAll();

        return alunos;
    }

    @Override
    public Optional<Aluno> cadastrarAluno(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public Optional<Aluno> atualizarAluno(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluirAluno(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
    
}
