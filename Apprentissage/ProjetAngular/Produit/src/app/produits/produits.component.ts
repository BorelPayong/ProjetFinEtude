import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
})
export class ProduitsComponent implements OnInit { //export pour être utilise partout dans le projet

  produits? : Produit[]

  constructor(private produitService : ProduitService) {}

  ngOnInit(): void { //les instruction qui seront écrit dans cette fonction seront execute a la creation du component
    this.produits = this.produitService.listeProduit()
  }

  supprimerProduit(prod : Produit){
    let confir = confirm("Etes-vous sur ?") //confirm est une boite de dialogue js si la reponse st oui la suppresion sera faite
    if(confir)
      this.produitService.supprimerProduit(prod)
  }

}
