package org.gescom.web;

import java.util.List;

import org.gescom.entities.FamilleArticle;
import org.gescom.metier.FamilleArticleMetier;
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
public class FamilleRestController {
	

	@Autowired
	private FamilleArticleMetier familleMetier;
	
	@PostMapping("/familleArticle")
	public FamilleArticle saveFamille(@RequestBody FamilleArticle f) {
		return familleMetier.saveFamille(f);
	}
	@PutMapping("/familleArticle/{idFamille}")
	public FamilleArticle updateFamille(@PathVariable Long idFamille, @RequestBody FamilleArticle f) {
		return familleMetier.updateFamille(idFamille, f);
	}
	@DeleteMapping("/familleArticle")
	public boolean deleteFamilleArticle(@PathVariable Long idFamille) {
		return familleMetier.deleteFamilleArticle(idFamille);
	}
	@GetMapping("/familleArticleId/{idFamille}")
	public FamilleArticle getFamille(@PathVariable Long idFamille) {
		return familleMetier.getFamille(idFamille);
	}
	@GetMapping("/familleArticle")
	public List<FamilleArticle> getAllFamille() {
		return familleMetier.getAllFamille();
	}
	@GetMapping("/familleArticleMc")
	public Page<FamilleArticle> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return familleMetier.getParMc(mc, page, size);
	}

	
	

}
