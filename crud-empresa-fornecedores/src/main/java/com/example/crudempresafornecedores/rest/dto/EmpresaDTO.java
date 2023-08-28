package com.example.crudempresafornecedores.rest.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class EmpresaDTO {
    @NotNull
    @NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private String cnpj;
    @NotNull
    @NotBlank
    private String nomeFantasia;
    @NotNull
    @NotBlank
    private String cep;
    @NotNull
    @NotBlank
    private String estado;

    private List<FornecedorDTO> fornecedores;
}
