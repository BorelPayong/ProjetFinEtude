package com.example.produit.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@NoArgsContructor
@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	@OneToMany(mappedBy = "categorie") // un categorie a plsieurs produit ; mappedBy sert a lien l'attribut de la relation entre les 2 
	private List<Produit> produit;
	
}
