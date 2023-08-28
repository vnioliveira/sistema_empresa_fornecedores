import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fornecedor } from 'src/app/models/fornecedor';
import { FornecedorService } from 'src/app/services/fornecedor.service';

@Component({
  selector: 'app-editar-fornecedor',
  templateUrl: './editar-fornecedor.component.html',
  styleUrls: ['./editar-fornecedor.component.css']
})
export class EditarFornecedorComponent {

  constructor(private router: Router,private fornecedorService: FornecedorService,private route: ActivatedRoute) {}

  fornecedor: Fornecedor = {
    cnpjCpf: '',
    nome:'',
    email: '',
    cep: '',
    rg:'',
    dataNascimento: '',
    tipo :''

  }
  
  fornecedores: Fornecedor[] = [];
  
  idRotaFornecedor: number = -1;

  ngOnInit(): void {
    this.extrairIdRota();
    this.buscarFornecedorId();
  }

  private extrairIdRota() {
    this.idRotaFornecedor = Number(this.route.snapshot.paramMap.get("id")!);
    this.fornecedor.id = this.idRotaFornecedor;
  }

  atualizarFornecedor(id: number, dto: any): void {
    this.fornecedorService.atualizarFornecedor(id, dto)
      .subscribe(
        () => {
          console.log('Fornecedor atualizado com sucesso!');
          this.router.navigate(["fornecedores"]);
          
        },
        (error: any) => {
          console.error('Erro ao atualizar fornecedor:', error);
        }
      );
  }

  buscarFornecedorId(): void {
    if (this.fornecedor.id !== undefined) { // Verifique se o ID não é undefined
      this.fornecedorService.buscarFornecedorById(this.fornecedor.id)
        .subscribe(
          (fornecedor: Fornecedor) => {
            this.fornecedor = fornecedor;
            

          },
          (error: any) => {
            console.error("Erro ao buscar empresa:", error);
          }
        );
    } else {
      console.error("ID da empresa é undefined");
    }
  }

  voltarAtualizar(): void {
    this.router.navigate(["fornecedores"]);
  }


  cancel(): void {
    this.router.navigate(["fornecedores"]);
  }
}
