package com.company.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.employee.entity.Employee;
import com.company.employee.entity.User;

@Repository("userJpaRepository")
public interface UserJpaRepository  extends JpaRepository<User, Integer>{

	@Query("Select a from User a where a.name=:name and a.password=:password")
	public List<User> validateUser(@Param("name") String name, @Param("password") String password);
	
}
