package com.filter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.filter.beans.User;

/**
 * The Class UserRepository.
 */
public interface UserRepository<T> extends JpaRepository<User, T> {

	@Query(value = "SELECT u FROM User u WHERE u.firstname = ?1")
	List<User> getByFirstname(String firstname);

	@Query(value = "SELECT u FROM User u WHERE u.lastname = ?1")
	List<User> getByLastname(String lastname);
	
	@Query(value = "SELECT u FROM User u WHERE u.age = ?1")
	List<User> getByAge(int age);
	
	@Query(value = "SELECT u FROM User u WHERE u.ssn = ?1")
	List<User> getBySsn(String ssn);
	
	@Query(value = "SELECT COUNT(*) FROM User")
	int countRows();

}
