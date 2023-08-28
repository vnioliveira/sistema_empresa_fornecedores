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
@CrossOrigin("*")
@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorResource {

     private final FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarFornecedor(@RequestBody PostFonecedorDTO dto) {
        fornecedorService.cadastrarFornecedor(dto);
        return ResponseEntity.created(URI.create("/fornecedores")).build();
    }

    @PostMapping("/{idFornecedor}/empresa/{idEmpresa}")
    @Transactional
    public ResponseEntity<Object> associarFornecedor(@PathVariable Long idFornecedor,@PathVariable Long idEmpresa) {
        fornecedorService.associarEmpresaFornecedor(idFornecedor,idEmpresa);
        return ResponseEntity.created(URI.create("/fornecedores")).build();
    }

    @Transactional
    @PutMapping("/{idFornecedor}/empresa/{idEmpresa}/desassociar")
    public ResponseEntity<Void> desassociarEmpresaFornecedor(@PathVariable Long idFornecedor, @PathVariable Long idEmpresa) {
        fornecedorService.desassociarEmpresaFornecedor(idFornecedor, idEmpresa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<List<FornecedorDTO>> buscarFornecedorPorNome(@PathVariable String nome) {
        return fornecedorService.buscarFornecedorPorNome(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorId(@PathVariable Long id)  {
        return fornecedorService.getFornecedorById(id);
    }

    @GetMapping
    public List<FornecedorDTO> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarFornecedor(@PathVariable Long id, @RequestBody PostFonecedorDTO dto) {
        return fornecedorService.atualizarFornecedor(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerFornecedor(@PathVariable Long id) {
        return fornecedorService.removerFornecedor(id);
    }

    @GetMapping("/cnpj-cpf/{cnpjCpf}")
    public ResponseEntity<List<FornecedorDTO>> buscarFornecedoresPorCnpjCpf(@PathVariable String cnpjCpf) {
        return fornecedorService.buscarFornecedoresPorCnpjCpf(cnpjCpf);
    }
}
