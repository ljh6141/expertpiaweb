package com.expertpia.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.test.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUserName(String userName);
}
