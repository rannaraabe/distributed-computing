package main;

import tcp.TCPBanco;
import udp.UDPBanco;

public class BancoA {
	public static void main(String[] args) throws Exception {
//		 UDP
//		UDPBanco bancoUDP = new UDPBanco(8084, 8085);
//		bancoUDP.iniciar();
//		System.out.println("UDP: Banco de Dados A desligando...");
		
//		// TCP
		TCPBanco bancoTCP = new TCPBanco(8084);
		bancoTCP.iniciar();
		System.out.println("TCP: Banco de Dados A desligando...");
	
	}
}
