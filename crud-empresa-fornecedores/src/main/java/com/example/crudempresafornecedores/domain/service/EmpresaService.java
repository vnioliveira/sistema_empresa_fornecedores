package com.example.crudempresafornecedores.domain.service;

import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.model.Fornecedor;
import com.example.crudempresafornecedores.domain.repository.EmpresaRepository;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import com.example.crudempresafornecedores.rest.dto.PostEmpresaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaService extends ClasseBase{

    private final EmpresaRepository empresaRepository;

    public void cadastrarEmpresa(PostEmpresaDTO dto) {
        Empresa empresa = buildPostEmpresa(dto);
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

    public ResponseEntity<Object> atualizarEmpresa(Long id, PostEmpresaDTO dto) {
        if (empresaRepository.existsById(id)) {
            Empresa empresaAtualizada = buildPostEmpresa(dto);
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

    public ResponseEntity<List<EmpresaDTO>> buscarEmpresasPorCnpj(String cnpj) {
        List<Empresa> empresas  = empresaRepository.findByCnpjContaining(cnpj);
        List<EmpresaDTO> empresasDTOs = buildEmpresasDTOs(empresas);
        return ResponseEntity.ok(empresasDTOs);
    }

    public ResponseEntity<EmpresaDTO> getEmpresaById(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            EmpresaDTO empresaDTO = buildEmpresaDTO(empresa);
            return ResponseEntity.ok(empresaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<FornecedorDTO>> getFornecedoresByEmpresaId(Long id) {
        List<Fornecedor> fornecedorses = empresaRepository.buscarFornecedoresPorIdDaEmpresa(id);
        List<FornecedorDTO> fornecedorDTOS = buildFornecedoresDTOs(fornecedorses);
        return ResponseEntity.ok(fornecedorDTOS);
    }

    public ResponseEntity<List<FornecedorDTO>> getFornecedoresDesassociados(Long id) {
        List<Fornecedor> fornecedores = empresaRepository.buscarFornecedoresNaoAssociadosPorIdDaEmpresa(id);
        List<FornecedorDTO> fornecedorDTOS = buildFornecedoresDTOs(fornecedores);
        return ResponseEntity.ok(fornecedorDTOS);
    }
}
