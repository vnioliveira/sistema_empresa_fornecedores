package com.example.crudempresafornecedores.domain.service;


import com.example.crudempresafornecedores.domain.model.Fornecedor;
import com.example.crudempresafornecedores.domain.repository.FornecedorRepository;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import com.example.crudempresafornecedores.rest.dto.PostFonecedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService extends ClasseBase {
    private final FornecedorRepository fornecedorRepository;
    public void cadastrarFornecedor(PostFonecedorDTO dto) {
        Fornecedor fornecedor = buildPostFornecedor(dto);
        fornecedorRepository.save(fornecedor);
    }
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorNome(String nome) {
        Fornecedor fornecedor = fornecedorRepository.getFornecedorByNome(nome);
        FornecedorDTO fornecedorDTO = buildFornecedorDTO(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    public List<FornecedorDTO> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return buildFornecedoresDTOs(fornecedores);
    }

    public ResponseEntity<Object> atualizarFornecedor(Long id, PostFonecedorDTO dto) {
        if (fornecedorRepository.existsById(id)) {
            Fornecedor fornecedorAtualizada = buildPostFornecedor(dto);
            fornecedorAtualizada.setId(id);
            fornecedorRepository.save(fornecedorAtualizada);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> removerFornecedor(Long id) {
        Optional<Fornecedor> fornecedorDTO = fornecedorRepository.findById(id);
        if (fornecedorDTO.isPresent()){
            fornecedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<FornecedorDTO>> buscarFornecedoresPorCnpjCpf(String cnpjCpf) {
        List<Fornecedor> fornecedores  = fornecedorRepository.findByCnpjCpfContaining(cnpjCpf);
        List<FornecedorDTO> fornecedorDTOS = buildFornecedoresDTOs(fornecedores);
        return ResponseEntity.ok(fornecedorDTOS);
    }

}
