package digitalcops.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalcops.com.dao.CriminalRepository;
import digitalcops.com.entities.Criminal;
import digitalcops.com.model.CriminalModel;

@Service
public class CriminalService {

	@Autowired
	private CriminalRepository criminalRepository;

	public CriminalModel findById(Long id) {
		Criminal criminal = criminalRepository.findById(id);
		CriminalModel criminalModel = convertObject(criminal);
		return criminalModel;
	}

	

	public List<CriminalModel> findAll() {
		List<CriminalModel> listUserModel = new ArrayList<CriminalModel>();
		List<Criminal> criminalList = criminalRepository.findAll();
		for (Criminal criminal : criminalList) {
			listUserModel.add(convertObject(criminal));
		}
		return listUserModel;
	}

	public CriminalModel save(Criminal criminal) {
		Criminal criminalDetails = criminalRepository.save(criminal);
		return convertObject(criminalDetails);
	}

	public void delete(Criminal criminal) {
		criminalRepository.delete(criminal);
	}

	

	private CriminalModel convertObject(Criminal criminal) {
		CriminalModel criminalModel = new CriminalModel();
		if (criminal != null) {
			criminalModel.setId(criminal.getId());
			criminalModel.setName(criminal.getName());
			criminalModel.setAddress(criminal.getAddress());
			criminalModel.setMobile(criminal.getMobile());
			criminalModel.setComplaintId(criminal.getComplaintId());
			criminalModel.setPoliceStationId(criminal.getPoliceStationId());	
		}
		return criminalModel;
	}

	public CriminalModel update(Criminal criminal) {
		Criminal oldCriminal=new Criminal();
		oldCriminal.setId(criminal.getId());
		oldCriminal.setName(criminal.getName());
		oldCriminal.setAddress(criminal.getAddress());
		oldCriminal.setMobile(criminal.getMobile());
		oldCriminal.setComplaintId(criminal.getComplaintId());
		oldCriminal.setPoliceStationId(criminal.getPoliceStationId());	
		Criminal criminalDetails = criminalRepository.save(oldCriminal);
		return convertObject(criminalDetails);
	}

}

