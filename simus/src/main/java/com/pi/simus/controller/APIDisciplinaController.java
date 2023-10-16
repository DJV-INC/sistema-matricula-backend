package com.pi.simus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pi.simus.servico.IDisciplinaServico;

import jakarta.transaction.Transactional;

import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Disciplina.Tipo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("api/v1")
public class APIDisciplinaController{
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IDisciplinaServico disciplinaServico;

    @CrossOrigin
    @GetMapping("disciplinas")
    @Transactional
    public ResponseEntity<Object> consultaDisciplina(){

        logger.info("apicontroller consulta disciplina");
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServico.consultaDisciplina());
    }

    @CrossOrigin
    @GetMapping(value = "disciplinas", params = "nome")
    @Transactional
    public ResponseEntity<Object> consultarPorNome(@RequestParam(value = "nome") String nome){

        logger.info("apicontroller consultar por nome");
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServico.consultarPorNome(nome));
    }

    @CrossOrigin
    @GetMapping(value = "disciplinas", params = "tipo")
    @Transactional
    public ResponseEntity<Object> consultarPorTipo(@RequestParam(value = "tipo") Tipo tipo) {
        logger.info("apicontroller consultar por tipo");

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServico.consultaPorTipo(tipo));
    }

    @CrossOrigin
    @PostMapping("disciplinas")
    @Transactional
    public ResponseEntity<Object> cadastrarDisciplina(@RequestBody Disciplina disciplina){

        logger.info("apicontroller cadastrar disciplina");
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServico.cadastrarDisciplina(disciplina));
    
    }

    @CrossOrigin
    @PatchMapping("disciplinas")
    @Transactional
    public ResponseEntity<Object> atualizarDisciplina(@RequestBody Disciplina disciplina){

        logger.info("apicontroller atualizar disciplina");
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServico.atualizarDisciplina(disciplina));

    }

    @CrossOrigin
    @DeleteMapping("disciplinas/{id}")
    @Transactional
    public ResponseEntity<Object> deletarDisciplinas(@PathVariable Long id){

        logger.info("apicontroller deletar disciplina");

        disciplinaServico.excluirPorId(id);


        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada");

    }

}