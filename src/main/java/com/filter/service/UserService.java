package com.filter.service;

import java.util.List;
import com.filter.beans.User;

/**
* The Interface UserService.
*/
public interface UserService<T> {

  public List<User> getAll();
    
  public List<User> getByFirstname(String firstname);

  public List<User> getByLastname(String lastname);
  
  public List<User> getByFirstnameLastname(String firstname, String lastname);
  
  public List<User> getByAge(int age);
  
  public List<User> getByWeight(double weight);
  
  public List<User> getByAgeAndWeight(int age, double weight);

  public List<User> getBySsn(String ssn);
  
  public T create(User element);
  
  public int countRows();

}
