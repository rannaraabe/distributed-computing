package ufrn.br.samuSpring.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Ambulancia {
	@Id
	@SequenceGenerator(
		name = "ambulancia_sequence",
		sequenceName = "ambulancia_sequence",
		allocationSize = 1 
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "ambulancia_sequence"
	)
	
	private Long id;
	private Double latitude;
	private Double longitude;
	private String placa;
	private String nomeMedico;
	private Long crmMedico;
	private String unidade;
	private LocalDate dataSocorro;
	private Long status;

	public Ambulancia() {
		super();
	}
	
	public Ambulancia(Long id, Double latitude, Double longitude, String placa, String nomeMedico, Long crmMedico, String unidade, LocalDate dataSocorro, Long status) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.placa = placa;
		this.nomeMedico = nomeMedico;
		this.crmMedico = crmMedico;
		this.unidade = unidade; 
		this.dataSocorro = dataSocorro;
		this.status = status;
	}
	
	public Ambulancia(Double latitude, Double longitude, String placa, String nomeMedico, Long crmMedico, String unidade, LocalDate dataSocorro, Long status) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.placa = placa;
		this.nomeMedico = nomeMedico;
		this.crmMedico = crmMedico;
		this.unidade = unidade; 
		this.dataSocorro = dataSocorro;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
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
	
	public Long getCmrMedico() {
		return crmMedico;
	}
	
	public void setCmrMedico(Long crmMedico) {
		this.crmMedico = crmMedico;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public LocalDate getDataSocorro() {
		return dataSocorro;
	}
	
	public void setDataSocorro(LocalDate dataSocorro) {
		this.dataSocorro = dataSocorro;
	}
	
	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}	
}
