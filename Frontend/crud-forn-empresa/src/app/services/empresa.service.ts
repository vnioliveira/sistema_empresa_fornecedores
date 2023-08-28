import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Empresa } from "../models/empresa";
import { HttpClient } from "@angular/common/http";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Fornecedor } from "../models/fornecedor";
@Injectable({
  providedIn: "root",
})
export class EmpresaService {
  private baseUrl = "http://localhost:8080/empresas";
  constructor(private http: HttpClient,private snack: MatSnackBar) {}

  cadastrarEmpresa(dto: Empresa): Observable<any> {
    return this.http.post(`${this.baseUrl}`, dto);
  }

  listarEmpresas(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.baseUrl}`);
  }
  delete(id: any): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
  atualizarEmpresa(id: number, dto: Empresa): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, dto);
  }
  buscarEmpresasPorCnpj(cnpj: string): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.baseUrl}/cnpj/${cnpj}`);
  }
  buscarEmpresaPorNome(nome: string): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.baseUrl}/name/${nome}`);
  }

  buscarEmpresaById(id: number): Observable<Empresa> {
    const url = `${this.baseUrl}/${id}`; 
    return this.http.get<Empresa>(url);
  }

  getFornecedoresByEmpresaId(id: number): Observable<Fornecedor[]> {
    const url = `${this.baseUrl}/fornecedores/${id}`;
    return this.http.get<Fornecedor[]>(url);
  }

  getFornecedoresDesassociados(empresaId: number): Observable<Fornecedor[]> {
    return this.http.get<Fornecedor[]>(`${this.baseUrl}/fornecedores/desac/${empresaId}`);
  }

  message(msg: string): void {
    this.snack.open(`${msg}`, `OK`, {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
