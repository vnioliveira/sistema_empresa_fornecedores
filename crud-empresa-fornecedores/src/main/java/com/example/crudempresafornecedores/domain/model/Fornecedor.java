package com.example.crudempresafornecedores.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false, length = 100, name = "cpf_cnpj" , unique = true)
    private String cnpjCpf;

    @Column(nullable = false, length = 100, name = "nome")
    private String nome;

    @Column(nullable = false, length = 100, name = "email")
    private String email;

    @Column(nullable = false, length = 100, name = "cep")
    private String cep;


    @Column(nullable = false, length = 100, name = "rg")
    private String rg;


    @Column(nullable = false, length = 100, name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 100, name = "tipo")
    private String tipo;

    @ManyToMany(mappedBy = "fornecedores")
    private List<Empresa> empresas = new ArrayList<>();

}