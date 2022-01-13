package banco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import entidade.Ambulancia;

public class Banco implements IBanco {
	private int newId = 0;
	private static final String FILENAME = "/home/rannaraabe/Documents/distributed-computing/samu/src/banco/banco.csv";
	// POST/samu/id/latitude/longitude/placa/nomeMedico/cmrMedico/unidade/dataSocorro/status
	
	@Override
	public int inserir(String[] listaDados) throws IOException {
		Ambulancia ambulancia = new Ambulancia();
		
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String linha;
		while((linha = br.readLine()) != null) {
			String[] dado = linha.split(",");
			
			if(dado[0] == "") {
				newId += 1;
			} else {
				newId = Integer.parseInt(dado[0])+1;
			}
		}		
		
		ambulancia.setId(newId);
		
		try {
			FileWriter csv = new FileWriter(FILENAME, true);
			
			ambulancia.setLatitude(Double.parseDouble(listaDados[3]));
			ambulancia.setLongitude(Double.parseDouble(listaDados[4]));
			ambulancia.setPlaca(listaDados[5]);
			ambulancia.setNomeMedico(listaDados[6]);
			ambulancia.setCmrMedico(Integer.parseInt(listaDados[7]));
			ambulancia.setUnidade(listaDados[8]);
			ambulancia.setDataSocorro(listaDados[9]);
			ambulancia.setStatus(Integer.parseInt(listaDados[10]));
			
			csv.append(String.valueOf(ambulancia.getId()) + ",");
			csv.append(String.valueOf(ambulancia.getLongitude())+ ",");
			csv.append(String.valueOf(ambulancia.getLatitude()) + ",");
			csv.append(ambulancia.getPlaca() + ",");
			csv.append(ambulancia.getNomeMedico() + ",");
			csv.append(String.valueOf(ambulancia.getCmrMedico()) + ",");
			csv.append(ambulancia.getUnidade() + ",");
			csv.append(ambulancia.getDataSocorro() + ",");
			csv.append(String.valueOf(ambulancia.getStatus()) + "\n");
			
			csv.flush();
			csv.close();
			System.out.println("BANCO: Dados adicionados no banco! Id: " + ambulancia.getId());
			
			return ambulancia.getId();
		} catch (IOException e) {
			System.out.println("BANCO: Problemas ao inserir dados no banco. Id: " + ambulancia.getId());
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public double[] buscar(int id) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String row;

		try {			
			while ((row = br.readLine()) != null) {
				String[] data = row.split(",");
				if(data[0].equals(String.valueOf(id))) {
					System.out.println("BANCO: Dado id=" + id + " encontrado!");
					double[] coordenadas = {Double.parseDouble(data[1]), Double.parseDouble(data[2])};
					System.out.println("BANCO: Coordenadas=[" + coordenadas[0] + ", " + coordenadas[1] + "]");
					return coordenadas;
				}
			}

		} catch (IOException e) {
			System.out.println("BANCO: Problemas ao buscar dado no banco. Id=" + id + " não está no banco!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Collection<String[]> buscarPorTodos() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		Collection<String[]> dados = null;
		String row;

		try {			
			while ((row = br.readLine()) != null) {
				String[] data = row.split(",");
				dados.add(data);
			}
			
			return dados;
		} catch (IOException e) {
			System.out.println("BANCO: Problemas ao buscar por todos!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int atualizar(int id, String[] listaDados) throws IOException {
		deletar(id);
		
		Ambulancia ambulancia = new Ambulancia();
		ambulancia.setId(id);
			
		try {
			FileWriter csv = new FileWriter(FILENAME, true);
			
			ambulancia.setLatitude(Double.parseDouble(listaDados[3]));
			ambulancia.setLongitude(Double.parseDouble(listaDados[4]));
			ambulancia.setPlaca(listaDados[5]);
			ambulancia.setNomeMedico(listaDados[6]);
			ambulancia.setCmrMedico(Integer.parseInt(listaDados[7]));
			ambulancia.setUnidade(listaDados[8]);
			ambulancia.setDataSocorro(listaDados[9]);
			ambulancia.setStatus(Integer.parseInt(listaDados[10]));
			
			csv.append(String.valueOf(ambulancia.getId()) + ",");
			csv.append(String.valueOf(ambulancia.getLongitude())+ ",");
			csv.append(String.valueOf(ambulancia.getLatitude()) + ",");
			csv.append(ambulancia.getPlaca() + ",");
			csv.append(ambulancia.getNomeMedico() + ",");
			csv.append(String.valueOf(ambulancia.getCmrMedico()) + ",");
			csv.append(ambulancia.getUnidade() + ",");
			csv.append(ambulancia.getDataSocorro() + ",");
			csv.append(String.valueOf(ambulancia.getStatus()) + "\n");
			
			csv.flush();
			csv.close();
			System.out.println("BANCO: Dados atualizados no banco! Id: " + ambulancia.getId());
			
			return ambulancia.getId();
		} catch (IOException e) {
			System.out.println("BANCO: Problemas ao atualizar dado no banco. Id: " + ambulancia.getId());
			e.printStackTrace();
		}
		
		return -1;		
	}

	@Override
	public void deletar(int id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		Collection<String[]> dados = null;
		String row;

		try {			
			while ((row = br.readLine()) != null) {
				String[] data = row.split(",");
				System.out.println(data[0]);
				dados.add(data);
			}
			
			List<String[]> filtered = dados.stream()
					.filter(linha -> !linha[2].equals(id))
					.collect(Collectors.toList());
			
			FileWriter csv = new FileWriter(FILENAME, false);
			for (String[] linha : filtered) {
				for (String coluna : linha) {
					csv.append(coluna + ",");
				}
				csv.append("\n");
			}
			
			System.out.println("BANCO: Dado id=" + id + " deletado com sucesso!");
			
			csv.flush();
			csv.close();
		} catch (IOException e) {
			System.out.println("BANCO: Problemas ao deletar dado no banco. Id=" + id + " não está no banco!");
			e.printStackTrace();
		}
	}
}
