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

import digitalcops.com.entities.Witness;
import digitalcops.com.model.WitnessModel;
import digitalcops.com.services.WitnessService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WitnessController {

	@Autowired
	private WitnessService witnessService;


	@RequestMapping("/getWitness/{id}")
	public ResponseEntity<WitnessModel> getCriminal(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(witnessService.findById(id));
	}

	@RequestMapping("/getWitness")
	public ResponseEntity<List<WitnessModel>> getCriminals() {
		return ResponseEntity.ok().body(witnessService.findAll());
	}

	@PostMapping("/saveWitness")
	public ResponseEntity<WitnessModel> saveCriminals(@Valid @RequestBody Witness witness) {
		final WitnessModel saveWitness = witnessService.save(witness);
		return ResponseEntity.ok(saveWitness);
	}
	@PutMapping("/updateWitness")
	public ResponseEntity<WitnessModel> updateCriminals(@Valid @RequestBody Witness witness) {
		final WitnessModel updateWitness = witnessService.update(witness);
		return ResponseEntity.ok(updateWitness);
	}

}
