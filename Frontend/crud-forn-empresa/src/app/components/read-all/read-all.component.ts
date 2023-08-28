import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Empresa } from "src/app/models/empresa";
import { EmpresaService } from "src/app/services/empresa.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  empresas: Empresa[] = [];
  treeControl: any;
  constructor(private empresaService: EmpresaService, private router: Router) {}
  ngOnInit(): void {
    this.carregarEmpresas();
  }

  carregarEmpresas(): void {
    this.empresaService.listarEmpresas().subscribe((empresas) => {
      this.empresas = empresas;
    });
  }

  delete(id: any): void {
    this.empresaService.delete(id).subscribe((resposta) => {
      if (resposta === null) {
        this.empresaService.message("Empresa deletada com sucesso!");
        this.empresas = this.empresas.filter((empresas) => empresas.id !== id); // Atualize o array empresas
      }
    });
  }
  

  novaEmpresa(): void {
    this.router.navigate(["create-empresa"]);
  }

  novoFornecedor(): void {
    this.router.navigate(["create-fornecedor"]);
  }
}
