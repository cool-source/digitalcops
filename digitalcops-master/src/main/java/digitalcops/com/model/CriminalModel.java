package digitalcops.com.model;

public class CriminalModel {
	private Long id;
	private String name;
	private String address;
	private long mobile;
	private int complaintId;
	private int PoliceStationId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public int getPoliceStationId() {
		return PoliceStationId;
	}
	public void setPoliceStationId(int policeStationId) {
		PoliceStationId = policeStationId;
	}
}