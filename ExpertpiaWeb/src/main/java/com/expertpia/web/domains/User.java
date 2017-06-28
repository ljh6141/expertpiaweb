package com.expertpia.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_users")
public class User
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="user_id")
  private Long userId;
  @Column(name="user_email")
  private String userEmail;
  @Column(name="user_password")
  private String userPass;
  @Column(name="user_name")
  private String userName;
  @Column(name="user_profile")
  private String userProfile;
  
  public String getUserEmail()
  {
    return this.userEmail;
  }
  
  public void setUserEmail(String userEmail)
  {
    this.userEmail = userEmail;
  }
  
  public String getUserPass()
  {
    return this.userPass;
  }
  
  public void setUserPass(String userPass)
  {
    this.userPass = userPass;
  }
  
  public Long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Long userId)
  {
    this.userId = userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserProfile()
  {
    return this.userProfile;
  }
  
  public void setUserProfile(String userProfile)
  {
    this.userProfile = userProfile;
  }
}
