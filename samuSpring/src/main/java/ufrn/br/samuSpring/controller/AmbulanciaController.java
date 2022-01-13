package ufrn.br.samuSpring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufrn.br.samuSpring.model.Ambulancia;
import ufrn.br.samuSpring.service.AmbulanciaService;

@RestController
@RequestMapping(path="samu/ambulancia")
public class AmbulanciaController {
	private final AmbulanciaService ambulanciaService;
	
	// Autowiring: *Dependency Injection* (between two beans, to instanciate one bean in anoter automaticaly without new())
	@Autowired 
	public AmbulanciaController(AmbulanciaService ambulanciaService) {
		this.ambulanciaService = ambulanciaService;
	}
	
	@GetMapping 
	public List<Ambulancia> readAll() {
		return ambulanciaService.readAll();
	}
	
	@GetMapping (path = "{id}")
	public Optional<Ambulancia> read(@PathVariable("id") Long id) {
		return ambulanciaService.read(id);
	}
	
	@PutMapping
	public void update(@RequestBody Ambulancia ambulancia) {
		ambulanciaService.update(ambulancia);
	}
	
	@DeleteMapping(path = "{id}") 
	public void delete(@PathVariable("id") Long id) {
		ambulanciaService.delete(id);
	}
	
	@PostMapping
	public void create(@RequestParam(required = false) Double latitude,
								@RequestParam(required = false) Double longitude,
								@RequestParam(required = false) String placa,
								@RequestParam(required = false) String nomeMedico,
								@RequestParam(required = false) Long crmMedico,
								@RequestParam(required = false) String unidade,
								@RequestParam(required = false) LocalDate dataSocorro,
								@RequestParam(required = false) Long status){
		ambulanciaService.create(latitude, longitude, placa, nomeMedico, crmMedico, unidade, dataSocorro, status);
	}
}
