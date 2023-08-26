package com.example.crudempresafornecedores.rest;

import com.example.crudempresafornecedores.domain.service.EmpresaService;
import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.PostEmpresaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaRecource {

    private final EmpresaService empresaService;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarEmpresa(@RequestBody PostEmpresaDTO dto) {
        empresaService.cadastrarEmpresa(dto);
        return ResponseEntity.created(URI.create("/empresas")).build();
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<EmpresaDTO> buscarEmpresaPorNome(@PathVariable String nome) {
        return empresaService.buscarEmpresaPorNome(nome);
    }

    @GetMapping
    public List<EmpresaDTO> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarEmpresa(@PathVariable Long id, @RequestBody PostEmpresaDTO dto) {
        return empresaService.atualizarEmpresa(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerEmpresa(@PathVariable Long id) {
        return empresaService.removerEmpresa(id);
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<List<EmpresaDTO>> buscarEmpresasPorCnpj(@PathVariable String cnpj) {
        return empresaService.buscarEmpresasPorCnpj(cnpj);
    }


}
