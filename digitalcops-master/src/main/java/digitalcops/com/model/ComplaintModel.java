package digitalcops.com.model;

import java.util.Date;

public class ComplaintModel {

	private Long id;
	private String city;
	private String description;
	private String status;
	private String complaintFiledDate;
	private String lastModifyBy;
	private Date lastModifyDate;
	private int userId;
	private int policeStationId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPoliceStationId() {
		return policeStationId;
	}
	public void setPoliceStationId(int policeStationid) {
		this.policeStationId = policeStationid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComplaintFiledDate() {
		return complaintFiledDate;
	}
	public void setComplaintFiledDate(String complaintFiledDate) {
		this.complaintFiledDate = complaintFiledDate;
	}
	public String getLastModifyBy() {
		return lastModifyBy;
	}
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	
}
