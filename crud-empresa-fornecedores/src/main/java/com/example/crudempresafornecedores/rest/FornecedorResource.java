package com.example.crudempresafornecedores.rest;

import com.example.crudempresafornecedores.domain.service.FornecedorService;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import com.example.crudempresafornecedores.rest.dto.PostFonecedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorResource {

     private final FornecedorService fornecedorServiceImpl;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarFornecedor(@RequestBody PostFonecedorDTO dto) {
        fornecedorServiceImpl.cadastrarFornecedor(dto);
        return ResponseEntity.created(URI.create("/fornecedores")).build();
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorNome(@PathVariable String nome) {
        return fornecedorServiceImpl.buscarFornecedorPorNome(nome);
    }

    @GetMapping
    public List<FornecedorDTO> listarFornecedores() {
        return fornecedorServiceImpl.listarFornecedores();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarFornecedor(@PathVariable Long id, @RequestBody PostFonecedorDTO dto) {
        return fornecedorServiceImpl.atualizarFornecedor(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerFornecedor(@PathVariable Long id) {
        return fornecedorServiceImpl.removerFornecedor(id);
    }

    @GetMapping("/cnpj-cpf/{cnpjCpf}")
    public ResponseEntity<List<FornecedorDTO>> buscarFornecedoresPorCnpjCpf(@PathVariable String cnpjCpf) {
        return fornecedorServiceImpl.buscarFornecedoresPorCnpjCpf(cnpjCpf);
    }
}
