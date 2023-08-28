import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components/read-all/read-all.component';
import { CreateEmpresaComponent } from './components/create-empresa/create-empresa.component';
import { CreateFornecedorComponent } from './components/create-fornecedor/create-fornecedor.component';
import { EditarEmpresaComponent } from './components/editar-empresa/editar-empresa.component';
import { ListFornecedorComponent } from './components/list-fornecedor/list-fornecedor.component';
import { ListarFornDesasocciadosComponent } from './components/listar-forn-desasocciados/listar-forn-desasocciados.component';
import { ListAllFornecedoresComponent } from './components/list-all-fornecedores/list-all-fornecedores.component';
import { EditarFornecedorComponent } from './components/editar-fornecedor/editar-fornecedor.component';

const routes: Routes = [
  {
    path:'',
    component: ReadAllComponent
  },
  {
    path:'create-empresa',
    component:CreateEmpresaComponent
  },
  {
    path:'editar-empresa/:id',
    component:EditarEmpresaComponent
  },
  {
    path:'create-fornecedor',
    component:CreateFornecedorComponent
  },
  {
    path:'fornecedor-empresa/:id',
    component:ListFornecedorComponent
  },
  {
    path:'fornecedores/desac/:id',
    component:ListarFornDesasocciadosComponent
  },
  {
    path:'fornecedores',
    component:ListAllFornecedoresComponent
  },
  {
    path:'fornecedores/editar-fornecedor/:id',
    component:EditarFornecedorComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
