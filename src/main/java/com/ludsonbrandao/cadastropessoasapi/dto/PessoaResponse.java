package com.ludsonbrandao.cadastropessoasapi.dto;

import com.ludsonbrandao.cadastropessoasapi.model.Pessoa;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PessoaResponse {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;

    public PessoaResponse(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento();
        this.email = pessoa.getEmail();
    }
}
