package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.simus.servico.IAlunoServico;


@RestController
@RequestMapping("api/v1")
public class APIAlunoController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoServico alunoServico;

    @CrossOrigin
    @GetMapping("alunos")
    public ResponseEntity<Object> consultaAluno() {
        logger.info("apicontroller consulta aluno");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultaAluno());
    }

    @CrossOrigin
    @GetMapping("aluno")
    public ResponseEntity<Object> consultaPorCpf(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
        logger.info("apicontroller consulta por cpf");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultarPorCpf(cpf));
    }
    
}
