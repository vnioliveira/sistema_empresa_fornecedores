package com.example.crudempresafornecedores.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "cnpj", unique = true)
    private String cnpj;

    @Column(nullable = false, length = 100, name = "nome_fantasia")
    private String nomeFantasia;

    @Column(nullable = false, length = 100, name = "cep")
    private String cep;

    @Column(nullable = false, length = 100, name = "estado")
    private String estado;

    @ManyToMany
    @JoinTable(
            name = "empresa_fornecedor",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
    )
    private List<Fornecedor> fornecedores = new ArrayList<>();

}