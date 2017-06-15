package com.expertpia.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.test.domain.User;
import com.expertpia.test.repository.UserRepository;

@Transactional
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getlist(){
		return userRepository.findAll();
	}
	public User getUser(Long id){
		User getId=userRepository.findOne(id);
		return getId;
	}
	public User create(User user){
		validateDuplicateUser(user); //중복 회원 검증
		userRepository.save(user);
		return user;
	}
	public User update(User user, Long id){
		user.setUserId(id);
		userRepository.save(user);
		return user;
	}
	public void delete(Long id){
		User user=userRepository.findOne(id);
		userRepository.delete(user);
	}
	private void validateDuplicateUser(User user) {
        List<User> userName = userRepository.findByUserName(user.getUserName());
        if (!userName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
