package com.pi.simus.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.Aluno.StatusMatricula;
import com.pi.simus.model.Resposta;
import com.pi.simus.servico.IAlunoServico;

import jakarta.servlet.http.HttpServletRequest;
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
    @GetMapping(value = "alunos", params = "cpf")
    @Transactional
    public ResponseEntity<Object> consultaPorCpf(@RequestParam(value = "cpf") String cpf) {
        logger.info("apicontroller consulta por cpf");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultarPorCpf(cpf));
    }

    @CrossOrigin
    @GetMapping(value = "alunos", params = "rg")
    @Transactional
    public ResponseEntity<Object> consultarPorRg(@RequestParam(value = "rg") String rg) {
        logger.info("apicontroller consulta por rg");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultarPorRg(rg));
    }

    @CrossOrigin
    @GetMapping(value = "alunos", params = "status")
    @Transactional
    public ResponseEntity<Object> consultarPorStatus(@RequestParam(value = "status") StatusMatricula status) {
        logger.info("apicontroller consulta por status");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.consultarPorStatus(status));
    }

    @CrossOrigin
    @PostMapping("alunos")
    @Transactional
    public ResponseEntity<Object> cadastrarAluno(@RequestBody Aluno aluno) {
        logger.info("apicontroller cadastro aluno");

        Optional<Aluno> cadastrar = alunoServico.cadastrarAluno(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrar);

 
    }

    @CrossOrigin
    @PatchMapping("alunos")
    @Transactional
    public ResponseEntity<Object> atualizarAluno(@RequestBody Aluno aluno) {
        logger.info("apicontroller atualizar aluno");

        return ResponseEntity.status(HttpStatus.OK).body(alunoServico.atualizarAluno(aluno));
    }

    @CrossOrigin
    @DeleteMapping("alunos/{cpf}")
    @Transactional
    public ResponseEntity<Object> excluirAluno(@PathVariable String cpf, HttpServletRequest req) {
        logger.info("apicontroller excluir aluno");

        alunoServico.excluirAluno(cpf);

        Resposta resposta = new Resposta();

        resposta.setMensagem("Aluno deletado com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }

}
