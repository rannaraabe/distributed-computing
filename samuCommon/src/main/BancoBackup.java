package main;

import tcp.TCPBancoBackup;
import udp.UDPBancoBackup;

public class BancoBackup {
	public static void main(String[] args) throws Exception {
		// UDP
//		UDPBancoBackup bancoUDP = new UDPBancoBackup(8085);
//		bancoUDP.iniciar();
//		System.out.println("UDP: Banco de Dados Backup desligando...");
		
		// TCP
		TCPBancoBackup bancoTCP = new TCPBancoBackup(8085);
		bancoTCP.iniciar();
		System.out.println("TCP: Banco de Dados Backup desligando...");		
	}
}
