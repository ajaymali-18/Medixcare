package com.youngelement.medixcare.service;

import com.youngelement.medixcare.dto.LoginRequest;
import com.youngelement.medixcare.dto.RegisterRequest;

public interface UserService {
	void register(RegisterRequest request);

	void login(LoginRequest request);
}
