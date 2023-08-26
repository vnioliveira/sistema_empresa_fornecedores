package com.example.crudempresafornecedores.rest.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@Builder
public class PostFonecedorDTO {
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
}
