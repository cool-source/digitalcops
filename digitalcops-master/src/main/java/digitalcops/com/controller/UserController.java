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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import digitalcops.com.entities.User;
import digitalcops.com.entities.Witness;
import digitalcops.com.model.UserModel;
import digitalcops.com.model.WitnessModel;
import digitalcops.com.services.UserService;

import org.springframework.http.MediaType;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getUser/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@RequestMapping("/getUsers")
	public ResponseEntity<List<UserModel>> getUsers() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@PostMapping("/saveUser")
	public ResponseEntity<UserModel> seveUser(@Valid @RequestBody User user) {
		final UserModel saveUser = userService.save(user);
		return ResponseEntity.ok(saveUser);
	}
	@PutMapping("/updateUser")
	public ResponseEntity<UserModel> updateCriminals(@Valid @RequestBody User user) {
		final UserModel updateUser = userService.update(user);
		return ResponseEntity.ok(updateUser);
	}

	@RequestMapping(value = "/isAuthorizedUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> isAuthorized(@RequestBody User user) throws Exception {
		UserModel userModel = userService.isAuthorized(user.getUserName(), user.getPassword());
		return ResponseEntity.ok(userModel);
	}
	

}
