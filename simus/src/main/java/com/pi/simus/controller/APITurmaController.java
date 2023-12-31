package com.pi.simus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import com.pi.simus.model.Disciplina;
import com.pi.simus.model.Turma;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.model.Professor;
import com.pi.simus.model.Resposta;
import com.pi.simus.servico.IDisciplinaServico;
import com.pi.simus.servico.IProfessorServico;
import com.pi.simus.servico.ITurmaServico;

import jakarta.servlet.http.HttpServletRequest;
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
    @GetMapping(value = "turmas")
    @Transactional
    public ResponseEntity<Object> consultaTurma(@RequestParam(value = "id", defaultValue = "0") Long id) {

        logger.info("apicontroller consulta turma");

        Optional<Disciplina> dis = disciplinaServico.consultaPorId(id);

        List<Turma> turmas = turmaServico.consultaPorDisciplina(dis);

        return ResponseEntity.status(HttpStatus.OK).body(turmas);
    }

    @CrossOrigin
    @GetMapping(value = "turmas", params = "id_professor")
    @Transactional
    public ResponseEntity<Object> consultaTurmaProfessor(@RequestParam(value = "id_professor") Long id_professor) {
        logger.info("apicontroller consulta turma professor");

        Optional<Professor> professor = professorServico.consultaPorId(id_professor);

        return ResponseEntity.status(HttpStatus.OK).body(turmaServico.consultaPorProfessor(professor));
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
    @PatchMapping("turmas")
    @Transactional
    public ResponseEntity<Object> atualizarTurma(@RequestBody Turma turma) {
        logger.info("apicontroller atualizar turma");

        return ResponseEntity.status(HttpStatus.OK).body(turmaServico.atualizarTurma(turma));
    }

    @CrossOrigin
    @DeleteMapping("turmas/{id}")
    @Transactional
    public ResponseEntity<Object> excluirTurma(@PathVariable Long id, HttpServletRequest req) {
        logger.info("apicontroller excluir turma");

        turmaServico.excluirTurma(id);

        Resposta resposta = new Resposta();

        resposta.setMensagem("Turma deletada com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }
}
