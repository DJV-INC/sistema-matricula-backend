package com.pi.simus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Boletim {

    public enum Conceito {
        APROVADO,
        REPROVADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "Id")
    private Aluno aluno;

    private String disciplina;

    private String professor;

    private int faltas;

    private double notaFinal;

    private Conceito conceito;

    private String semestre;

    public Boletim(){
        
    }

    public Boletim(Aluno aluno, String disciplina, String professor, int faltas, double notaFinal, Conceito conceito, String semestre) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.professor = professor;
        this.faltas = faltas;
        this.notaFinal = notaFinal;
        this.conceito = conceito;
        this.semestre = semestre;
    }


    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getFaltas() {
        return this.faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public double getNotaFinal() {
        return this.notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Conceito getConceito() {
        return this.conceito;
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }

    public String getSemestre() {
        return this.semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }


}