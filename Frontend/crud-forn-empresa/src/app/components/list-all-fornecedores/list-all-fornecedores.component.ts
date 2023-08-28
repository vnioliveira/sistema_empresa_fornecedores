import { Component } from '@angular/core';
import { Fornecedor } from 'src/app/models/fornecedor';
import { FornecedorService } from 'src/app/services/fornecedor.service';

@Component({
  selector: 'app-list-all-fornecedores',
  templateUrl: './list-all-fornecedores.component.html',
  styleUrls: ['./list-all-fornecedores.component.css']
})
export class ListAllFornecedoresComponent {
  fornecedores: Fornecedor[] = [];
  filtroCnpjCpf: string = '';
  filtroNome: string = '';
  constructor(private fornecedorService: FornecedorService) { }

  ngOnInit(): void {
    this.listarFornecedores();
  }

  listarFornecedores(): void {
    this.fornecedorService.listarFornecedores()
      .subscribe(
        (fornecedores: Fornecedor[]) => {
          this.fornecedores = fornecedores;
        },
        (error: any) => {
          console.error('Erro ao listar fornecedores:', error);
        }
      );
  }

  atualizarFornecedor(id: number, dto: any): void {
    this.fornecedorService.atualizarFornecedor(id, dto)
      .subscribe(
        () => {
          console.log('Fornecedor atualizado com sucesso!');
          this.listarFornecedores();
        },
        (error: any) => {
          console.error('Erro ao atualizar fornecedor:', error);
        }
      );
  }

  removerFornecedor(id: any): void {
    this.fornecedorService.removerFornecedor(id)
      .subscribe(
        () => {
          console.log('Fornecedor removido com sucesso!');
          this.fornecedores = this.fornecedores.filter((fornecedor) => fornecedor.id !== id);
          this.listarFornecedores();
        },
        (error: any) => {
          console.error('Erro ao remover fornecedor:', error);
        }
      );
  }


  carregarFornecedoresPorCnpjCpf(): void {
    if (this.filtroCnpjCpf === '') {
      this.listarFornecedores(); // Carrega todos os fornecedores sem filtro
    } else {
      this.fornecedorService.buscarFornecedoresPorCnpjCpf(this.filtroCnpjCpf).subscribe(
        (fornecedores: Fornecedor[]) => {
          this.fornecedores = fornecedores;
        },
        (error) => {
          console.error('Erro ao buscar fornecedores por CNPJ/CPF:', error);
        }
      );
    }
  }

  buscarFornecedoresPorNome(): void {
    if (this.filtroNome === '') {
      this.listarFornecedores(); // Carrega todos os fornecedores sem filtro
    } else {
    this.fornecedorService.buscarFornecedorPorNome(this.filtroNome).subscribe(
        (fornecedores: Fornecedor[]) => {
          this.fornecedores = fornecedores;
          console.log(fornecedores);
          
        },
        (error) => {
          console.error('Erro ao buscar fornecedores por nome:', error);
        }
      );
    }
  }


}
