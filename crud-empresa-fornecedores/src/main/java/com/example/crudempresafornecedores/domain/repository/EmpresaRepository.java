package com.example.crudempresafornecedores.domain.repository;

import com.example.crudempresafornecedores.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.nomeFantasia) LIKE LOWER(concat('%', :nome, '%'))")
    Empresa getEmpresaByNomeFantasia(String nome);
}