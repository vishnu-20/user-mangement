package com.usermanagment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagment.api.entity.RegistrationEntity;

import com.usermanagment.api.repository.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepo repo;

	@Override
	public String register(RegistrationEntity registrationEntity) {

		if (repo.save(registrationEntity) != null) {
			return "registeration successfull";
		} else {
			return null;
		}
	}

	@Override
	public RegistrationEntity login(RegistrationEntity registrationEntity) {
		List<RegistrationEntity> value = repo.findByUsername(registrationEntity.getUsername());

		try {
			return value.stream().filter(data -> data.getPassword().equalsIgnoreCase(registrationEntity.getPassword()))
					.findFirst().get();
		} catch (Exception e) {
			return null;
		}

	}

}
