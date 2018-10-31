package org.gescom.web;

import java.util.List;

import org.gescom.entities.Stock;
import org.gescom.metier.StockMetier;
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
public class StockRestController {
	@Autowired
	private StockMetier stockMetier;
	
	@PostMapping("/stock")
	public Stock saveStock(@RequestBody Stock s) {
		return stockMetier.saveStock(s);
	}
	@PutMapping("/stock/{idStock}")
	public Stock updateStock(@PathVariable Long idStock, @RequestBody Stock s) {
		return stockMetier.updateStock(idStock, s);
	}
	@DeleteMapping("/stock/{idStatut}")
	public boolean deleteStock(@PathVariable Long idStatut) {
		return stockMetier.deleteStock(idStatut);
	}
	@GetMapping("/stockId/{idStock}")
	public Stock getStock(@PathVariable Long idStock) {
		return stockMetier.getStock(idStock);
	}
	@GetMapping("/stock")
	public List<Stock> getAllStock() {
		return stockMetier.getAllStock();
	}
	@GetMapping("/stock")
	public Page<Stock> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return stockMetier.getParMc(mc, page, size);
	}

}
