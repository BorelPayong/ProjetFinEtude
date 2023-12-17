import { NgModule } from '@angular/core'; //utilise pour definir les module angular
import { RouterModule, Routes } from '@angular/router'; //pour la configuration des route du projet
import { ProduitsComponent } from './produits/produits.component'; //import le component ProduitsComponent
import { AddProduitComponent } from './add-produit/add-produit.component'; //import le component AddProduitComponent

const routes: Routes = [ //declare un tableau de route
  {path : "produits", component : ProduitsComponent}, //http://localhost:4200/produits pour charge le component ProduitsComponent
  {path : "add-produits", component : AddProduitComponent},
  {path: "", redirectTo: "produits", pathMatch: "full"} //path: "" : http://localhost:4200 vas toujours renvoyer vers le component ProduitsComponent ie URL vide
  //pathMatch: "full" : pour specifier que c'est uniquement quand lorsque l'URL sera vide que la redirection sera possible
];

@NgModule({ //les configuration du module angular 
  imports: [RouterModule.forRoot(routes)], //configurer le module de routage avec les routes defini plus haut
  exports: [RouterModule] //exporte le module de routage pour que d'autre module l'utilise
})
export class AppRoutingModule { }
