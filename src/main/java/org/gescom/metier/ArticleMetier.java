package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Article;
import org.springframework.data.domain.Page;

public interface ArticleMetier {
	public Article saveArticle(Article a, Long idFamile,Long idTaxe,Long idFournisseur,Long refStock);
	public Article updateArticle(String idArticle,Article a, Long idFamile,Long idTaxe,Long idFournisseur,Long refStock);
	public List<Article> getAllArticle();
	public Article getArticle(String idArticle);
	public Page<Article> getArticleParMc(String mc, int page,int size);
	public boolean deleteArticle(String idArticle);

}
