package com.usermanagment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagment.api.entity.UserEntity;
import java.util.List;


public interface UserManagementRepo extends JpaRepository<UserEntity, Long> {
	
	List<UserEntity> findByRegId(Long regId);
}
