package com.filter.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.filter.beans.User;
import com.filter.service.UserService;


/**
* The Class UserRestController.
*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user")
public class UserRestController {
  private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

  
  @Autowired
  private UserService<User> userService;
  
  @GetMapping(produces = "application/json")
  public List<User> listAllUser() {
    List<User> elements = userService.getAll();
    logger.info("------------------ Fetching element list from database ------------------");
    logger.info("Record list size:  " + elements.size());

    return elements;
  }

  @PostMapping
  public User createUser(@RequestBody User element) {
    logger.info("------------------ "
        + "Create and store an element into the database ------------------");
    return userService.create(element);
  }

  @GetMapping(value = "/search", produces = "application/json")
  public List<User> searchUser() {
	  return null;
  }
}
