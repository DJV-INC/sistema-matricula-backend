package com.pi.simus.model;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "Id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "Id")
    private Disciplina disciplina;

    private String horario;

    private int numeroVagas;

    private int numeroAlunos;


    private String diaSemana;

    public Turma() {

    }


    public Turma(Professor professor, Disciplina disciplina, String horario, int numeroVagas, int numeroAlunos, String diaSemana) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
        this.numeroVagas = numeroVagas;
        this.numeroAlunos = numeroAlunos;
        this.diaSemana = diaSemana;
    }


    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumeroVagas() {
        return this.numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public int getNumeroAlunos() {
        return this.numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public String getDiaSemana() {
        return this.diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    
}
