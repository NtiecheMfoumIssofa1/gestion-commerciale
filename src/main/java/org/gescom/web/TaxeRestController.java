package org.gescom.web;

import java.util.List;

import org.gescom.entities.Taxes;
import org.gescom.metier.TaxeMetier;
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
public class TaxeRestController {
	@Autowired
	private TaxeMetier taxeMetier;

	@PostMapping("/taxe")
	public Taxes saveTaxes(@RequestBody Taxes s) {
		return taxeMetier.saveTaxes(s);
	}
	@PutMapping("/taxe/{idTaxes}")
	public Taxes updateTaxes(@PathVariable Long idTaxes, @RequestBody Taxes s) {
		return taxeMetier.updateTaxes(idTaxes, s);
	}
	@DeleteMapping("/taxe/{idStatut}")
	public boolean deleteTaxes(@PathVariable Long idStatut) {
		return taxeMetier.deleteTaxes(idStatut);
	}
	@GetMapping("/taxeId/{idTaxes}")
	public Taxes getTaxes(Long idTaxes) {
		return taxeMetier.getTaxes(idTaxes);
	}
	@GetMapping("/taxe")
	public List<Taxes> getAllTaxes() {
		return taxeMetier.getAllTaxes();
	}
	@GetMapping("/taxeMc")
	public Page<Taxes> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return taxeMetier.getParMc(mc, page, size);
	}
	

}
