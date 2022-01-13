package main;

import tcp.TCPLoadBalancer;
import udp.UDPLoadBalancer;

public class LoadBalancer {
	public static void main(String[] args) throws Exception {
		// UDP
//		UDPLoadBalancer loadBalancerUDP = new UDPLoadBalancer(8081);
//		loadBalancerUDP.iniciar();
//		System.out.println("UDP: Load Balancer desligando...");
		
		// TCP
		TCPLoadBalancer loadBalancerTCP = new TCPLoadBalancer(8081);
		loadBalancerTCP.iniciar();
		System.out.println("TCP: Load Balancer desligando...");
	}
}
