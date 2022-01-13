package ufrn.br.samuSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufrn.br.samuSpring.model.Acidente;
import ufrn.br.samuSpring.service.AcidenteService;

@RestController 
@RequestMapping(path="samu/acidente") 
public class AcidenteController {
	private final AcidenteService acidenteService;
	
	// Autowiring: *Dependency Injection* (between two beans, to instanciate one bean in anoter automaticaly without new())
	@Autowired 
	public AcidenteController(AcidenteService acidenteService) {
		this.acidenteService = acidenteService;
	}

	@PostMapping
	public void chamarAmbulancia(@RequestBody Acidente acidente) {
		acidenteService.chamarAmbulancia(acidente);
	}
}
