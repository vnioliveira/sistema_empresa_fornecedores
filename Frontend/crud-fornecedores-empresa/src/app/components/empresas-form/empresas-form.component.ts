import { Component, OnInit } from '@angular/core';
import { EmpresaService } from 'src/app/services/empresa.service';
import { Empresa } from 'src/app/models/Empresa';
@Component({
  selector: 'app-empresas-form',
  templateUrl: './empresas-form.component.html',
  styleUrls: ['./empresas-form.component.scss']
})
export class EmpresasFormComponent implements OnInit {
  empresas: Empresa[] = [];

  constructor(private empresaService: EmpresaService) {}

  ngOnInit(): void {
    this.carregarEmpresas();
  }

  carregarEmpresas(): void {
    this.empresaService.listarEmpresas().subscribe(
      (empresas) => {
        this.empresas = empresas;
      },
      (error) => {
        console.error('Erro ao carregar empresas:', error);
      }
    );
  }
}
