package org.gescom.web;

import java.util.List;

import org.gescom.entities.Client;
import org.gescom.metier.ClientMetier;
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
public class ClientRestController {
	@Autowired
	private ClientMetier clientMetier;
	@PostMapping("/client/{idType}")
	public Client saveClient(@RequestBody Client c, @PathVariable  Long idType) {
		return clientMetier.saveClient(c, idType);
	}
	@PutMapping("/client/{idClient}/{idtype}")
	public Client updateClient(
			@PathVariable Long idClient, @RequestBody Client c, @PathVariable Long idtype) {
		return clientMetier.updateClient(idClient, c, idtype);
	}
	@DeleteMapping("/client/{idClient}")
	public boolean deleteClient(@PathVariable Long idClient) {
		return clientMetier.deleteClient(idClient);
	}
	@GetMapping("/client")
	public List<Client> getAllClient() {
		return clientMetier.getAllClient();
	}
	@GetMapping("/clientId/{idClient}")
	public Client getClient(Long idClient) {
		return clientMetier.getClient(idClient);
	}
	@GetMapping("/clientMc")
	public Page<Client> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return clientMetier.getParMc(mc, page, size);
	}
	
}
