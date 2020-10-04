package com.ludsonbrandao.cadastropessoasapi.repository;

import com.ludsonbrandao.cadastropessoasapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    Optional<Pessoa> findByCpf(String cpf);
    void deleteByCpf(String cpf);
}
