package com.example.crudempresafornecedores.domain.validator;

import com.example.crudempresafornecedores.rest.dto.EmpresaDTO;
import com.example.crudempresafornecedores.rest.dto.FornecedorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


public class EmpresaParanaMaioridadeValidator implements ConstraintValidator<ValidacaoEmpresaFornecedor, FornecedorDTO> {
    public LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public boolean isValid(FornecedorDTO fornecedorDTO, ConstraintValidatorContext context) {
        if (fornecedorDTO == null) {
            return true; // Deixe a validação para @NotNull ou @NotBlank
        }

        List<EmpresaDTO> empresas = fornecedorDTO.getEmpresas();
        if ("pf".equals(fornecedorDTO.getTipo())) {
            for (EmpresaDTO empresa : empresas) {
                String estadoEmpresa = empresa.getEstado();
                LocalDate dataNascimento = convertDateToLocalDate(fornecedorDTO.getDataNascimento());
                LocalDate idadeMinima = LocalDate.now().minusYears(18);

                if (estadoEmpresa.equalsIgnoreCase("PR") && dataNascimento.isAfter(idadeMinima)) {
                    return false;
                }
            }
        }

        return true;
    }
}