//package http;
//
//import java.io.IOException;
//import java.util.Map;
//
//import udp.CamadaTransporte;
//
//public class HTTP {
//	private CamadaTransporte transporte;
//	
//	public HTTP(CamadaTransporte ct) {
//		this.transporte = ct;
//	}
//	
//	public String lerMensagem() throws IOException {
//		String mensagem = transporte.lerMensagem();
//		return mensagem;
//	}
	
//	public void post(String caminho, Map<String, String> cabecalho, String body, String versao){
//		
//	}
	
//	public void enviarMensagem(String mensagem, Integer porta) throws Exception{
//		String statusLine;
//		String serverHeader = "Server: WebServer\r\n";
//		String contentTypeHeader = "Content-Type: text/html\r\n";
//
//		try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {
//			if (statusCode == 200) {
//				statusLine = "HTTP/1.0 200 OK" + "\r\n";
//				String contentLengthHeader = "Content-Length: " + responseString.length() + "\r\n";
//				out.writeBytes(statusLine);
//				out.writeBytes(serverHeader);
//				out.writeBytes(contentTypeHeader);
//				out.writeBytes(contentLengthHeader);
//				out.writeBytes("\r\n");
//				out.writeBytes(responseString);
//			} else if (statusCode == 405) {
//				statusLine = "HTTP/1.0 405 Method Not Allowed" + "\r\n";
//				out.writeBytes(statusLine);
//				out.writeBytes("\r\n");
//			} else {
//				statusLine = "HTTP/1.0 404 Not Found" + "\r\n";
//				out.writeBytes(statusLine);
//				out.writeBytes("\r\n");
//			}
//			out.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
//}
