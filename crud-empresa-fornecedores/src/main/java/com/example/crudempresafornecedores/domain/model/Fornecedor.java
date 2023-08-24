package com.example.crudempresafornecedores.domain.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "fornecedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "cpf_cnpj")
    private String cnpjCpf;

    @Column(nullable = false, length = 100, name = "nome")
    private String nome;

    @Column(nullable = false, length = 100, name = "email")
    private String email;


    @Column(nullable = false, length = 100, name = "cep")
    private String cep;


    @Column(nullable = false, length = 100, name = "rg")
    private String rg;


    @Column(nullable = false, length = 100, name = "dataNascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}