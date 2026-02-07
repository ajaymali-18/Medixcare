package com.youngelement.medixcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youngelement.medixcare.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
