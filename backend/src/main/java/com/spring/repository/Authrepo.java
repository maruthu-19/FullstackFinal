package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.AuthModel;

public interface Authrepo extends JpaRepository<AuthModel, Long> {

	AuthModel findByusername(String username);

}
