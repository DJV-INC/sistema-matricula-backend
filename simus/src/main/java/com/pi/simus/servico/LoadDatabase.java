package com.pi.simus.servico;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.Boletim;
import com.pi.simus.model.Disciplina;
import com.pi.simus.model.IAlunoRepository;
import com.pi.simus.model.IBoletimRepository;
import com.pi.simus.model.IDisciplinaRepository;
import com.pi.simus.model.IMatriculaRepository;
import com.pi.simus.model.IProfessorRepository;
import com.pi.simus.model.ITurmaRepository;
import com.pi.simus.model.Matricula;
import com.pi.simus.model.Professor;
import com.pi.simus.model.Turma;
import com.pi.simus.model.Boletim.Conceito;
import com.pi.simus.model.StatusMatricula;
import com.pi.simus.model.Disciplina.Tipo;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(IProfessorRepository professorRepository, 
    IAlunoRepository alunoRepository, 
    IDisciplinaRepository disciplinaRepository, 
    ITurmaRepository turmaRepository, 
    IMatriculaRepository matriculaRepository,
    IBoletimRepository boletimRepository) {
        return args -> {
        Aluno aluno1 = new Aluno("12345678910", "580940305", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "teste@gmail.com","11999615887", "Aluno 1");

        Aluno aluno2 = new Aluno("54451318823", "123456789", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "test@gmail.com","11987654321", "Aluno 2");

        Aluno aluno3 = new Aluno("10987654321", "987654321", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "testando@gmail.com","11912345678", "Aluno 3");

        aluno1.setStatusMatricula(StatusMatricula.ATIVA);
        aluno2.setStatusMatricula(StatusMatricula.ATIVA);

        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));

        Professor professor1 = new Professor("Wilson Rezende", "54451318823", "11982942491");

        Professor professor2 = new Professor("Jackeline Paula Teles Menezes", "10987654321", "11999615887");

        Professor professor3 = new Professor("Paulo Domenech", "12345678910", "11927462417");

        professorRepository.saveAll(Arrays.asList(professor1, professor2, professor3));

        Disciplina disciplina1 = new Disciplina("Harmonia", Tipo.OBRIGATORIA);

        Disciplina disciplina2 = new Disciplina("Musica de Câmara", Tipo.OPTATIVA);
        
        Disciplina disciplina3 = new Disciplina("Teoria Musical", Tipo.OBRIGATORIA);

        disciplinaRepository.saveAll(Arrays.asList(disciplina1, disciplina2, disciplina3));

        Turma turma1 = new Turma(professor3, disciplina1, "18:00", 10, 0, "Quinta-feira");

        Turma turma2 = new Turma(professor1, disciplina1, "13:00", 20, 0, "Sexta-feira");

        Turma turma3 = new Turma(professor2, disciplina2, "19:00", 30, 0, "Quarta-feira");
        
        Turma turma4 = new Turma(professor3, disciplina2, "09:00", 15, 0, "Segunda-feira");

        Turma turma5 = new Turma(professor1, disciplina3, "14:00", 15, 0, "Quinta-feira");

        turmaRepository.saveAll(Arrays.asList(turma1,turma2,turma3,turma4, turma5));

        Matricula matricula1 = new Matricula(aluno1, turma1);

        Matricula matricula2 = new Matricula(aluno2, turma2);

        Matricula matricula3 = new Matricula(aluno3, turma3);

        Matricula matricula4 = new Matricula(aluno1, turma2);

        Matricula matricula5 = new Matricula(aluno2, turma1);

        matriculaRepository.saveAll(Arrays.asList(matricula1, matricula2, matricula3, matricula4, matricula5));

        Boletim boletim1 = new Boletim(aluno1, 
        turma1.getDisciplina().getNome(), 
        turma1.getProfessor().getNomeCompleto(), 
        2, 10, Conceito.APROVADO, "1° Semestre 2023");

        boletimRepository.save(boletim1);

        logger.info("Loaddatabase -> alunos, professores, disciplinas, turmas e matriculas cadastradas");
        };
    }
}
