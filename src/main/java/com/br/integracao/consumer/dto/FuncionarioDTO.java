package com.br.integracao.consumer.dto;

import java.time.LocalDate;

public class FuncionarioDTO {

    public Long id;
    public String nome;
    public String cpf;
    public LocalDate dataContratacao;

    public FuncionarioDTO(Long id, String nome, String cpf, LocalDate dataContratacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
    }

    public FuncionarioDTO(String nome, String cpf, LocalDate dataContratacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
    }
    public FuncionarioDTO(String nome) {
        this.nome = nome;
    }

    public FuncionarioDTO(){}
}
