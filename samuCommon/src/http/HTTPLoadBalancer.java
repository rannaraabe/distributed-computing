//package http;
//
//import java.net.SocketException;
//
//import loadbalance.RoundRobin;
//import udp.UDP;
//
//public class HTTPLoadBalancer {
//	private HTTP http; 
//	public HTTPLoadBalancer(Integer porta) throws NumberFormatException, SocketException {
//		http = new HTTP(porta);
//	}
//
//	public void iniciar() throws Exception {
//		System.out.println("HTTP: Load Balancer inicializado!");
//		while (true) {
//			String mensagem = http.lerMensagem();
//			System.out.println("mensagemm = "+ mensagem);
//			Integer portaServico = RoundRobin.getPorta(); 
//			try {
////				http.enviarMensagem(mensagem, portaServico);
//			} catch(Exception e) {
//				portaServico = RoundRobin.getPorta();
////				http.enviarMensagem(mensagem, portaServico);
//			}
//		}
//	}
//}
