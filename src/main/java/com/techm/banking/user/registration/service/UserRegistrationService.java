package com.techm.banking.user.registration.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.banking.user.registration.dto.LoginDto;
import com.techm.banking.user.registration.exception.ValidationException;
import com.techm.banking.user.registration.helper.PasswordEncryptDecryptHelper;
import com.techm.banking.user.registration.model.User;
import com.techm.banking.user.registration.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Autowired
	private PasswordEncryptDecryptHelper passwordEncryptDecryptHelper;

	public List<User> getRegistredUsers() {
		return (List<User>) userRegistrationRepository.findAll();
	}

	public Optional<User> getRegistredUserByUserId(long id) {
		return userRegistrationRepository.findById(id);
	}

	public User getRegistredUserByUserNameOrEmail(LoginDto login) {
		return userRegistrationRepository.findRegistredUserByUserNameOrEmail(login.getUserName(), login.getEmail(),
				passwordEncryptDecryptHelper.encrypt(login.getPassword()));

	}

	public User registerUser(User user) throws ValidationException, ParseException {
		user.setPassword(passwordEncryptDecryptHelper.encrypt(user.getPassword()));
		user.setDob(changeDateFormat(user.getDob()));
		return userRegistrationRepository.save(user);
	}

	public User updateRegisteredUser(long id, User user) throws ValidationException, ParseException {
		User detachedUser = userRegistrationRepository.findById(id).get();
		detachedUser.setAddress(user.getAddress());
		detachedUser.setEmail(user.getEmail());
		detachedUser.setDob(changeDateFormat(user.getDob()));
		detachedUser.setFirstName(user.getFirstName());
		detachedUser.setGender(user.getGender());
		detachedUser.setLastName(user.getLastName());
		detachedUser.setPhoneNumber(user.getPhoneNumber());
		detachedUser.setUserName(user.getUserName());
		detachedUser.setPassword(passwordEncryptDecryptHelper.encrypt(user.getPassword()));
		return userRegistrationRepository.save(user);
	}

	private Date changeDateFormat(Date date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		return formatter1.parse(formatter1.format(formatter.parse(date.toString())));
	}
}
