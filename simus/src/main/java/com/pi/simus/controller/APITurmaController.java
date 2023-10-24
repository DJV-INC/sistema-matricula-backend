package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Turma;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.model.Professor;
import com.pi.simus.servico.IDisciplinaServico;
import com.pi.simus.servico.IProfessorServico;
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

    @Autowired
    IProfessorServico professorServico;

    @CrossOrigin
    @GetMapping(value = "turmas", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaTurma(@RequestParam(value = "id") Long id) {

        logger.info("apicontroller consulta turma");

        Optional<Disciplina> dis = disciplinaServico.consultaPorId(id);

        List<Turma> turmas = turmaServico.consultaPorDisciplina(dis);

        return ResponseEntity.status(HttpStatus.OK).body(turmas);
    }

    @CrossOrigin
    @PostMapping(value = "turmas")
    @Transactional
    public ResponseEntity<Object> cadastrarTurma(@RequestParam(value = "professor_id") Long professor_id, 
    @RequestParam(value = "disciplina_id") Long disciplina_id, @RequestBody Turma turma) {

        logger.info("apicontroller cadastrar turma");

        Optional<Professor> prof = professorServico.consultaPorId(professor_id);

        Optional<Disciplina> dis = disciplinaServico.consultaPorId(disciplina_id);

        turma.setProfessor(prof.get());

        turma.setDisciplina(dis.get());

        Optional<Turma> newTurma = turmaServico.cadastrarTurma(turma);

        return ResponseEntity.status(HttpStatus.OK).body(newTurma);
        
    }

    @CrossOrigin
    @PutMapping(value = "turmas")
    @Transactional
    public ResponseEntity<Object> atualizarTurma(@RequestBody Turma turma) {
        logger.info("apicontroller atualizar turma");

        return ResponseEntity.status(HttpStatus.OK).body(turmaServico.atualizarTurma(turma));
    }
}
