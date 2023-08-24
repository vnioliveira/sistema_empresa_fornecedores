package com.example.crudempresafornecedores.domain.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false, length = 100, name = "cnpj")
    private String cnpj;

    @Column(nullable = false, length = 100, name = "nome_fantasia")
    private String nomeFantasia;

    @Column(nullable = false, length = 100, name = "cep")
    private String cep;

    @OneToMany(mappedBy = "empresa",cascade = CascadeType.REMOVE)
    private List<Fornecedor> fornecedores;

}