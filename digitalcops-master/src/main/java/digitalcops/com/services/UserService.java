package digitalcops.com.services;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalcops.com.dao.UserRepository;
import digitalcops.com.entities.Criminal;
import digitalcops.com.entities.User;
import digitalcops.com.model.CriminalModel;
import digitalcops.com.model.UserModel;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserModel findById(Long id) {
		User user = userRepository.findById(id);
		UserModel userModel = convertObject(user);
		return userModel;
	}

	public UserModel findByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		UserModel userModel = convertObject(user);
		return userModel;
	}

	public List<UserModel> findAll() {
		List<UserModel> listUserModel = new ArrayList<UserModel>();
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			listUserModel.add(convertObject(user));
		}
		return listUserModel;
	}

	public UserModel save(User user) {
		user.setLastModifyDate(new Date());
		User userDetails = userRepository.save(user);
		return convertObject(userDetails);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public UserModel isAuthorized(String userName, String password) {
		UserModel userModel = findByUserName(userName);
		if (userModel != null && userModel.getUserName().equals(userName) && userModel.getPassword().equals(password)) {
			userModel.setAuthorized(true);
		}
		return userModel;
	}

	private String generateRandomPassword() {
		Random RANDOM = new SecureRandom();
		int PASSWORD_LENGTH = 6;
		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@";

		StringBuffer password = new StringBuffer("");
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			password.append(letters.substring(index, index + 1));
		}
		return password.toString();
	}

	private UserModel convertObject(User user) {
		UserModel userModel = new UserModel();
		if (user != null) {
			userModel.setId(user.getId());
			userModel.setUserName(user.getUserName());
			userModel.setName(user.getName());
			userModel.setUserType(user.getUserType());
			userModel.setEmail(user.getEmail());
			userModel.setMobile(user.getMobile());
			userModel.setPassword(user.getPassword());
			userModel.setLastModifyBy(user.getLastModifyBy());
			userModel.setLastModifyDate(user.getLastModifyDate());
		
		}
		return userModel;
	}
		
		public UserModel update(User user) {
			User oldUser=new User();
			oldUser.setId(user.getId());
			oldUser.setName(user.getName());
			oldUser.setEmail(user.getEmail());
			oldUser.setUserName(user.getUserName());
			oldUser.setUserType(user.getUserType());
			oldUser.setPassword(user.getPassword());
			oldUser.setLastModifyBy(user.getLastModifyBy());
			oldUser.setLastModifyDate(user.getLastModifyDate());
			User userDetails = userRepository.save(oldUser);
			return convertObject(userDetails);
		}

}