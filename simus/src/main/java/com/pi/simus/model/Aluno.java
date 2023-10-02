package com.pi.simus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * nome completo, e-mail, RG, CPF, !!!!!!data de nascimento!!!!!!, endereço, !!!!!!!telefone!!!!!!!
 */

@Entity
public class Aluno {

    public enum StatusMatricula {
        ATIVA,
        INATIVA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cpf;

    private String rg;

    private String dataNasc;

    private String cep;

    private String estado;

    private String cidade;

    private String bairro;

    private String logradouro;

    private int numero;

    private String email;

    private String telefone;

    private String nomeCompleto;

    private StatusMatricula statusMatricula = StatusMatricula.INATIVA;

    public Aluno() {

    }



    public Aluno(String cpf, String rg, String dataNasc, String cep, String estado, String cidade, String bairro, String logradouro, int numero, String email, String telefone, String nomeCompleto) {
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.email = email;
        this.telefone = telefone;
        this.nomeCompleto = nomeCompleto;
    }
    


    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da rua inválido");

        } else {
            this.numero = numero;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public StatusMatricula getStatusMatricula() {
        return this.statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

}
