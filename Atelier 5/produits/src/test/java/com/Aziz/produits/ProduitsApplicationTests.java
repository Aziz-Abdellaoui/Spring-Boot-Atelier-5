package com.Aziz.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.Aziz.produits.entities.Categorie;
import com.Aziz.produits.entities.Produit;
import com.Aziz.produits.repos.ProduitRepository;
import com.Aziz.produits.service.ProduitService;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	private ProduitService produitService;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Asus", 1500.500, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);

		System.out.println(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
	}

	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();

		for (Produit p : prods)
			System.out.println(p);

	}

	@Test
	public void testFindByNomProduitContains() {
		Page<Produit> prods = produitService.getAllProduitsParPage(0, 2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}

	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("iphone X");

		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("iphone X");

		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods =

				produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

}
