package org.gescom.web;


import java.util.List;

import org.gescom.entities.CategorieFournisseur;
import org.gescom.metier.CategorieFournisseurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategorieFournisseurRestController {
	@Autowired
	private CategorieFournisseurMetier categorieFournisseurMetier;
	@PostMapping("/categorieFournisseur")
	public CategorieFournisseur saveCategorie(@RequestBody CategorieFournisseur categorieFournisseur) {
		return categorieFournisseurMetier.saveCategorie(categorieFournisseur);
	}
	@PutMapping("/categorieFournisseur/{idCat}")
	public CategorieFournisseur updateCategorie(@PathVariable Long idCat, @RequestBody CategorieFournisseur categorieFournisseur) {
		return categorieFournisseurMetier.updateCategorie(idCat, categorieFournisseur);
	}
	@GetMapping("/categorieFournisseur")
	public List<CategorieFournisseur> getAllCategorie() {
		return categorieFournisseurMetier.getAllCategorie();
	}
	@GetMapping("/categorieFournisseurId/{idCategorie}")
	public CategorieFournisseur getCategorie(@PathVariable Long idCategorie) {
		return categorieFournisseurMetier.getCategorie(idCategorie);
	}
	@GetMapping("/categorieFournisseurMc")
	public Page<CategorieFournisseur> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return categorieFournisseurMetier.getParMc(mc, page, size);
	}
	@DeleteMapping("/categorieFournisseur/{idCat}")
	public boolean deleteCategorie(@PathVariable Long idCat) {
		return categorieFournisseurMetier.deleteCategorie(idCat);
	}

}
