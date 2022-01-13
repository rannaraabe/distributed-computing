package main;

import tcp.TCPServico;
import udp.UDPServico;

public class ServicoA {
	public static void main(String[] args) throws Exception {
		// UDP
//		UDPServico servicoUDP = new UDPServico(8082);
//		servicoUDP.iniciar();
//		System.out.println("UDP: Serviço A desligando...");
		
		// TCP
		TCPServico servicoTCP = new TCPServico(8082);
		servicoTCP.iniciar();
		System.out.println("TCP: Seviço A desligando...");
	}
}
