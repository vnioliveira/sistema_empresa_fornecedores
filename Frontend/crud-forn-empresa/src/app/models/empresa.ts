import { Fornecedor } from "./fornecedor";

export interface Empresa {
    id?: number,
    cnpj: string;
    nomeFantasia: string;
    cep: string;
    estado: string;
    fornecedores?: Fornecedor[];
    
}