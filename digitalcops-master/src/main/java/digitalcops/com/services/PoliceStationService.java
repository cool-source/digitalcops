package digitalcops.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalcops.com.dao.PoliceStationRepository;
import digitalcops.com.entities.PoliceStation;
import digitalcops.com.model.PoliceStationModel;

@Service
public class PoliceStationService {
	@Autowired
	private PoliceStationRepository policeStationRepository;

	public PoliceStationModel findById(Long id) {
		PoliceStation policeStation = policeStationRepository.findById(id);
		PoliceStationModel policeStationModel = convertObject(policeStation);
		return policeStationModel;
	}

	public PoliceStationModel findByUserName(String policeStationName) {
		PoliceStation policeStation = policeStationRepository.findByPoliceStationName(policeStationName);
		PoliceStationModel policeStationModel = convertObject(policeStation);
		return policeStationModel;
	}

	public List<PoliceStationModel> findAll() {
		List<PoliceStationModel> listUserModel = new ArrayList<PoliceStationModel>();
		List<PoliceStation> policeStationList = policeStationRepository.findAll();
		for (PoliceStation policeStation : policeStationList) {
			listUserModel.add(convertObject(policeStation));
		}
		return listUserModel;
	}

	public PoliceStationModel save(PoliceStation policeStation) {
		PoliceStation policeStationDetails = policeStationRepository.save(policeStation);
		return convertObject(policeStationDetails);
	}

	public void delete(PoliceStation policeStation) {
		policeStationRepository.delete(policeStation);
	}

	

	private PoliceStationModel convertObject(PoliceStation policeStation) {
		PoliceStationModel policeStationModel = new PoliceStationModel();
		if (policeStation != null) {
			policeStationModel.setId(policeStation.getId());
			policeStationModel.setPoliceStationName(policeStation.getPoliceStationName());
			policeStationModel.setPoliceStationCity(policeStation.getPoliceStationCity());
			
		
		}
		return policeStationModel;
	}

	public PoliceStationModel update(PoliceStation policeStation) {
		PoliceStation oldPoliceStation=new PoliceStation();
		oldPoliceStation.setId(policeStation.getId());
		oldPoliceStation.setPoliceStationCity(policeStation.getPoliceStationCity());
		oldPoliceStation.setPoliceStationName(policeStation.getPoliceStationName());
		
		PoliceStation policeStationDetails = policeStationRepository.save(oldPoliceStation);
		return convertObject(policeStationDetails);
	}


}
