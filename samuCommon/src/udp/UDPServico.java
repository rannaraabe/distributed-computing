package udp;

import java.net.DatagramPacket;
import java.net.SocketException;

public class UDPServico {
	private UDP udp; 
	
	public UDPServico(Integer porta) throws NumberFormatException, SocketException {
		udp = new UDP(porta);
	}

	public void iniciar() throws Exception {
		System.out.println("UDP: Serviço inicializado!");
		while (true) {
			DatagramPacket pacote = udp.lerMensagem();
			String mensagem = new String(pacote.getData());
			
//			Integer portaBanco = 8084; 
//			try {
//				udp.enviarMensagem(mensagem, portaBanco);
//			} catch(Exception e) {
//				portaBanco = 8085;
//				udp.enviarMensagem(mensagem, portaBanco);
//			}
			
			Integer portaBanco = 8084;
			if(udp.servicoOn(portaBanco)) {
				udp.enviarMensagem(mensagem, portaBanco);
			} else {
				portaBanco = 8085;
				udp.enviarMensagem(mensagem, portaBanco);
			}
		}
	}
}
