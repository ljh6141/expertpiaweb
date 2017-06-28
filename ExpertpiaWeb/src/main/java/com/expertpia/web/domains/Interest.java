package com.expertpia.web.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="test_interest")
public class Interest
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="interest_id")
  private Long interId;
  @Column(name="interest_name")
  private String interName;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @OneToMany(mappedBy="interest")
  @JsonBackReference
  private List<Post> posts;
  
  public List<Post> getPosts()
  {
    return this.posts;
  }
  
  public void setPosts(List<Post> posts)
  {
    this.posts = posts;
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public Long getInterId()
  {
    return this.interId;
  }
  
  public void setInterId(Long interId)
  {
    this.interId = interId;
  }
  
  public String getInterName()
  {
    return this.interName;
  }
  
  public void setInterName(String interName)
  {
    this.interName = interName;
  }
}
