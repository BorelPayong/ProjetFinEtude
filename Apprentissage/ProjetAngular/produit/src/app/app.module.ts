import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'; //excute l'application dans un navigateur

import { AppRoutingModule } from './app-routing.module'; //module de routage 
import { AppComponent } from './app.component'; // Importe le composant principal
import { ProduitsComponent } from './produits/produits.component'; //importe les different component
import { AddProduitComponent } from './add-produit/add-produit.component';
import { FormsModule } from '@angular/forms'; //module pour gere les formulaire

@NgModule({ //NgModule module principal de l'application avec ces configuration
  declarations: [ //declaration de la liste des component de l'application
    AppComponent,
    ProduitsComponent,
    AddProduitComponent
  ],
  imports: [ //la liste des module dont depend ce module
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [], //la liste des services qui peuvent être injectés dans les composants de ce module
  bootstrap: [AppComponent] //defini le component avec lequel le projet demarre
})
export class AppModule { }
