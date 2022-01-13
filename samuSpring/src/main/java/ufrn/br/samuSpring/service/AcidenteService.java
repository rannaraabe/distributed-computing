package ufrn.br.samuSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufrn.br.samuSpring.model.Acidente;
import ufrn.br.samuSpring.model.Ambulancia;
import ufrn.br.samuSpring.repository.SamuRepository;

@Service
public class AcidenteService {
	private final SamuRepository samuRepository;
	
	@Autowired
	public AcidenteService(SamuRepository samuRepository) {
		this.samuRepository = samuRepository;
	}
	
	public void chamarAmbulancia(Acidente acidente) {
		if(samuRepository.count() > 0) {
			
			Boolean ambulanciaEncontrada = false;
			double menorDistancia = Double.MAX_VALUE;
			Ambulancia ambulancia = new Ambulancia();
			
			for(Ambulancia samu : samuRepository.findAll()) {
				if(samu.getStatus() != null) {
					double distancia = calcularHaversine(acidente.getLatitude(), acidente.getLongitude(), samu.getLatitude(), samu.getLongitude());
					
					if(distancia < menorDistancia){
						menorDistancia = distancia;	
						samu.setId(samu.getId());
						samu.setLatitude(samu.getLatitude());
						samu.setLongitude(samu.getLongitude());
						samu.setPlaca(samu.getPlaca());
						samu.setNomeMedico(samu.getNomeMedico());
						samu.setCmrMedico(samu.getCmrMedico());
						samu.setUnidade(samu.getUnidade());
						samu.setDataSocorro(samu.getDataSocorro());
						samu.setStatus(samu.getStatus());
						ambulanciaEncontrada = true;
					}
				}
			}
			
			if(ambulanciaEncontrada) {				
				System.out.println("SAMU: A ambulância mais próxima está há " + menorDistancia + " km do acidente.");
				System.out.println("[ID: " + ambulancia.getId() +
						"\nLatitude: " + ambulancia.getLatitude() +
						"\nLongitude: " + ambulancia.getLongitude() +
						"\nPlaca: " + ambulancia.getPlaca() +
						"\nNome do médico responsável: " + ambulancia.getNomeMedico() +
						"\nCRM do médico: " + ambulancia.getCmrMedico() +
						"\nUnidade da ambulância: " + ambulancia.getUnidade() +
						"\nData do socorro: " + ambulancia.getDataSocorro() +
						"\nStatus: " + ambulancia.getStatus() + "]");
			} else {
				System.out.println("Sinto muito, todas as ambulâncias estão ocupadas no momento.");
			}
		} else {
			System.out.println("Não existem ambulâncias cadastradas no momento.");
		}
		
	}
	
	public double calcularHaversine(double latitude, double longitude, double latitudeAcidente, double longitudeAcidente) {
		double pi = Math.PI;
		
		double latitudeRadianos = latitude*pi/180;
		double longitudeRadianos = longitude*pi/180;
		double latitudeAcidenteRadianos = latitudeAcidente*pi/180;
		double longitudeAcidenteRadianos = longitudeAcidente*pi/180;
		
		double resultado = (Math.acos(Math.cos(latitudeRadianos)*Math.cos(longitudeRadianos)*Math.cos(latitudeAcidenteRadianos)*Math.cos(longitudeAcidenteRadianos)+Math.cos(latitudeRadianos)*Math.sin(longitudeRadianos)*Math.cos(latitudeAcidenteRadianos)*Math.sin(longitudeAcidenteRadianos)+Math.sin(latitudeRadianos)*Math.sin(latitudeAcidenteRadianos))*6371)*1.15;
		System.out.println("Resultado Haversine: " + resultado);
		
	    return resultado;
	}
	
}
