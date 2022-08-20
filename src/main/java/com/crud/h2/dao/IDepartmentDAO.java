package com.crud.h2.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Department;
/**
 * @author jtech
 *
 */
public interface IDepartmentDAO extends JpaRepository<Department, Long>{
	//List departments by name field
	public List<Department> findByName(String name);

}
