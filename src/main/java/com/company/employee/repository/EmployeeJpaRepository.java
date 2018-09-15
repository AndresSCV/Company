package com.company.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.employee.entity.Employee;



@Repository("employeeJpaRepository")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{

	@Query("Select a from Employee a where a.lastName=:lastName")
	public List<Employee> getByLastName(@Param("lastName") String lastName);
	
}
