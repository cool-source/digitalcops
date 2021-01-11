package digitalcops.com.model;

public class PoliceStationModel {

	private Long id;
	private String policeStationName;
	private String policeStationCity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPoliceStationName() {
		return policeStationName;
	}
	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}
	public String getPoliceStationCity() {
		return policeStationCity;
	}
	public void setPoliceStationCity(String policeStationCity) {
		this.policeStationCity = policeStationCity;
	}
}
