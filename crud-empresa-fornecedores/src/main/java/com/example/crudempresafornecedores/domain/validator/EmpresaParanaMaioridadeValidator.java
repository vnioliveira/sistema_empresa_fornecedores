package com.example.crudempresafornecedores.domain.validator;

import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.List;


public class EmpresaParanaMaioridadeValidator implements ConstraintValidator<ValidacaoEmpresaFornecedor, FornecedorDTO> {

    @Override
    public boolean isValid(FornecedorDTO fornecedorDTO, ConstraintValidatorContext context) {
        if (fornecedorDTO == null) {
            return true; // Deixe a validação para @NotNull ou @NotBlank
        }

        List<EmpresaDTO> empresas = fornecedorDTO.getEmpresas();
        if ("pf".equals(fornecedorDTO.getTipo())) {
        for (EmpresaDTO empresa : empresas) {
            String estadoEmpresa = empresa.getEstado();
            LocalDate dataNascimento = fornecedorDTO.getDataNascimento();
            LocalDate hoje = LocalDate.now();
            LocalDate idadeMinima = hoje.minusYears(18);

            if (estadoEmpresa.equalsIgnoreCase("PR")
                    && dataNascimento != null && dataNascimento.isAfter(idadeMinima)) {
                return false;
            }
        }
    }

        return true;
    }
}