package com.example.crudempresafornecedores.rest;

import com.example.crudempresafornecedores.domain.service.FornecedorService;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorResource {
    
    FornecedorService fornecedorService;


    @PostMapping
    public ResponseEntity<Object> cadastrarFornecedor(@RequestBody FornecedorDTO dto) {
        fornecedorService.cadastrarFornecedor(dto);
        return ResponseEntity.created(URI.create("/fornecedores")).build();
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorNome(@PathVariable String nome) {
        return fornecedorService.buscarFornecedorPorNome(nome);
    }

    @GetMapping
    public List<FornecedorDTO> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO dto) {
        return fornecedorService.atualizarFornecedor(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerFornecedor(@PathVariable Long id) {
        return fornecedorService.removerFornecedor(id);
    }
}
