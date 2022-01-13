package ufrn.br.samuSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Acidente {
	@Id
	@SequenceGenerator(
			name = "acidente_sequence",
			sequenceName = "acidente_sequence",
			allocationSize = 1 
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "acidente_sequence"
	)
	
	private Long id;
	private double latitude;
	private double longitude;
	
	public Acidente() {
		super();
	}
	
	public Acidente(Long id, double latitude, double longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Acidente(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
