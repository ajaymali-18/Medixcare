package com.youngelement.medixcare.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.youngelement.medixcare.dto.LoginRequest;
import com.youngelement.medixcare.dto.RegisterRequest;
import com.youngelement.medixcare.entity.User;
import com.youngelement.medixcare.enums.Role;
import com.youngelement.medixcare.repository.UserRepository;
import com.youngelement.medixcare.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

//	Dependency Injection
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// implemented Method from UserService Interface
	@Override
//	This method will Register the Patient.
	public void register(RegisterRequest request) {

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email Already Exists");
		}

		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.PATIENT);
		userRepository.save(user);

	}

//	This method will Login the Patient.
	@Override
	public void login(LoginRequest request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid Email or Password");
		}
		// For now: login success (JWT comes next)
	}

}
