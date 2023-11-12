package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.simus.model.Boletim;
import com.pi.simus.servico.IBoletimServico;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("api/v1")
public class APIBoletimController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IBoletimServico boletimServico;

    @CrossOrigin
    @GetMapping(value = "boletim", params = "aluno_id")
    @Transactional
    public ResponseEntity<Object> consultarPorAluno(@RequestParam(value = "aluno_id") Long aluno_id) {
        logger.info("apicontroller consultarPorAluno");

        return ResponseEntity.status(HttpStatus.OK).body(boletimServico.consultaPorAluno(aluno_id));
    }

    @CrossOrigin
    @GetMapping(value = "boletim", params = "semestre")
    @Transactional
    public ResponseEntity<Object> consultarPorSemestre(@RequestParam(value = "semestre") String semestre) {
        logger.info("apicontroller consultaPorSemestre");

        return ResponseEntity.status(HttpStatus.OK).body(boletimServico.consultarPorSemestre(semestre));

    }

    @CrossOrigin
    @PostMapping(value = "boletim", params = "aluno_id")
    @Transactional
    public ResponseEntity<Object> cadastrarBoletim(@RequestParam(value = "aluno_id") Long aluno_id ,@RequestBody Boletim boletim) {
        logger.info("apicontroller cadastrarBoletim");

        return ResponseEntity.status(HttpStatus.OK).body(boletimServico.cadastrarBoletim(boletim, aluno_id));
    }

    @CrossOrigin
    @PatchMapping("boletim")
    @Transactional
    public ResponseEntity<Object> atualizarBoletim(@RequestBody Boletim boletim) {
        logger.info("apicontroller atualizarBoletim");

        return ResponseEntity.status(HttpStatus.OK).body(boletimServico.atualizarBoletim(boletim));
    }

}
