package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.simus.model.Professor;
import com.pi.simus.servico.IProfessorServico;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIProfessorController {
    Logger logger = LogManager.getLogger(this.getClass());
    
    @Autowired
    IProfessorServico professorServico;

    @CrossOrigin
    @GetMapping("professores")
    @Transactional
    public ResponseEntity<Object> consultaProfessor() {
        logger.info("apicontroller consulta professor");

        return ResponseEntity.status(HttpStatus.OK).body(professorServico.consultaProfessor());
    }

    @CrossOrigin
    @GetMapping(value = "professores", params = "cpf")
    @Transactional
    public ResponseEntity<Object> consultaPorCpf(@RequestParam(value = "cpf") String cpf) {
        logger.info("apicontroller consulta professor por cpf");

        return ResponseEntity.status(HttpStatus.OK).body(professorServico.consultaPorCpf(cpf));
    }

    @CrossOrigin
    @GetMapping(value = "professores", params = "nomeCompleto")
    @Transactional
    public ResponseEntity<Object> consultaPorNomeCompleto(@RequestParam(value = "nomeCompleto") String nomeCompleto) {
        logger.info("apicontroller consulta professor por nome completo");

        return ResponseEntity.status(HttpStatus.OK).body(professorServico.consultaPorNomeCompleto(nomeCompleto));
    }

    @CrossOrigin
    @PostMapping("professores")
    @Transactional
    public ResponseEntity<Object> cadastrarProfessor(@RequestBody Professor professor) {
        logger.info("apicontroller cadastrar professor");

        return ResponseEntity.status(HttpStatus.OK).body(professorServico.cadastrarProfessor(professor));
    }

    @CrossOrigin
    @PatchMapping("professores")
    @Transactional
    public ResponseEntity<Object> atualizarProfessor(@RequestBody Professor professor) {
        logger.info("apicontroller atualizar professor");

        return ResponseEntity.status(HttpStatus.OK).body(professorServico.atualizarProfessor(professor));

    }

    
    @CrossOrigin
    @DeleteMapping("professores/{id}")
    @Transactional
    public ResponseEntity<Object> excluirProfessor(@PathVariable Long id) {
        logger.info("apicontroller excluir professor");

        professorServico.excluirProfessor(id);

        return ResponseEntity.status(HttpStatus.OK).body("Professor excluído");
    }
}
