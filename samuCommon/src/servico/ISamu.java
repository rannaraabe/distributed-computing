package servico;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ISamu {
	public void iniciarChamado(String dados) throws NumberFormatException, IOException ;
	public void chamarAmbulancia(String[] listaDados) throws FileNotFoundException;
	public double calcularHaversine(double latitude, double longitude, double latitudeAcidente, double longitudeAcidente);
	public void salvarDados(String[] listaDados) throws NumberFormatException, IOException;
}
