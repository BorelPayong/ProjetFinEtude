package com.example.produit.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produit.dto.ProduitDTO;
import com.example.produit.entities.Produit;
import com.example.produit.service.ProduitService;

@RestController //cette classe vas contenir des methode qui seront des web service et consommer par une API
@RequestMapping("/api") // pour acceder au sevrice de cette classe on doit tape localhost:8080/produit/api
@CrossOrigin // permettre a toute les adresse ip de consommer mon service 
public class ProduitRestController {

	@Autowired //crer un objet ProduitService et il vas l'injecter dans produitService
	ProduitService produitService;
	
	//method=RequestMethod.GET preciser quel methode http sera utilise ; dans ce cas il s'agit d'une methode get
	@RequestMapping(method=RequestMethod.GET)
	public List<ProduitDTO> getAllProduits(){
		return produitService.getAllProduits();
	}
	
	//value="/{id}" parametre a mettre lors de l'appel du service localhost:8080/produit/api/1....
	//@PathVariable("id") Long id : l'id qui vas etre preciser dans l'url pour la passe en param de ma fonction
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
	//@RequestBody recupere un objet de type produit qui sera sauvegarde dans la base de donnee
	@RequestMapping(method = RequestMethod.POST)
	public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO) {
		return produitService.saveProduit(produitDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO) {
		return produitService.updateProduit(produitDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id){
		produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	}
}
