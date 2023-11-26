package com.example.produit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produit.dto.ProduitDTO;
import com.example.produit.entities.Categorie;
import com.example.produit.entities.Produit;
import com.example.produit.repo.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	ModelMapper modelMapper;

	/*@Override
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}
	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}
	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}*/
	
	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		// TODO Auto-generated method stub
		return converEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}
	
	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		// TODO Auto-generated method stub
		return converEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}
	
	@Override
	public List<ProduitDTO> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll().stream()
				.map(this::converEntityToDto)
				.collect(Collectors.toList());
		
		/*List<Produit> prods = produitRepository.findAll();
		List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
		
		for (Produit p : prods)
			listprodDto.add(converEntityToDto(p));
		
		return listprodDto;*/
	}

	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.delete(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		// TODO Auto-generated method stub
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		// TODO Auto-generated method stub
		return produitRepository.trierProduitsNomsPrix();
	}

	@Override
	public ProduitDTO converEntityToDto(Produit produit) {
		// TODO Auto-generated method stub
		
		/*ProduitDTO produitDTO = new ProduitDTO();
		
		produitDTO.setIdProduit(p.getIdProduit());
		produitDTO.setNomProduit(p.getNomProduit());
		produitDTO.setPrixProduit(p.getPrixProduit());
		produitDTO.setCategorie(p.getCategorie());
		
		return produitDTO;*/
		
		/*return ProduitDTO.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.categorie(p.getCategorie())
				//.nomCat(p.getCategorie().getNomCat())
				.dateCreation(p.getDateCreation())
				.build();*/
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDto =  modelMapper.map(produit, ProduitDTO.class);
		return produitDto;
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		// TODO Auto-generated method stub
		
		/*Produit produit = new Produit();
		produit.setIdProduit(produitDto.getIdProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setCategorie(produitDto.getCategorie());
		return produit;*/
		
		Produit produit = new Produit();
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;
	}

}
