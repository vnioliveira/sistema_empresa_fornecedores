import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./components/header/header.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatToolbarModule } from "@angular/material/toolbar";
import { FooterComponent } from "./components/footer/footer.component";
import { ReadAllComponent } from "./components/read-all/read-all.component";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatListModule } from "@angular/material/list";
import { MatTreeModule } from "@angular/material/tree";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { CreateEmpresaComponent } from "./components/create-empresa/create-empresa.component";
import { FormsModule } from "@angular/forms";
import { MatInputModule } from "@angular/material/input";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule } from "@angular/material/core";
import { InputMaskModule } from '@ngneat/input-mask';
import { CreateFornecedorComponent } from './components/create-fornecedor/create-fornecedor.component';
import { EditarEmpresaComponent } from './components/editar-empresa/editar-empresa.component';
import { ListFornecedorComponent } from './components/list-fornecedor/list-fornecedor.component';
import { ListarFornDesasocciadosComponent } from './components/listar-forn-desasocciados/listar-forn-desasocciados.component';
import { ListAllFornecedoresComponent } from './components/list-all-fornecedores/list-all-fornecedores.component';
import { EditarFornecedorComponent } from './components/editar-fornecedor/editar-fornecedor.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ReadAllComponent,
    CreateEmpresaComponent,
    CreateFornecedorComponent,
    EditarEmpresaComponent,
    ListFornecedorComponent,
    ListarFornDesasocciadosComponent,
    ListAllFornecedoresComponent,
    EditarFornecedorComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatExpansionModule,
    MatListModule,
    MatTreeModule,
    HttpClientModule,
    MatSnackBarModule,
    FormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    InputMaskModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
