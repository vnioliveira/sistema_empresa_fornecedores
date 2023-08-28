import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Empresa } from "src/app/models/empresa";
import { EmpresaService } from "src/app/services/empresa.service";

@Component({
  selector: "app-editar-empresa",
  templateUrl: "./editar-empresa.component.html",
  styleUrls: ["./editar-empresa.component.css"],
})
export class EditarEmpresaComponent {

  constructor(private router: Router, private service: EmpresaService,private route: ActivatedRoute) {}

  empresa: Empresa = {
    cnpj: "",
    nomeFantasia: "",
    cep: "",
    estado: "",
  };

  idRotaEmpresa: number = -1;

  ngOnInit(): void {
    this.extrairIdRota();
    this.buscarEmpresaId();
  }

  private extrairIdRota() {
    this.idRotaEmpresa = Number(this.route.snapshot.paramMap.get("id")!);
    this.empresa.id = this.idRotaEmpresa;
  }

  atualizarEmpresa(id: number, empresa: Empresa): void {
    this.service.atualizarEmpresa(id, empresa).subscribe(
      (resposta) => {
        if (resposta === null) {
          this.service.message("Empresa atualizada com sucesso!");
          this.router.navigate([""]);
        }
      },
      (error) => {
        console.error("Erro ao atualizar empresa:", error);
      }
    );
  }
  
  buscarEmpresaId(): void {
    if (this.empresa.id !== undefined) { // Verifique se o ID não é undefined
      this.service.buscarEmpresaById(this.empresa.id)
        .subscribe(
          (empresa: Empresa) => {
            this.empresa = empresa;
          },
          error => {
            console.error("Erro ao buscar empresa:", error);
          }
        );
    } else {
      console.error("ID da empresa é undefined");
    }
  }

  cancel(): void {
    this.router.navigate([""]);
  }
}
