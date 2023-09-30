package com.usermanagment.api.service;

import java.util.List;

import com.usermanagment.api.entity.UserEntity;

public interface UserManagementService {

	List<UserEntity> getAllUsers();

	UserEntity addUser(UserEntity user);

	void deleteUser(Long userId);
	
	List<UserEntity> findbyRegId(Long regId);


}
