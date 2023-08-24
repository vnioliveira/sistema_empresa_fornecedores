CREATE
DATABASE cadastro_emp_forn;

CREATE TABLE empresas
(
    id            SERIAL PRIMARY KEY,
    cnpj          VARCHAR(100) NOT NULL,
    nome_fantasia VARCHAR(100) NOT NULL,
    cep           VARCHAR(100) NOT NULL
);


CREATE TABLE fornecedores
(
    id             SERIAL PRIMARY KEY,
    cpf_cnpj       VARCHAR(100) NOT NULL,
    nome           VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL,
    cep            VARCHAR(100) NOT NULL,
    rg             VARCHAR(100) NOT NULL,
    dataNascimento DATE         NOT NULL,
    empresa_id     BIGINT REFERENCES empresa (id)
);


