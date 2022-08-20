package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Department;
/**
 * @author jtech
 */
public interface IDepartmentService {
	
	//Crud methods	
	public List<Department> listDepartments(); //List ALL 
	
	public Department saveDepartment(Department department);	//Save department CREATE
	
	public Department departmentXID(Long code); //read department data READ
	
	public List<Department> listDepartmentName(String name);//List departments by name field
	
	public Department updateDepartment(Department department); //Updates department data UPDATE
	
	public void deleteDepartment(Long id);// Delete department DELETE

}
