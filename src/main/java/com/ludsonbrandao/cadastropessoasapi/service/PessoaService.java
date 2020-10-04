package com.ludsonbrandao.cadastropessoasapi.service;

import com.ludsonbrandao.cadastropessoasapi.dto.PessoaRequest;
import com.ludsonbrandao.cadastropessoasapi.dto.PessoaResponse;
import com.ludsonbrandao.cadastropessoasapi.model.Pessoa;
import com.ludsonbrandao.cadastropessoasapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaResponse buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(PessoaResponse::new)
                .orElseThrow();
    }

    public PessoaResponse cadastroPessoa(PessoaRequest pessoaRequest){
        Pessoa pessoa = pessoaRequest.converterDTOEmPessoa();
        pessoaRepository.save(pessoa);
        return new PessoaResponse(pessoa);
    }

    public Optional<Pessoa> atualizaPessoaPorCpf(String cpf, PessoaRequest pessoaRequest){
        return pessoaRepository.findByCpf(cpf)
                .map(pessoa -> {
                 pessoa.setNome(pessoaRequest.getNome());
                 pessoa.setEmail(pessoaRequest.getEmail());
                 pessoa.setDataNascimento(pessoaRequest.getDataNascimento());
                 pessoaRepository.save(pessoa);
                 return Optional.of(pessoa);
                })
                .orElse(Optional.empty());
    }

    public void deletarPessoaPorCpf(String cpf){
        pessoaRepository.deleteByCpf(cpf);
    }

}
