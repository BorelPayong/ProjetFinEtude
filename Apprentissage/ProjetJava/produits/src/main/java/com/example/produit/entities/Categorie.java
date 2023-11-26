package com.example.produit.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lomnok est une bibliotheque java ; la dependency a ete ajouter au pom.xml pour pouvoir l'utiliser 
@Data //grace a lombok, permet de genere automatique les getter et setter sans les écrires 
@NoArgsConstructor //pour genere un consructeur sans argument
@AllArgsConstructor //pour genere un consructeur avec argument
@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	@OneToMany(mappedBy = "categorie") // un categorie a plusieurs produit ; mappedBy sert a lier l'attribut de la relation entre les 2 
	private List<Produit> produit;
	
}