package org.gescom.web;

import java.util.List;

import org.gescom.entities.Commande;
import org.gescom.metier.CommandeMetier;
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
public class CommandeResctController {
	@Autowired
	private CommandeMetier commandeMetier;
	@PostMapping("/commande/{idFournisseur}")
	public Commande saveCommande(@RequestBody Commande c,@PathVariable Long idFournisseur) {
		return commandeMetier.saveCommande(c, idFournisseur);
	}
	@PutMapping("/commande/{idCde}/{idFournisseur}")
	public Commande updateCommande(
				@PathVariable Long idCde, 
				@RequestBody Commande c, 
				@PathVariable Long idFournisseur) {
		return commandeMetier.updateCommande(idCde, c, idFournisseur);
	}
	@DeleteMapping("/commande/{idCde}")
	public boolean deleteCommande(Long idCde) {
		return commandeMetier.deleteCommande(idCde);
	}
	@GetMapping("/commande")
	public List<Commande> getAllCommande() {
		return commandeMetier.getAllCommande();
	}
	@GetMapping("/commandeId/{idCde}")
	public Commande getCommande(@PathVariable Long idCde) {
		return commandeMetier.getCommande(idCde);
	}
	@GetMapping("/commandeMc")
	public Page<Commande> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="page")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return commandeMetier.getParMc(mc, page, size);
	}
		

}
