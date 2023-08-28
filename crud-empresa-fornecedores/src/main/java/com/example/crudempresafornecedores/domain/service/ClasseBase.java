package com.example.crudempresafornecedores.domain.service;

import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.model.Fornecedor;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import com.example.crudempresafornecedores.rest.dto.PostEmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.PostFonecedorDTO;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ClasseBase {
    public EmpresaDTO buildEmpresaDTO(Empresa empresa) {
        return EmpresaDTO.builder()
                .id(empresa.getId())
                .cnpj(empresa.getCnpj())
                .nomeFantasia(empresa.getNomeFantasia())
                .cep(empresa.getCep())
                .estado(empresa.getEstado())
                .build();
    }
    public List<Fornecedor> buildFornecedores(List<FornecedorDTO> fornecedores) {
        return fornecedores.stream()
                .map(this::buildFornecedor)
                .collect(Collectors.toList());
    }
    public FornecedorDTO buildFornecedorDTO(Fornecedor fornecedor) {
        return FornecedorDTO.builder()
                .id(fornecedor.getId())
                .cnpjCpf(fornecedor.getCnpjCpf())
                .nome(fornecedor.getNome())
                .email(fornecedor.getEmail())
                .cep(fornecedor.getCep())
                .rg(fornecedor.getRg())
                .dataNascimento(fornecedor.getDataNascimento())
                .empresas(buildEmpresasDTOs(fornecedor.getEmpresas()))
                .build();
    }
    public Fornecedor buildFornecedor(FornecedorDTO dto) {
        List<Empresa> empresas = null;
        if(dto.getEmpresas()!= null){
            empresas = buildEmpresas(dto.getEmpresas());
        }
        return Fornecedor.builder()
                .id(dto.getId())
                .cnpjCpf(dto.getCnpjCpf())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cep(dto.getCep())
                .rg(dto.getRg())
                .dataNascimento(dto.getDataNascimento())
                .tipo(dto.getTipo())
                .empresas(empresas)
                .build();
    }
    public Fornecedor buildPostFornecedor(PostFonecedorDTO dto) {
        return Fornecedor.builder()
                .cnpjCpf(dto.getCnpjCpf())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cep(dto.getCep())
                .rg(dto.getRg())
                .dataNascimento(dto.getDataNascimento())
                .tipo(dto.getTipo())
                .build();
    }

    public List<FornecedorDTO> buildFornecedoresDTOs(List<Fornecedor> fornecedores) {
        return fornecedores.stream()
                .map(this::buildFornecedorDTO)
                .collect(Collectors.toList());
    }

    public List<EmpresaDTO> buildEmpresasDTOs(List<Empresa> empresas) {
        return empresas.stream()
                .map(this::buildEmpresaDTO)
                .collect(Collectors.toList());
    }

    public Empresa buildEmpresa(EmpresaDTO empresaDTO) {
        List<Fornecedor> fornecedores = null;
        if(empresaDTO.getFornecedores()!= null){
            fornecedores = buildFornecedores(empresaDTO.getFornecedores());
        }
        return Empresa.builder()
                .id(empresaDTO.getId())
                .cnpj(empresaDTO.getCnpj())
                .nomeFantasia(empresaDTO.getNomeFantasia())
                .cep(empresaDTO.getCep())
                .fornecedores(fornecedores)
                .build();
    }

    public Empresa buildPostEmpresa(PostEmpresaDTO empresaDTO) {
        return Empresa.builder()
                .cnpj(empresaDTO.getCnpj())
                .nomeFantasia(empresaDTO.getNomeFantasia())
                .cep(empresaDTO.getCep())
                .estado(empresaDTO.getEstado())
                .build();
    }

    public List<Empresa> buildEmpresas(List<EmpresaDTO> empresaDTOS) {
        return empresaDTOS.stream()
                .map(this::buildEmpresa)
                .collect(Collectors.toList());
    }
}
