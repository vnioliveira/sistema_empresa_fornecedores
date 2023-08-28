import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Fornecedor } from 'src/app/models/fornecedor';
import { EmpresaService } from 'src/app/services/empresa.service';
import { FornecedorService } from 'src/app/services/fornecedor.service';

@Component({
  selector: 'app-listar-forn-desasocciados',
  templateUrl: './listar-forn-desasocciados.component.html',
  styleUrls: ['./listar-forn-desasocciados.component.css']
})
export class ListarFornDesasocciadosComponent {
  fornecedores: Fornecedor[] = [];

  idRotaEmpresa: number = -1;

  constructor(
    private empresaService: EmpresaService,
    private router: Router,
    private route: ActivatedRoute,
    private fornecedorService: FornecedorService
  ) {}

  ngOnInit(): void {
    this.extrairIdRota();
    this.getFornecedoresNaoAssociados();
  }

  private extrairIdRota() {
    this.idRotaEmpresa = Number(this.route.snapshot.paramMap.get("id")!);
  }

  getFornecedoresNaoAssociados(): void {
    if (this.idRotaEmpresa !== undefined) {
      this.empresaService.getFornecedoresDesassociados(this.idRotaEmpresa).subscribe(
        (fornecedores: Fornecedor[]) => {
          if(fornecedores == null){
            this.voltarInicio();
          }
          this.fornecedores = fornecedores;
        },
        (error) => {
          console.error("Erro ao buscar fornecedores:", error);
        }
      );
    } else {
      console.error("ID da empresa é undefined");
    }
  }

  associarEmpresaFornecedor(idFornecedor: any, idEmpresa: number): void {
    this.fornecedorService.associarEmpresaFornecedor(idFornecedor, idEmpresa).subscribe(
      () => {
        console.log('Fornecedor associado com sucesso!');
        this.getFornecedoresNaoAssociados();

      },
      error => {
        console.error('Erro ao associar fornecedor:', error);
      }
    );
  }

  voltarInicio(): void {
    this.router.navigate([""]);
  }

}
