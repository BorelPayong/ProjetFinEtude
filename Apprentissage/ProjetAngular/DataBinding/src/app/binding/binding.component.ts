import { Component, OnInit } from '@angular/core'; // import les classe Component et OnInit

//Component decorateur pour definir les metadonnée du component
@Component({
  selector: 'app-binding', //app-binding nom du selector ; cequi est utilise dans le app-component.html au moment de l'appel
  templateUrl: './binding.component.html', //specifie le chemin du fichier html qui sera utilise 
  //tableau des fichier css specifique a ce component
  styles: [
  ]
})
export class BindingComponent implements OnInit { //la classe BindingComponent qui implement l'interface OnInit, donc elle doit avoir une mehode ngOnInit  

  titre : string = "demo du data binding interpolation" //variable titre de type string et initialise

  status : boolean = false

  nom : string = "Franck"

  constructor() { } //constructeur de la classe

  ngOnInit(): void { //ngOnInit est un methode de l'interface OnInit
  }

  changerTitre(){ //declaration d'un fonction 
    this.titre = "nouveau titre"
  }

}
