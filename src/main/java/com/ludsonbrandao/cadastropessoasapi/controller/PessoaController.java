package com.ludsonbrandao.cadastropessoasapi.controller;

import com.ludsonbrandao.cadastropessoasapi.dto.PessoaRequest;
import com.ludsonbrandao.cadastropessoasapi.dto.PessoaResponse;
import com.ludsonbrandao.cadastropessoasapi.model.Pessoa;
import com.ludsonbrandao.cadastropessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable Long id) {
        PessoaResponse pessoa = pessoaService.buscarPessoaPorId(id);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(@RequestBody PessoaRequest pessoaRequest) {
        PessoaResponse pessoaSalva = pessoaService.cadastroPessoa(pessoaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @PutMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Pessoa> alterar(@PathVariable String cpf, @RequestBody PessoaRequest pessoaRequest) {
        Optional<Pessoa> pessoaSalva = pessoaService.atualizaPessoaPorCpf(cpf, pessoaRequest);
        return  ResponseEntity.ok(pessoaSalva.get());
    }

    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{cpf}")
    public void excluirPorCpf(@PathVariable String cpf){
        pessoaService.deletarPessoaPorCpf(cpf);
    }

}
