package digitalcops.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digitalcops.com.entities.PoliceStation;
import digitalcops.com.model.PoliceStationModel;
import digitalcops.com.services.PoliceStationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PoliceStationController {

	@Autowired
	private PoliceStationService policeStationService;

	@RequestMapping("/getPoliceStation/{id}")
	public ResponseEntity<PoliceStationModel> getPoliceStation(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(policeStationService.findById(id));
	}

	@RequestMapping("/getPoliceStations")
	public ResponseEntity<List<PoliceStationModel>> getPoliceStations() {
		return ResponseEntity.ok().body(policeStationService.findAll());
	}

	@PostMapping("/savePoliceStation")
	public ResponseEntity<PoliceStationModel> savePoliceStation(@Valid @RequestBody PoliceStation policeStation) {
		final PoliceStationModel savePoliceStation = policeStationService.save(policeStation);
		return ResponseEntity.ok(savePoliceStation);
	}
	@PutMapping("/updatePoliceStation")
	public ResponseEntity<PoliceStationModel> updatePoliceStation(@Valid @RequestBody PoliceStation policeStation) {
		final PoliceStationModel savePoliceStation = policeStationService.update(policeStation);
		return ResponseEntity.ok(savePoliceStation);
	}
	

}
