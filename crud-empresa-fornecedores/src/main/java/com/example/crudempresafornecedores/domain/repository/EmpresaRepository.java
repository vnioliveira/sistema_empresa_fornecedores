package com.example.crudempresafornecedores.domain.repository;

import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.nomeFantasia) LIKE LOWER(concat('%', :nome, '%'))")
    Empresa getEmpresaByNomeFantasia(String nome);

    List<Empresa> findByCnpjContaining(String cnpj);

    @Query("SELECT e.fornecedores FROM Empresa e WHERE e.id = :empresaId")
    List<Fornecedor> buscarFornecedoresPorIdDaEmpresa(Long empresaId);

    @Query("SELECT f FROM Fornecedor f WHERE f.id NOT IN (SELECT ef.id FROM Empresa e JOIN e.fornecedores ef WHERE e.id = :empresaId)")
    List<Fornecedor> buscarFornecedoresNaoAssociadosPorIdDaEmpresa(Long empresaId);

}
