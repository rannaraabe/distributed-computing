package http;

import java.util.Map;

public class RespostaHTTP {
	private String versao;
	private Integer statusCode;
	private String body;
	private Map<String, String> cabecalho;
	
	public String getVersao() {
		return versao;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public Map<String, String> getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(Map<String, String> cabecalho) {
		this.cabecalho = cabecalho;
	}
	
}
