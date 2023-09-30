package com.usermanagment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagment.api.entity.UserEntity;
import com.usermanagment.api.repository.UserManagementRepo;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagementRepo userRepository;

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<UserEntity> findbyRegId(Long regId) {

		return userRepository.findByRegId(regId);
	}

}
