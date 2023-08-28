import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Fornecedor } from "src/app/models/fornecedor";
import { EmpresaService } from "src/app/services/empresa.service";
import { FornecedorService } from "src/app/services/fornecedor.service";

@Component({
  selector: "app-list-fornecedor",
  templateUrl: "./list-fornecedor.component.html",
  styleUrls: ["./list-fornecedor.component.css"],
})
export class ListFornecedorComponent {
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
    this.getFornecedoresByEmpresaId();
  }

  private extrairIdRota() {
    this.idRotaEmpresa = Number(this.route.snapshot.paramMap.get("id")!);
  }

  getFornecedoresByEmpresaId(): void {
    if (this.idRotaEmpresa !== undefined) {
      this.empresaService.getFornecedoresByEmpresaId(this.idRotaEmpresa).subscribe(
        (fornecedores: Fornecedor[]) => {
          this.fornecedores = fornecedores;
          if (this.fornecedores.length === 0) {
            this.voltarInicio();
            console.error("não existe nenhum fornecedor associado");
          }
        },
        (error) => {
          console.error("Erro ao buscar fornecedores:", error);
        }
      );
    } else {
      console.error("ID da empresa é undefined");
    }
  }

  desassociarEmpresaFornecedor(idFornecedor: any, idEmpresa: number): void {
    this.fornecedorService.desassociarEmpresaFornecedor(idFornecedor, idEmpresa).subscribe(
      () => {
        console.log('Fornecedor desassociado com sucesso!');
        // Atualizar a lista de fornecedores após a desassociação bem-sucedida
        this.getFornecedoresByEmpresaId();
      },
      error => {
        console.error('Erro ao desassociar fornecedor:', error);
      }
    );
  }



  voltarInicio(): void {
    this.router.navigate([""]);
  }

}
