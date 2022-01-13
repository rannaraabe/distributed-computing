package http;

import java.util.Map;

public class MensagemHTTP {
	private String caminho;
	private Map<String, String> cabecalho;
	private String body;
	private String versao;
	private Map<String, String> query;
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public Map<String, String> getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(Map<String, String> cabecalho) {
		this.cabecalho = cabecalho;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getVersao() {
		return versao;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Map<String, String> getQuery() {
		return query;
	}

	public void setQuery(Map<String, String> query) {
		this.query = query;
	}	
	
	public static MensagemHTTP fromString(String mensagem) {
		// TODO
		return null;
	}
}
