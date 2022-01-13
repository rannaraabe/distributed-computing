package ufrn.br.samuSpring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufrn.br.samuSpring.model.Ambulancia;
import ufrn.br.samuSpring.repository.SamuRepository;

@Service
public class AmbulanciaService {
	private final SamuRepository samuRepository;

	
	@Autowired
	public AmbulanciaService(SamuRepository samuRepository) {
		this.samuRepository = samuRepository;
	}
	
	public List<Ambulancia> readAll() {
		return samuRepository.findAll();
	}
	
	
	public Optional<Ambulancia> read(Long id) {
		return samuRepository.findById(id);
	}
	

	public void update(Ambulancia ambulancia) {
		Optional<Ambulancia> ambulanciaOptional = samuRepository.findById(ambulancia.getId());
		if(ambulanciaOptional.isPresent()) {
			throw new IllegalStateException("Registro de ambulância atualizada!");
		}
		
		samuRepository.save(ambulancia);
	}
	
	public void delete(Long id) {
		boolean samu = samuRepository.existsById(id);
		
		if(!samu) {
			throw new IllegalStateException("Registro de ambulância com id= " + id + " não existe!");
		}
		samuRepository.deleteById(id);
	}
	
	@Transactional		
	public void create(Double latitude, 
					Double longitude,
					String placa,
					String nomeMedico,
					Long crmMedico,
					String unidade,
					LocalDate dataSocorro,
					Long status) {

		Ambulancia ambulancia = new Ambulancia(latitude, longitude, placa, nomeMedico, crmMedico, unidade, dataSocorro, status);
		samuRepository.save(ambulancia);
				
//				samuRepository.findById(id).orElseThrow(() -> new IllegalStateException("Ambulancia com id= " + id + " não existe!"));
		
//		if(!Objects.equals(ambulancia.getId(), id)) {
//			Optional<Ambulancia> ambulanciaOptional = samuRepository.findById(id);
//			if(ambulanciaOptional.isPresent()) {
//				throw new IllegalStateException("Registro de ambulância criada!");
//			}
//			ambulancia.setId(id);
//		}
		
//		if(!Objects.equals(ambulancia.getLatitude(), latitude)) {
//			ambulancia.setLatitude(latitude);
//		}
//		
//		if(!Objects.equals(ambulancia.getLongitude(), longitude)) {
//			ambulancia.setLongitude(longitude);
//		}
//		
//		if(placa != null && placa.length() > 0 && !Objects.equals(ambulancia.getPlaca(), placa)) {
//			ambulancia.setPlaca(placa);
//		}
//		
//		if(nomeMedico != null && nomeMedico.length() > 0 && !Objects.equals(ambulancia.getNomeMedico(), nomeMedico)) {
//			ambulancia.setNomeMedico(nomeMedico);
//		}
//		
//		if(!Objects.equals(ambulancia.getCmrMedico(), crmMedico)) {
//			ambulancia.setCmrMedico(crmMedico);
//		}
//		
//		if(unidade != null && unidade.length() > 0 && !Objects.equals(ambulancia.getUnidade(), unidade)) {
//			ambulancia.setUnidade(unidade);
//		}
//		
//		if(dataSocorro != null && !Objects.equals(ambulancia.getDataSocorro(), dataSocorro)) {
//			ambulancia.setDataSocorro(dataSocorro);
//		}
//			
//		if(!Objects.equals(ambulancia.getStatus(), status)) {
//			ambulancia.setStatus(status);
//		}
	}
	
}
