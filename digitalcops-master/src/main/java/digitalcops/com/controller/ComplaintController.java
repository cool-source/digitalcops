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

import digitalcops.com.entities.Complaint;
import digitalcops.com.model.ComplaintModel;
import digitalcops.com.services.ComplaintService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("/getComplaint/{id}")
	public ResponseEntity<ComplaintModel> getComplaint(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(complaintService.findById(id));
	}

	@RequestMapping("/getComplaints")
	public ResponseEntity<List<ComplaintModel>> getPoliceStations() {
		return ResponseEntity.ok().body(complaintService.findAll());
	}

	@PostMapping("/saveComplaint")
	public ResponseEntity<ComplaintModel> saveComplaint(@Valid @RequestBody Complaint complaint) {
		final ComplaintModel saveComplaint = complaintService.save(complaint);
		return ResponseEntity.ok(saveComplaint);
	}
	@PutMapping("/updateComplaint")
	public ResponseEntity<ComplaintModel> updatePoliceStation(@Valid @RequestBody Complaint complaint) {
		final ComplaintModel updateComplaint= complaintService.update(complaint);
		return ResponseEntity.ok(updateComplaint);
	}
	

}

