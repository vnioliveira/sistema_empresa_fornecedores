import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Fornecedor } from "src/app/models/fornecedor";
import { FornecedorService } from "src/app/services/fornecedor.service";

@Component({
  selector: "app-create-fornecedor",
  templateUrl: "./create-fornecedor.component.html",
  styleUrls: ["./create-fornecedor.component.css"],
})
export class CreateFornecedorComponent {
  constructor(private router: Router,private fornecedorService: FornecedorService) {}
  fornecedor: Fornecedor = {
    cnpjCpf: '',
    nome:'',
    email: '',
    cep: '',
    rg:'',
    dataNascimento: new Date (),
    tipo :''

  }

  fornecedores: Fornecedor[] = [];

  ngOnInit(): void {}


  criar(): void {
   
    this.fornecedorService.cadastrarFornecedor(this.fornecedor)
      .subscribe(
        () => {
          console.log('Fornecedor cadastrado com sucesso!');
          this.router.navigate([""]);
        },
        error => {
          console.error('Erro ao cadastrar fornecedor:', error);
        }
      );
  }

  cancel(): void {
    this.router.navigate([""]);
  }
}
