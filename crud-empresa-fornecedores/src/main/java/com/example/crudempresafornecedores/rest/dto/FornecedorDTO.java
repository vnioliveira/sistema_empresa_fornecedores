package com.example.crudempresafornecedores.rest.dto;

import com.example.crudempresafornecedores.domain.model.Empresa;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FornecedorDTO {

    private String cnpjCpf;
    private String nome;
    private String email;
    private String cep;
    private String rg;
    private LocalDate dataNascimento;
    private Empresa empresa;
}
