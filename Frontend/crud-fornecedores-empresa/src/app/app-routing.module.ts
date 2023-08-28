import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresasFormComponent } from './components/empresas-form/empresas-form.component';

const routes: Routes = [
  { path: '', redirectTo: 'empresas', pathMatch: 'full' },
  { path: 'empresas', component: EmpresasFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
