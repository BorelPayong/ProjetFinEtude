package com.example.produit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.produit.entities.Produit;

@SpringBootApplication
//implements CommandLineRunner est une interface springboot qui sert a executé du code apres le demarrage de l'appli
public class ProduitsApplication implements CommandLineRunner {

	//RepositoryRestConfiguration est une interface spring data qui permet de personnalise le resultat des entité 
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub 
		//exposeIdsFor(Produit.class) lors de l'appel d'un service les id seront envoye dans le resultat 
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}
	
	//ModelMapper biblio java pour faire le mapping des different objet ; il sera tilise dans le service pour convertir mes objet en dto <=> entity
	//@Bean il est declare la pour pouvoir être utilise dans tout le projet??
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
