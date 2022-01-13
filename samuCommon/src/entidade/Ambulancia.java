package entidade;

public class Ambulancia {
	private int id;
	private double latitude;
	private double longitude;
	private String placa;
	private String nomeMedico;
	private int cmrMedico;
	private String unidade;
	private String dataSocorro;
	private int status;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getNomeMedico() {
		return nomeMedico;
	}
	
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	
	public int getCmrMedico() {
		return cmrMedico;
	}
	
	public void setCmrMedico(int cmrMedico) {
		this.cmrMedico = cmrMedico;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public String getDataSocorro() {
		return dataSocorro;
	}
	
	public void setDataSocorro(String dataSocorro) {
		this.dataSocorro = dataSocorro;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
