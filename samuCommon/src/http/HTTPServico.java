//package http;
//
//import java.net.SocketException;
//
//import udp.CamadaTransporte;
//import udp.UDP;
//
//public class HTTPServico {
//	private HTTP http; 
//	
//	public HTTPServico(Integer porta) throws NumberFormatException, SocketException {
//		CamadaTransporte ct = new UDP(porta);
//		http = new HTTP(ct);
//	}
//
//	public void iniciar() throws Exception {
//		System.out.println("HTTP: Serviço inicializado!");
//		while (true) {
//			String mensagem = http.lerMensagem();
//			
//			Integer portaBanco = 8084; 
//			try {
////				http.enviarMensagem(mensagem, portaBanco);
//			} catch(Exception e) {
//				portaBanco = 8085;
////				http.enviarMensagem(mensagem, portaBanco);
//			}
//		}
//	}
//}
