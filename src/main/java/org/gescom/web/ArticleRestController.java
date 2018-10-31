package org.gescom.web;

import java.util.List;

import org.gescom.entities.Article;
import org.gescom.metier.ArticleMetier;
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
public class ArticleRestController {
	@Autowired
	private ArticleMetier articleMetier;
	@PostMapping("/article/{idFamille}/{idTaxe}/{idFournisseur}/{refStock}")
	public Article saveArticle(
			@RequestBody Article a, 
			@PathVariable Long idFamile, 
			@PathVariable Long idTaxe, 
			@PathVariable Long idFournisseur, 
			@PathVariable Long refStock) {
		return articleMetier.saveArticle(a, idFamile, idTaxe, idFournisseur, refStock);
	}
	@PutMapping("/article/{idArticle}/{idFamille}/{idTaxe}/{idFournisseur}/{refStock}")
	public Article updateArticle(
				@PathVariable String idArticle, 
				@RequestBody Article a, 
				@PathVariable Long idFamile, 
				@PathVariable Long idTaxe, 
				@PathVariable Long idFournisseur, 
				@PathVariable Long refStock) {
		return articleMetier.updateArticle(idArticle, a, idFamile, idTaxe, idFournisseur, refStock);
	}
	@GetMapping("/article")
	public List<Article> getAllArticle() {
		return articleMetier.getAllArticle();
	}
	@GetMapping("/article/{idArticle}")
	public Article getArticle(@PathVariable String idArticle) {
		return articleMetier.getArticle(idArticle);
	}
	@GetMapping("/articleMc")
	public Page<Article> getArticleParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return articleMetier.getArticleParMc(mc, page, size);
	}
	@DeleteMapping("/article/{idArticle}")
	public boolean deleteArticle(String idArticle) {
		return articleMetier.deleteArticle(idArticle);
	}

}
