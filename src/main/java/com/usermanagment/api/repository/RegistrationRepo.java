package com.usermanagment.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.api.entity.RegistrationEntity;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Long> {
	List<RegistrationEntity> findByUsername(String username);
}
