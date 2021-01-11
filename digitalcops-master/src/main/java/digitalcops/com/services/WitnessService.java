package digitalcops.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalcops.com.dao.CriminalRepository;
import digitalcops.com.dao.WitnessRepository;
import digitalcops.com.entities.Criminal;
import digitalcops.com.entities.Witness;
import digitalcops.com.model.CriminalModel;
import digitalcops.com.model.WitnessModel;

@Service
public class WitnessService {

	@Autowired
	private WitnessRepository witnessRepository;

	public WitnessModel findById(Long id) {
		Witness witness = witnessRepository.findById(id);
		WitnessModel witnessModel = convertObject(witness);
		return witnessModel;
	}

	

	public List<WitnessModel> findAll() {
		List<WitnessModel> listWitnessModel = new ArrayList<WitnessModel>();
		List<Witness> witnessList = witnessRepository.findAll();
		for (Witness witness : witnessList) {
			listWitnessModel.add(convertObject(witness));
		}
		return listWitnessModel;
	}

	public WitnessModel save(Witness witness) {
		Witness witnessDetails = witnessRepository.save(witness);
		return convertObject(witnessDetails);
	}

	public void delete(Witness witness) {
		witnessRepository.delete(witness);
	}

	

	private WitnessModel convertObject(Witness witness) {
		WitnessModel witnessModel = new WitnessModel();
		if (witness != null) {
			witnessModel.setId(witness.getId());
			witnessModel.setName(witness.getName());
			witnessModel.setAddress(witness.getAddress());
			witnessModel.setMobile(witness.getMobile());
			witnessModel.setComplaintId(witness.getComplaintId());
			witnessModel.setPoliceStationId(witness.getPoliceStationId());	
		}
		return witnessModel;
	}

	public WitnessModel update(Witness witness) {
		Witness oldWitness=new Witness();
		oldWitness.setId(witness.getId());
		oldWitness.setName(witness.getName());
		oldWitness.setAddress(witness.getAddress());
		oldWitness.setMobile(witness.getMobile());
		oldWitness.setComplaintId(witness.getComplaintId());
		oldWitness.setPoliceStationId(witness.getPoliceStationId());	
		Witness witnessDetails = witnessRepository.save(oldWitness);
		return convertObject(witnessDetails);
}
}
