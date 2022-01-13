package udp;

import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import loadbalance.RoundRobin;
import servico.Samu;

public class UDPBanco {
	private List<Integer> backups;
	private UDP udp; 
	
	public UDPBanco(Integer porta, Integer... backups) throws NumberFormatException, SocketException {
		udp = new UDP(porta);
		this.backups = Arrays.asList(backups);
	}

	public void iniciar() throws Exception {
		System.out.println("UDP: Banco inicializado!");
		while (true) {
			DatagramPacket pacote = udp.lerMensagem();
			String mensagem = new String(pacote.getData());
			
			for(Integer porta : backups) {
				if(udp.servicoOn(porta)) {					
					udp.enviarMensagem(mensagem, porta);
				}
			}
		
			Samu samu = new Samu();
			samu.iniciarChamado(new String(pacote.getData()));
			System.out.println("UDP: Mesagem chegou ao banco!");
		}
	}
}
