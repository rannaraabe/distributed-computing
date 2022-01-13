package entidade;

public class Acidente {
	private int id = 0;
	private double latitude;
	private double longitude;
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		this.id++;
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
