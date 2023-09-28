package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.simus.model.Aluno;
import com.pi.simus.servico.IAlunoServico;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("api/v1")
public class APIAlunoController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoServico alunoServico;

    @CrossOrigin
    @GetMapping("alunos")
    @Transactional
    public ResponseEntity<Object> consultaAluno() {
        logger.info("apicontroller consulta aluno");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultaAluno());
    }

    @CrossOrigin
    @GetMapping("aluno")
    @Transactional
    public ResponseEntity<Object> consultaPorCpf(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
        logger.info("apicontroller consulta por cpf");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultarPorCpf(cpf));
    }

    @CrossOrigin
    @PostMapping("aluno")
    @Transactional
    public ResponseEntity<Object> cadastrarAluno(@RequestBody Aluno aluno) {
        logger.info("apicontroller cadastro aluno");

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoServico.cadastrarAluno(aluno));
    }

    @CrossOrigin
    @PutMapping("aluno")
    @Transactional
    public ResponseEntity<Object> atualizarAluno(@RequestBody Aluno aluno) {
        logger.info("apicontroller atualizar aluno");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.atualizarAluno(aluno));
    }

    @CrossOrigin
    @DeleteMapping("aluno/{cpf}")
    @Transactional
    public ResponseEntity<Object> excluirAluno(@PathVariable String cpf) {
        logger.info("apicontroller excluir aluno");

        return ResponseEntity.status(HttpStatus.GONE).body(alunoServico.excluirAluno(cpf));
    }
    
}
