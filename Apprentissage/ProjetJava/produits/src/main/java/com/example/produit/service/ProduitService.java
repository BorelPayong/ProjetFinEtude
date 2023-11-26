package com.example.produit.service;

import java.util.List;

import com.example.produit.dto.ProduitDTO;
import com.example.produit.entities.Categorie;
import com.example.produit.entities.Produit;

public interface ProduitService {
	
	/*Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	List<Produit> getAllProduits();*/
	
	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO updateProduit(ProduitDTO p);
	List<ProduitDTO> getAllProduits();
	
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduit(Long id);
	
	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();
	
	ProduitDTO converEntityToDto(Produit p);
	
	Produit convertDtoToEntity(ProduitDTO produitDto);
}
