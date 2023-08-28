import { Fornecedor } from "./Fornecedor";

export interface Empresa {
    id: number;
    cnpj: string;
    nomeFantasia: string;
    cep: string;
    estado: string;
    cidade: string;
    fornecedores: Fornecedor[];
  }
  