package com.expertpia.web.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.web.domains.User;
import com.expertpia.web.repositories.UserRepository;

@Transactional
@Service
public class UserService
{
  @Autowired
  private UserRepository userRepository;
  
  public User login(String email, String pw)
  {
    User user = this.userRepository.findByUserEmailAndUserPass(email, pw);
    return user;
  }
  
  public List<User> getlist()
  {
    return this.userRepository.findAll();
  }
  
  public User getUser(Long id)
  {
    User getId = (User)this.userRepository.findOne(id);
    return getId;
  }
  
  public User create(User user)
  {
    validateDuplicateUser(user);
    this.userRepository.save(user);
    return user;
  }
  
  public User update(User user, Long id)
  {
    user.setUserId(id);
    this.userRepository.save(user);
    return user;
  }
  
  public void delete(Long id)
  {
    User user = (User)this.userRepository.findOne(id);
    this.userRepository.delete(user);
  }
  
  private void validateDuplicateUser(User user)
  {
    List<User> userName = this.userRepository.findByUserName(user.getUserName());
    if (!userName.isEmpty()) {
      throw new IllegalStateException("���� �������� ����������.");
    }
  }
}
