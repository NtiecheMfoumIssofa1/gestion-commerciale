package org.gescom.web;

import java.util.List;

import org.gescom.entities.Facture;
import org.gescom.metier.FactureMetier;
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
public class FactureResController {
	@Autowired
	private FactureMetier factureMetier;

	@PostMapping("/facture")
	public Facture saveFacture(@RequestBody Facture f) {
		return factureMetier.saveFacture(f);
	}
	@PutMapping("/facture/{idFacture}")
	public Facture updateFacture(@PathVariable String idFacture, @RequestBody Facture f) {
		return factureMetier.updateFacture(idFacture, f);
	}
	@DeleteMapping("/facture/{idFacture}")
	public boolean deleteFacture(@PathVariable String idFacture) {
		return factureMetier.deleteFacture(idFacture);
	}
	@GetMapping("/factureId/{idFacture}")
	public Facture getFacture(@PathVariable String idFacture) {
		return factureMetier.getFacture(idFacture);
	}
	@GetMapping("/facture")
	public List<Facture> getAllFacture() {
		return factureMetier.getAllFacture();
	}
	@GetMapping("/factureMc")
	public Page<Facture> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return factureMetier.getParMc(mc, page, size);
	}
	
}
