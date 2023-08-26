package com.example.crudempresafornecedores.rest.dto;

import com.example.crudempresafornecedores.domain.validator.ValidacaoEmpresaFornecedor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@ValidacaoEmpresaFornecedor
public class FornecedorDTO {

    @NotNull
    @NotBlank
    private String cnpjCpf;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String cep;
    @NotNull
    @NotBlank
    private String rg;
    @NotNull
    @NotBlank
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    private String tipo;
    @NotNull
    @NotBlank
    private List<EmpresaDTO> empresas;

}
