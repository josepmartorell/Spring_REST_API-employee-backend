/**
 * 
 */
package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IDepartmentDAO;
import com.crud.h2.dto.Department;

/**
 * @author jtech
 *
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	
	//We use the methods of the IClienteDAO interface, it is as if we were instantiating.
	@Autowired
	IDepartmentDAO iDepartmentDAO;

	@Override
	public List<Department> listDepartments() {
		// TODO Auto-generated method stub
		return iDepartmentDAO.findAll();
	}

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return iDepartmentDAO.save(department);
	}

	@Override
	public Department departmentXID(Long code) {
		// TODO Auto-generated method stub
		return iDepartmentDAO.findById(code).get();
	}

	@Override
	public List<Department> listDepartmentName(String name) {
		// TODO Auto-generated method stub
		return iDepartmentDAO.findByName(name);
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return iDepartmentDAO.save(department);
	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		iDepartmentDAO.deleteById(id);
		
	}


}
