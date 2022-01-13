package servico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import banco.*;
import entidade.Acidente;
import entidade.Ambulancia;

public class Samu implements ISamu {	
	private static ISamu instancia;
	protected IBanco banco;
	
	public Samu() {
		this.banco = new Banco();
	}
	
	// Singleton
	public static ISamu getInstancia() {
		if(instancia == null) {
			instancia = new Samu();
		}
		return instancia;
	}
	
	@Override
	public void iniciarChamado(String dados) throws NumberFormatException, IOException {
		// id/latitude/longitude/placa/nomeMedico/cmrMedico/unidade/dataSocorro/status
		System.out.println(dados);
		String[] listaDados = dados.split("/");
		
		if(listaDados[1].equals("acidente")) {
			chamarAmbulancia(listaDados);
		} else if(listaDados[1].equals("samu")) {
			salvarDados(listaDados);
		}
	}
	
	public void chamarAmbulancia(String[] listaDados) throws FileNotFoundException {
		Acidente acidente = new Acidente();
		acidente.setId();
		acidente.setLatitude(Double.parseDouble(listaDados[3]));
		acidente.setLongitude(Double.parseDouble(listaDados[4]));
		
		Collection<String[]> bancoCompleto = this.banco.buscarPorTodos();
		double menorDistancia = Double.MAX_VALUE;
		Ambulancia ambulancia = new Ambulancia();
		
		if(bancoCompleto == null) {
			System.out.println("SAMU: Não existem ambulâncias cadastradas no momento.");
		} else {
			boolean ambulanciaEncontrada = false;
			for (String[] linha : bancoCompleto) {
				if(Integer.parseInt(linha[10]) == 1) {					
					double distancia = calcularHaversine(Double.parseDouble(linha[3]), Double.parseDouble(linha[4]), acidente.getLatitude(), acidente.getLongitude());
					if(distancia < menorDistancia){
						menorDistancia = distancia;
						
						ambulancia.setLatitude(Double.parseDouble(listaDados[3]));
						ambulancia.setLongitude(Double.parseDouble(listaDados[4]));
						ambulancia.setPlaca(listaDados[5]);
						ambulancia.setNomeMedico(listaDados[6]);
						ambulancia.setCmrMedico(Integer.parseInt(listaDados[7]));
						ambulancia.setUnidade(listaDados[8]);
						ambulancia.setDataSocorro(listaDados[9]);
						ambulancia.setStatus(Integer.parseInt(listaDados[10]));
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
				System.out.println("SAMU: Sinto muito, todas as ambulâncias estão ocupadas no momento.");
			}
		}
	}
	
	@Override
	public double calcularHaversine(double latitude, double longitude, double latitudeAcidente, double longitudeAcidente) {
		double pi = Math.PI;
		
		double latitudeRadianos = latitude*pi/180;
		double longitudeRadianos = longitude*pi/180;
		double latitudeAcidenteRadianos = latitudeAcidente*pi/180;
		double longitudeAcidenteRadianos = longitudeAcidente*pi/180;
		
		double resultado = (Math.acos(Math.cos(latitudeRadianos)*Math.cos(longitudeRadianos)*Math.cos(latitudeAcidenteRadianos)*Math.cos(longitudeAcidenteRadianos)+Math.cos(latitudeRadianos)*Math.sin(longitudeRadianos)*Math.cos(latitudeAcidenteRadianos)*Math.sin(longitudeAcidenteRadianos)+Math.sin(latitudeRadianos)*Math.sin(latitudeAcidenteRadianos))*6371)*1.15;
		System.out.println("SAMU: Resultado Haversine: " + resultado);
		
	    return resultado;
	}
	
	public void salvarDados(String[] listaDados) throws NumberFormatException, IOException {
		switch (listaDados[0]) {
		case "POST":
			this.banco.inserir(listaDados);
			break;
		case "GET":
			this.banco.buscar(Integer.parseInt(listaDados[2]));
			break;
		case "PUT":
			this.banco.atualizar(Integer.parseInt(listaDados[2]), listaDados);
			break;
		case "DELETE":
			this.banco.deletar(Integer.parseInt(listaDados[2]));
			break;
		default:
			break;
		}
	}
}
