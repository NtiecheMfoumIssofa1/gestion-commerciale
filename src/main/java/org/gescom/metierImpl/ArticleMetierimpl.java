package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.ArticleRepository;
import org.gescom.dao.FamilleAricleRepository;
import org.gescom.dao.FournisseurRepository;
import org.gescom.dao.StockRepository;
import org.gescom.dao.TaxeRepository;
import org.gescom.entities.Article;
import org.gescom.entities.FamilleArticle;
import org.gescom.entities.Fournisseur;
import org.gescom.entities.Stock;
import org.gescom.entities.Taxes;
import org.gescom.metier.ArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ArticleMetierimpl implements ArticleMetier{
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private FamilleAricleRepository familleRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	@Autowired
	private FournisseurRepository fournisseurrepository;
	@Autowired
	private StockRepository stockRepository;
	@Override
	public Article saveArticle(Article a, Long idFamile, Long idTaxe, Long idFournisseur, Long refStock) {
		FamilleArticle fa=familleRepository.getOne(idFamile);
		Taxes t=taxeRepository.getOne(idTaxe);
		Fournisseur fo=fournisseurrepository.getOne(idFournisseur);
		Stock s=stockRepository.getOne(refStock);
		
		a.setFamilleArticle(fa);
		a.setTaxes(t);
		a.setFournisseur(fo);
		a.setStock(s);
		return articleRepository.save(a);
	}

	@Override
	public Article updateArticle(String idArticle, Article a, Long idFamile, Long idTaxe, Long idFournisseur,
			Long refStock) {
		FamilleArticle fa=familleRepository.getOne(idFamile);
		Taxes t=taxeRepository.getOne(idTaxe);
		Fournisseur fo=fournisseurrepository.getOne(idFournisseur);
		Stock s=stockRepository.getOne(refStock);
		
		a.setRefArticle(idArticle);
		a.setFamilleArticle(fa);
		a.setTaxes(t);
		a.setFournisseur(fo);
		a.setStock(s);
		return articleRepository.save(a);
	}

	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public Article getArticle(String idArticle) {
		// TODO Auto-generated method stub
		return articleRepository.getOne(idArticle);
	}

	@Override
	public Page<Article> getArticleParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteArticle(String idArticle) {
		
	if (getArticle(idArticle)!=null) return true;
	else return false;
	}

}
