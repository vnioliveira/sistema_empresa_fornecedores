package com.example.crudempresafornecedores.domain.service;

import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.repository.EmpresaRepository;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.PostEmpresaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<Empresa> empresas = empresaRepository.findAll();
        return buildEmpresasDTOs(empresas);
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

}
