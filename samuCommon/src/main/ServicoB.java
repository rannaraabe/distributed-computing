package main;

import tcp.TCPServico;
import udp.UDPServico;

public class ServicoB {
	public static void main(String[] args) throws Exception {
		// UDP
//		UDPServico servicoUDP = new UDPServico(8083);
//		servicoUDP.iniciar();
//		System.out.println("UDP: Serviço B desligando...");
//		
		// TCP
		TCPServico servicoTCP = new TCPServico(8083);
		servicoTCP.iniciar();
		System.out.println("TCP: Seviço B desligando...");
	}
}
