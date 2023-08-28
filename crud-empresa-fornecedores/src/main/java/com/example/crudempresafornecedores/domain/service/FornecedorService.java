package com.example.crudempresafornecedores.domain.service;


import com.example.crudempresafornecedores.domain.model.Empresa;
import com.example.crudempresafornecedores.domain.model.Fornecedor;
import com.example.crudempresafornecedores.domain.repository.EmpresaRepository;
import com.example.crudempresafornecedores.domain.repository.FornecedorRepository;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import com.example.crudempresafornecedores.rest.dto.PostFonecedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService extends ClasseBase {
    private final FornecedorRepository fornecedorRepository;
    private final EmpresaRepository empresaRepository;
    public void cadastrarFornecedor(PostFonecedorDTO dto) {
        Fornecedor fornecedor = buildPostFornecedor(dto);
        fornecedorRepository.save(fornecedor);
    }
    public ResponseEntity<List<FornecedorDTO>> buscarFornecedorPorNome(String nome) {
        List<Fornecedor> fornecedores = fornecedorRepository.getFornecedoresByNome(nome);
        List<FornecedorDTO> fornecedorDTOS = buildFornecedoresDTOs(fornecedores);
        return ResponseEntity.ok(fornecedorDTOS);
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


    @Transactional
    public void associarEmpresaFornecedor(Long idEmpresa, Long idFornecedor) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(idEmpresa);
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(idFornecedor);

        if (empresaOptional.isPresent() && fornecedorOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            Fornecedor fornecedor = fornecedorOptional.get();

            empresa.getFornecedores().add(fornecedor);
            fornecedor.getEmpresas().add(empresa);

            empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa ou fornecedor não encontrado.");
        }
    }

    @Transactional
    public void desassociarEmpresaFornecedor(Long idFornecedor, Long idEmpresa) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(idEmpresa);
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(idFornecedor);

        if (empresaOptional.isPresent() && fornecedorOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            Fornecedor fornecedor = fornecedorOptional.get();

            empresa.getFornecedores().remove(fornecedor);
            fornecedor.getEmpresas().remove(empresa);

            empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa ou fornecedor não encontrado.");
        }
    }

    public ResponseEntity<FornecedorDTO> getFornecedorById(Long id) {
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
        if (fornecedorOptional.isPresent()) {
            Fornecedor fornecedor = fornecedorOptional.get();
            FornecedorDTO fornecedorDTO = buildFornecedorDTO(fornecedor);
            return ResponseEntity.ok(fornecedorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
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
}
