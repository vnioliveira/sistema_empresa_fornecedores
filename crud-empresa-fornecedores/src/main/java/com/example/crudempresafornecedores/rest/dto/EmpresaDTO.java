package com.example.crudempresafornecedores.rest.dto;

import com.example.crudempresafornecedores.domain.model.Fornecedor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmpresaDTO {

    private String cnpj;
    private String nomeFantasia;
    private String cep;
    private List<Fornecedor> fornecedores;
}
