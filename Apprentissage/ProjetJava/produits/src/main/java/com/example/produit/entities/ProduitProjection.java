package com.example.produit.entities;

import org.springframework.data.rest.core.config.Projection;

//restreinte le nombre d'attribut retourne par spring
@Projection(name = "nomProd", types = { Produit.class })
public interface ProduitProjection {
	
	public String getNomProduit();

}