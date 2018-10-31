package org.gescom.web;

import java.util.List;

import org.gescom.entities.Vente;
import org.gescom.metier.VenteMetier;
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
public class VenteRestController {
	@Autowired
	private VenteMetier venteMetier;

	@PostMapping("/vente/{idClient}/{idFacture}")
	public Vente saveVente(
			@RequestBody Vente v,  
			@PathVariable Long idClient, 
			@PathVariable String idFacture) {
		return venteMetier.saveVente(v, idClient, idFacture);
	}
	@PutMapping("/vente/{idVente}/{idClient}/{idFacture}")
	public Vente updateVente(
			@PathVariable String idVente, 
			@RequestBody Vente a, 
			@PathVariable Long idClient, 
			@PathVariable String idFacture) {
		return venteMetier.updateVente(idVente, a, idClient, idFacture);
	}
	@GetMapping("/vente")
	public List<Vente> getAllVente() {
		return venteMetier.getAllVente();
	}
	@GetMapping("/venteId/{idVente}")
	public Vente getVente(String idVente) {
		return venteMetier.getVente(idVente);
	}
	@GetMapping("/venteMc")
	public Page<Vente> getVenteParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return venteMetier.getVenteParMc(mc, page, size);
	}
	@DeleteMapping("/vente/{idVente}")
	public boolean deleteVente(@PathVariable String idVente) {
		return venteMetier.deleteVente(idVente);
	}
	
}
