package com.expertpia.web.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.web.domains.Interest;
import com.expertpia.web.repositories.InterestRepository;

@Transactional
@Service
public class InterestService
{
  @Autowired
  private InterestRepository interestRepository;
  
  public List<Interest> getlist()
  {
    return this.interestRepository.findAll();
  }
  
  public Interest getInterest(Long id)
  {
    Interest getId = (Interest)this.interestRepository.findOne(id);
    return getId;
  }
  
  public Interest create(Interest interest)
  {
    this.interestRepository.save(interest);
    return interest;
  }
  
  public Interest update(Long id, Interest interest)
  {
    interest.setInterId(id);
    this.interestRepository.save(interest);
    return interest;
  }
  
  public Interest delete(Long id)
  {
    Interest interest = (Interest)this.interestRepository.findOne(id);
    this.interestRepository.delete(interest);
    return interest;
  }
}
