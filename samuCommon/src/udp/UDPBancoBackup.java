package udp;

import java.net.DatagramPacket;
import java.net.SocketException;

import servico.Samu;

public class UDPBancoBackup {
	private UDP udp; 
	
	public UDPBancoBackup(Integer porta) throws NumberFormatException, SocketException {
		udp = new UDP(porta);
	}

	public void iniciar() throws Exception {
		System.out.println("UDP: Banco Backup inicializado!");
		while (true) {
			DatagramPacket pacote = udp.lerMensagem();
			String mensagem = new String(pacote.getData());
			
			if(!udp.servicoOn(8084)) {				
				Samu samu = new Samu();
				samu.iniciarChamado(mensagem);
				System.out.println("UDP: Mesagem chegou ao banco pelo backup!");
			}		
		}
	}
}
