package digitalcops.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalcops.com.dao.ComplaintRepository;
import digitalcops.com.entities.Complaint;
import digitalcops.com.model.ComplaintModel;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	public ComplaintModel findById(Long id) {
		Complaint complaint = complaintRepository.findById(id);
		ComplaintModel complaintModel = convertObject(complaint);
		return complaintModel;
	}

	public ComplaintModel findByCity(String city) {
		Complaint complaint = complaintRepository.findByCity(city);
		ComplaintModel complaintModel = convertObject(complaint);
		return complaintModel;
	}

	public List<ComplaintModel> findAll() {
		List<ComplaintModel> listUserModel = new ArrayList<ComplaintModel>();
		List<Complaint> complaintList = complaintRepository.findAll();
		for (Complaint complaint : complaintList) {
			listUserModel.add(convertObject(complaint));
		}
		return listUserModel;
	}

	public ComplaintModel save(Complaint complaint) {
		Complaint policeStationDetails = complaintRepository.save(complaint);
		return convertObject(policeStationDetails);
	}

	public void delete(Complaint complaint) {
		complaintRepository.delete(complaint);
	}

	

	private ComplaintModel convertObject(Complaint complaint) {
		ComplaintModel complaintModel = new ComplaintModel();
		if (complaint != null) {
			complaintModel.setId(complaint.getId());
			complaintModel.setCity(complaint.getCity());
			complaintModel.setDescription(complaint.getDescription());
			complaintModel.setStatus(complaint.getStatus());
			complaintModel.setComplaintFiledDate(complaint.getComplaintFiledDate());
			complaintModel.setLastModifyBy(complaint.getLastModifyBy());
			complaintModel.setLastModifyDate(complaint.getLastModifyDate());
			complaintModel.setUserId(complaint.getUserId());
			complaintModel.setPoliceStationId(complaint.getPoliceStationId());
		}
		return complaintModel;
	}

	public ComplaintModel update(Complaint complaint) {
		Complaint oldComplaint=new Complaint();
		oldComplaint.setId(complaint.getId());
		oldComplaint.setCity(complaint.getCity());
		oldComplaint.setDescription(complaint.getDescription());
		oldComplaint.setStatus(complaint.getStatus());
		oldComplaint.setComplaintFiledDate(complaint.getComplaintFiledDate());
		oldComplaint.setLastModifyBy(complaint.getLastModifyBy());
		oldComplaint.setLastModifyDate(complaint.getLastModifyDate());
		oldComplaint.setUserId(complaint.getUserId());
		oldComplaint.setPoliceStationId(complaint.getPoliceStationId());
		Complaint complaintDetails = complaintRepository.save(oldComplaint);
		return convertObject(complaintDetails);
	}

}
