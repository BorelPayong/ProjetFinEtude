import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
})
export class ProduitsComponent implements OnInit { //export pour être utilise partout dans le projet

  produits : string[]

  constructor() {
    this.produits = ["PC Asus", "Imprimante Epson", "Tablette Samsung"]
  }

  ngOnInit(): void { //les instruction qui seront écrit dans cette fonction seront execute a la creation du component
  }

}
