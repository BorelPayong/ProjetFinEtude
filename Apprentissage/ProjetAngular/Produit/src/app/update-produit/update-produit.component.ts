import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../model/produit.model';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styles: [
  ]
})
export class UpdateProduitComponent implements OnInit {

  currentProduit = new Produit();

  //ActivatedRoute classe du module de router angular qui sert a fournir les information sur la route active 
  //Router pour la navigation entre les component
  constructor(private activatedRoute: ActivatedRoute, private router :Router, private produitService: ProduitService) { 

  }

  ngOnInit(): void {
    this.currentProduit = this.produitService.consulterProduit(this.activatedRoute.snapshot.params["id"])
    console.log(this.currentProduit)
  }

  updateProduit(){
    console.log(this.currentProduit)
    this.produitService.updateProduit(this.currentProduit)
    this.router.navigate(["produits"])
  }

}
