import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';
import { Categorie } from '../model/categorie.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html'
})
export class AddProduitComponent implements OnInit {

  newProduit = new Produit()
  categories? : Categorie[]
  newCategorie? : Categorie

  message? : string
  newIdCat? : number

  constructor(private produitService : ProduitService, private router : Router) { }

  ngOnInit(): void {
    this.categories = this.produitService.listeCategories()
  }

  addProduit(){
    this.newCategorie = this.produitService.consulterCategorie(this.newIdCat!) 
    //this.newIdCat avec ! c'est pour specifier qu'il ne sera pas null ou undefined au moment de l'appel 
    this.newProduit.categorie = this.newCategorie
    this.produitService.ajouterProduit(this.newProduit)
    this.message = "Produit " + this.newProduit.nomProduit + " ajouter avec succes"
    this.router.navigate(["produits"])
  }
}
