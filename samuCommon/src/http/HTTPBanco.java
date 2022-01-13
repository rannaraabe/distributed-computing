//package http;
//
//import java.net.SocketException;
//import java.util.Arrays;
//import java.util.List;
//
//import servico.Samu;
//import udp.UDP;
//
//public class HTTPBanco {
//	private List<Integer> backups;
//	private HTTP http; 
//	
//	public HTTPBanco(Integer porta, Integer... backups) throws NumberFormatException, SocketException {
//		http = new HTTP(porta);
//		this.backups = Arrays.asList(backups);
//	}
//
//	public void iniciar() throws Exception {
//		System.out.println("HTTP: Banco inicializado!");
//		while (true) {
//			String mensagem = http.lerMensagem();
//			Samu samu = new Samu();
//			
////			for(Integer porta : backups) {
////				http.enviarMensagem(mensagem, porta);
////			}
//			
//			System.out.println("enviando mesagem para adicionar no banco");
//			samu.iniciarChamado(mensagem);
//			System.out.println("mesagem enviada para adicionar no banco");
//		}
//	}
//}
