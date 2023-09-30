package com.usermanagment.api.service;

import com.usermanagment.api.entity.RegistrationEntity;

public interface RegistrationService {

	String register(RegistrationEntity registrationEntity);

	RegistrationEntity login(RegistrationEntity registrationEntity);

}
