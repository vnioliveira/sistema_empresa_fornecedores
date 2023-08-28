import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PostEmpresa } from '../models/PostEmpresa';
import { Empresa } from '../models/Empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {
  private baseUrl = 'http://localhost:8080'; // Coloque a URL do seu backend aqui

  constructor(private http: HttpClient) { }

  cadastrarEmpresa(dto: PostEmpresa): Observable<any> {
    return this.http.post(`${this.baseUrl}/empresas`, dto);
  }

  buscarEmpresaPorNome(nome: string): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.baseUrl}/empresas/name/${nome}`);
  }

  listarEmpresas(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.baseUrl}/empresas`);
  }

  atualizarEmpresa(id: number, dto: PostEmpresa): Observable<any> {
    return this.http.put(`${this.baseUrl}/empresas/${id}`, dto);
  }

  removerEmpresa(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/empresas/${id}`);
  }

  buscarEmpresasPorCnpj(cnpj: string): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.baseUrl}/empresas/cnpj/${cnpj}`);
  }
}
