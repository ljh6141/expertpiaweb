package com.expertpia.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.web.domains.User;

public abstract interface UserRepository
  extends JpaRepository<User, Long>
{
  public abstract List<User> findByUserName(String paramString);
  
  public abstract User findByUserEmailAndUserPass(String paramString1, String paramString2);
}
