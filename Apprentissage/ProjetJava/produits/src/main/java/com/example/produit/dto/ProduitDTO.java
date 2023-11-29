package com.example.produit.dto;

import java.util.Date;

import com.example.produit.entities.Categorie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder //genere automatiquement un constructeur de type builder
public class ProduitDTO {
	
	private Long idProduit;
	private String nomProduit;
	private Double prixProduit;
	private Date dateCreation;
	//private Categorie categorie;
	private String nomCat;

}
/*
@Builder
ProduitDTO produitDTO = ProduitDTO.builder()
.idProduit()
.nomProduit()
.prixProduit()
.dateCreation()
.categorie(new Categorie())
.nomCat()
.build();*/