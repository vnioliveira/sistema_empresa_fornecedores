import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fornecedor } from '../models/fornecedor';

@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  private baseUrl = 'http://localhost:8080/fornecedores';

  constructor(private http: HttpClient) { }

  cadastrarFornecedor(dto: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, dto);
  }

  associarEmpresaFornecedor(idFornecedor: number, idEmpresa: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/${idFornecedor}/empresa/${idEmpresa}`, {});
  }

  desassociarEmpresaFornecedor(idFornecedor: number, idEmpresa: number): Observable<void> {
    const url = `${this.baseUrl}/${idFornecedor}/empresa/${idEmpresa}/desassociar`;
    return this.http.put<void>(url, null);
  }
  buscarFornecedorPorNome(nome: string): Observable<Fornecedor[]> {
    return this.http.get<Fornecedor[]>(`${this.baseUrl}/name/${nome}`);
  }

  listarFornecedores(): Observable<Fornecedor[]> {
    return this.http.get<Fornecedor[]>(`${this.baseUrl}`);
  }

  atualizarFornecedor(id: number, dto: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, dto);
  }

  removerFornecedor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  buscarFornecedoresPorCnpjCpf(cnpjCpf: string): Observable<Fornecedor[]> {
    return this.http.get<Fornecedor[]>(`${this.baseUrl}/cnpj-cpf/${cnpjCpf}`);
  }

  buscarFornecedorById(id: number): Observable<Fornecedor> {
    const url = `${this.baseUrl}/${id}`; 
    return this.http.get<Fornecedor>(url);
  }

}
