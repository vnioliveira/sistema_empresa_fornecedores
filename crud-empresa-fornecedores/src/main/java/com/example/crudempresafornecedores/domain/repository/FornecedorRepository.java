package com.example.crudempresafornecedores.domain.repository;

import com.example.crudempresafornecedores.domain.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    @Query("SELECT f FROM Fornecedor f WHERE LOWER(f.nome) LIKE LOWER(concat('%', :nome, '%'))")
    Fornecedor getFornecedorByNome(String nome);

    List<Fornecedor> findByCnpjCpfContaining(String cnpjCpf);
}
