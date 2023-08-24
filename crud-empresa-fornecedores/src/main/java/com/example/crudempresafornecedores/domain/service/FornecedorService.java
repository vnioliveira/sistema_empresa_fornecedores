package com.example.crudempresafornecedores.domain.service;


import com.example.crudempresafornecedores.domain.model.Fornecedor;
import com.example.crudempresafornecedores.domain.repository.FornecedorRepository;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public void cadastrarFornecedor(FornecedorDTO dto) {
        Fornecedor fornecedor = buildFornecedor(dto);
        fornecedorRepository.save(fornecedor);
    }
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorNome(String nome) {
        Fornecedor fornecedor = fornecedorRepository.getFornecedorByNome(nome);
        FornecedorDTO fornecedorDTO = buildFornecedorDTO(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    public List<FornecedorDTO> listarFornecedores() {
        List<Fornecedor>
                fornecedors = fornecedorRepository.findAll();

        return fornecedors.stream()
                .map(this::buildFornecedorDTO)
                .collect(Collectors.toList());

    }

    public ResponseEntity<Object> atualizarFornecedor(Long id, FornecedorDTO dto) {
        if (fornecedorRepository.existsById(id)) {
            Fornecedor fornecedorAtualizada = buildFornecedor(dto);
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

    public FornecedorDTO buildFornecedorDTO(Fornecedor fornecedor) {
        return FornecedorDTO.builder()
                .cnpjCpf(fornecedor.getCnpjCpf())
                .nome(fornecedor.getNome())
                .email(fornecedor.getEmail())
                .cep(fornecedor.getCep())
                .rg(fornecedor.getRg())
                .dataNascimento(fornecedor.getDataNascimento())
                .empresa(fornecedor.getEmpresa())
                .build();
    }

    public static Fornecedor buildFornecedor(FornecedorDTO dto) {
        return Fornecedor.builder()
                .cnpjCpf(dto.getCnpjCpf())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cep(dto.getCep())
                .rg(dto.getRg())
                .dataNascimento(dto.getDataNascimento())
                .empresa(dto.getEmpresa())
                .build();
    }
}
