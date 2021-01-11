package digitalcops.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policeStations")
public class PoliceStation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
