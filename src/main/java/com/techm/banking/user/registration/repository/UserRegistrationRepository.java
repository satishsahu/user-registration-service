package com.techm.banking.user.registration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techm.banking.user.registration.model.User;

@Repository
public interface UserRegistrationRepository extends CrudRepository<User, Long> {

	@Query(value = "select u from User u where u.userName=:userName or u.email=:email and u.password=:password")
	public User findRegistredUserByUserNameOrEmail(@Param("userName") String userName, @Param("email") String email, @Param("password") String password);
}
