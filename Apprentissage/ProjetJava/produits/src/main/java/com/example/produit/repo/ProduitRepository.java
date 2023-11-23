package com.example.produit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.produit.entities.Categorie;
import com.example.produit.entities.Produit;

//la classe Produit, Long c'est le type de son id
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	//requette jpa de srping
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom); //rechercher un produit dont le nom contient ce nom
	
	//requette jpa personnalisé 
	/*@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix);*/
	//autre methode pour ecrire une requete jpa personnalise 
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Produit p where p.categorie = ?1")
	List<Produit> findByCategorie (Categorie categorie);
	
	List<Produit> findByCategorieIdCat(Long id);
	
	List<Produit> findByOrderByNomProduitAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
}
