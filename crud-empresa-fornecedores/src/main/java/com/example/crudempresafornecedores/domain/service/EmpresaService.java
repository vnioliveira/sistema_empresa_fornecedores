package com.example.crudempresafornecedores.domain.service;

import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.repository.EmpresaRepository;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public void cadastrarEmpresa(EmpresaDTO dto) {
        Empresa empresa = buildEmpresa(dto);
        empresaRepository.save(empresa);
    }
    public ResponseEntity<EmpresaDTO> buscarEmpresaPorNome(String nome) {
        Empresa empresa = empresaRepository.getEmpresaByNomeFantasia(nome);
        EmpresaDTO empresaDTO = buildEmpresaDTO(empresa);
        return ResponseEntity.ok(empresaDTO);
    }

    public List<EmpresaDTO> listarEmpresas() {
        List<Empresa>
        empresas = empresaRepository.findAll();

        return empresas.stream()
                .map(this::buildEmpresaDTO)
                .collect(Collectors.toList());

    }

    public ResponseEntity<Object> atualizarEmpresa(Long id, EmpresaDTO dto) {
        if (empresaRepository.existsById(id)) {
            Empresa empresaAtualizada = buildEmpresa(dto);
            empresaAtualizada.setId(id);
            empresaRepository.save(empresaAtualizada);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> removerEmpresa(Long id) {
        Optional<Empresa> empresaDTO = empresaRepository.findById(id);
        if (empresaDTO.isPresent()){
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public EmpresaDTO buildEmpresaDTO(Empresa empresa) {
        return EmpresaDTO.builder()
                .cnpj(empresa.getCnpj())
                .nomeFantasia(empresa.getNomeFantasia())
                .cep(empresa.getCep())
                .fornecedores(empresa.getFornecedores())
                .build();
    }

    public static Empresa buildEmpresa(EmpresaDTO enderecoDTO) {
        return Empresa.builder()
                .cnpj(enderecoDTO.getCnpj())
                .nomeFantasia(enderecoDTO.getNomeFantasia())
                .cep(enderecoDTO.getCep())
                .fornecedores(enderecoDTO.getFornecedores())
                .build();
    }


}
