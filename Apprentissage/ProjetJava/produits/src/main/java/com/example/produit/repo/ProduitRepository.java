package com.example.produit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produit.entities.Produit;

//la classe Produit, Long c'est le type de son id
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
