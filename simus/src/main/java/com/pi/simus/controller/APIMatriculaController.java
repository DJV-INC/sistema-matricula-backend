package com.pi.simus.controller;

import java.util.Optional;
import java.util.List;

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
import com.pi.simus.model.Matricula;
import com.pi.simus.model.Resposta;
import com.pi.simus.model.Turma;
import com.pi.simus.servico.IAlunoServico;
import com.pi.simus.servico.IMatriculaServico;
import com.pi.simus.servico.ITurmaServico;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIMatriculaController {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IMatriculaServico matriculaServico;

    @Autowired
    IAlunoServico alunoServico;

    @Autowired
    ITurmaServico turmaServico;

    @CrossOrigin
    @GetMapping(value = "matriculas", params = "idAluno")
    @Transactional
    public ResponseEntity<Object> consultaPorAluno(@RequestParam(value = "idAluno") Long idAluno) {
        logger.info("apicontroller consultaPorAluno");

        Optional<Aluno> aluno = alunoServico.consultarPorId(idAluno);

        List<Matricula> matricula = matriculaServico.consultaPorAluno(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(matricula);

    }

    @CrossOrigin
    @GetMapping(value = "matriculas", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPorTurma(@RequestParam(value = "id") Long id) {
        logger.info("apicontroller consultaPorTurma");

        Optional<Turma> turma = turmaServico.consultaPorId(id);

        List<Matricula> matriculas = matriculaServico.consultaPorTurma(turma);

        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @CrossOrigin
    @PostMapping("matriculas")
    @Transactional
    public ResponseEntity<Object> cadastrarMatricula(@RequestParam(value = "idAluno") Long idAluno,
            @RequestParam(value = "idTurma") Long idTurma) {

        logger.info("Matricula controller cadastrar Matricula");

        Optional<Aluno> aluno = alunoServico.consultarPorId(idAluno);

        Optional<Turma> turma = turmaServico.consultaPorId(idTurma);

        Matricula matricula = new Matricula();

        matricula.setAluno(aluno.get());
        matricula.setTurma(turma.get());

        return ResponseEntity.status(HttpStatus.OK).body(matriculaServico.cadastrarMatricula(matricula));
    }

    @CrossOrigin
    @PatchMapping("matriculas")
    @Transactional
    public ResponseEntity<Object> atualizarMatricula(@RequestBody Matricula matricula) {
        logger.info("Matricula controller atualizar matricula");

        return ResponseEntity.status(HttpStatus.OK).body(matriculaServico.atualizarMatricula(matricula));
    }

    @CrossOrigin
    @DeleteMapping("matriculas/{id}")
    @Transactional
    public ResponseEntity<Object> deletarMatricula(@PathVariable Long id, HttpServletRequest req) {
        logger.info("Matricula controller deletar matricula");

        matriculaServico.excluirMatricula(id);

        Resposta resposta = new Resposta();

        resposta.setMensagem("Matricula deletada com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }

    @CrossOrigin
    @DeleteMapping(value = "matriculas", params = "cpf")
    @Transactional
    public ResponseEntity<Object> deletarPorAluno(@RequestParam(value = "cpf") String cpf, HttpServletRequest req) {
        logger.info("Matricula controller deletar por aluno");

        matriculaServico.excluirPorAluno(alunoServico.consultarPorCpf(cpf).get());

        Resposta resposta = new Resposta();

        resposta.setMensagem("Matricula deletada com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);

    }

    @CrossOrigin
    @DeleteMapping(value = "matriculas", params = "idTurma")
    @Transactional
    public ResponseEntity<Object> deletarPorTurma(@RequestParam(value = "idTurma") Long id, HttpServletRequest req) {
        logger.info("Matricula controller deletar por turma");

        matriculaServico.excluirPorTurma(turmaServico.consultaPorId(id).get());

        Resposta resposta = new Resposta();

        resposta.setMensagem("Matricula deletada com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }

}
