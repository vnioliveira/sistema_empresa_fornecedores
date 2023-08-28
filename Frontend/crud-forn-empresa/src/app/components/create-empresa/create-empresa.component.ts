import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Empresa } from 'src/app/models/empresa';
import { EmpresaService } from 'src/app/services/empresa.service';

@Component({
  selector: 'app-create-empresa',
  templateUrl: './create-empresa.component.html',
  styleUrls: ['./create-empresa.component.css']
})
export class CreateEmpresaComponent {
  constructor(
    private router: Router,
    private service: EmpresaService
    ) { }
  empresa: Empresa = {
    cnpj: '',
    nomeFantasia: '',
    cep: '',
    estado: ''
  };
  ngOnInit(): void {}

  cancel(): void {
    this.router.navigate([""]);
  }

  criar(): void {
    this.service.cadastrarEmpresa(this.empresa).subscribe((resposta)=> {
      this.service.message('To-do criado com sucesso!!');
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao criar To-do!!');
      this.router.navigate(['']);
    })
  }

}
