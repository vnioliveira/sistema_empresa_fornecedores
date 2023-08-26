package com.example.crudempresafornecedores.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmpresaParanaMaioridadeValidator.class)
public @interface ValidacaoEmpresaFornecedor {
    String message() default "Proibido cadastro de pessoa fisica menor de idade no paraná";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
