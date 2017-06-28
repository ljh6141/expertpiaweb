package com.expertpia.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expertpia.web.domains.User;
import com.expertpia.web.services.UserService;

@RequestMapping({"/user"})
@Controller
public class UserController
{
  private Logger logger = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private UserService userService;
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public String login()
  {
    return "user/login";
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String doLogin(@RequestParam("user_email") String email, @RequestParam("user_pw") String pw)
  {
    User loginUser = this.userService.login(email, pw);
    if (loginUser != null) {
      return "redirect:/post/list";
    }
    return "redirect:/main";
  }
}
