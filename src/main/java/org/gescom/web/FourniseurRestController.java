package org.gescom.web;


import java.util.List;

import org.gescom.entities.Fournisseur;
import org.gescom.metier.FourniseurMetier;
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
public class FourniseurRestController {
	@Autowired
	private FourniseurMetier fourniseurMetier;
	
	@PostMapping("/fournisseur/{idStatut}/{idCategorie}")
	public Fournisseur saveFournisseur(
			@RequestBody Fournisseur f, 
			@PathVariable Long idStatut, 
			@PathVariable Long idCategorie) {
		return fourniseurMetier.saveFournisseur(f, idStatut, idCategorie);
	}
	@PutMapping("/fournisseur/{idFournisseur}/{idStatut}/{idCategorie}")
	public Fournisseur updateFournisseur(
			@PathVariable Long idFournisseur, 
			@RequestBody Fournisseur f, 
			@PathVariable Long idStatut, 
			@PathVariable Long idCategorie) {
		return fourniseurMetier.updateFournisseur(idFournisseur, f, idStatut, idCategorie);
	}
	@DeleteMapping("/fournisseur/{idFournisseur}")
	public boolean deleteFournisseur(Long idFournisseur) {
		return fourniseurMetier.deleteFournisseur(idFournisseur);
	}
	@GetMapping("/fournisseurId/{idFournisseur}")
	public Fournisseur getFournisseur(@PathVariable Long idFournisseur) {
		return fourniseurMetier.getFournisseur(idFournisseur);
	}
	@GetMapping("/fournisseur")
	public List<Fournisseur> getAllFournisseur() {
		return fourniseurMetier.getAllFournisseur();
	}
	@GetMapping("/fournisseur")
	public Page<Fournisseur> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return fourniseurMetier.getParMc(mc, page, size);
	}
	
}
