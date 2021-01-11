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

import digitalcops.com.entities.Criminal;
import digitalcops.com.model.CriminalModel;
import digitalcops.com.services.CriminalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CriminalController {

	@Autowired
	private CriminalService criminalService;

	@RequestMapping("/getCriminal/{id}")
	public ResponseEntity<CriminalModel> getCriminal(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(criminalService.findById(id));
	}

	@RequestMapping("/getCriminals")
	public ResponseEntity<List<CriminalModel>> getCriminals() {
		return ResponseEntity.ok().body(criminalService.findAll());
	}

	@PostMapping("/saveCriminal")
	public ResponseEntity<CriminalModel> saveCriminals(@Valid @RequestBody Criminal criminal) {
		final CriminalModel savecriminal = criminalService.save(criminal);
		return ResponseEntity.ok(savecriminal);
	}
	@PutMapping("/updateCriminal")
	public ResponseEntity<CriminalModel> updateCriminals(@Valid @RequestBody Criminal criminal) {
		final CriminalModel updatecriminal = criminalService.update(criminal);
		return ResponseEntity.ok(updatecriminal);
	}
}
