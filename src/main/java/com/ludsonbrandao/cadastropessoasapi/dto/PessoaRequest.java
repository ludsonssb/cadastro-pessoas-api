package com.ludsonbrandao.cadastropessoasapi.dto;

import com.ludsonbrandao.cadastropessoasapi.model.Pessoa;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaRequest {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;

    public Pessoa converterDTOEmPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setEmail(this.email);

        return pessoa;
    }
}
