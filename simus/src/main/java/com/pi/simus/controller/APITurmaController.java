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

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Turma;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.servico.IDisciplinaServico;
import com.pi.simus.servico.ITurmaServico;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("api/v1")
public class APITurmaController {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    ITurmaServico turmaServico;

    @Autowired
    IDisciplinaServico disciplinaServico;

    @CrossOrigin
    @GetMapping(value = "turmas", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaTurma(@RequestParam(value = "id") Long id) {
        Optional<Disciplina> dis = disciplinaServico.consultaPorId(id);

        List<Turma> turmas = turmaServico.consultaPorDisciplina(dis);

        return ResponseEntity.status(HttpStatus.OK).body(turmas);
    }
}
