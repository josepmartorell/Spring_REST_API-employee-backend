/**
 * 
 */
package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IEmployeeDAO;
import com.crud.h2.dto.Employee;

/**
 * @author jtech
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	//We use the methods of the IClienteDAO interface, it is as if we were instantiating.
	@Autowired
	IEmployeeDAO iEmployeeDAO;

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return iEmployeeDAO.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return iEmployeeDAO.save(employee);
	}

	@Override
	public Employee employeeXID(Long id) {
		// TODO Auto-generated method stub
		return iEmployeeDAO.findById(id).get();
	}

	@Override
	public List<Employee> listEmployeeName(String name) {
		// TODO Auto-generated method stub
		return iEmployeeDAO.findByName(name);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return iEmployeeDAO.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		iEmployeeDAO.deleteById(id);
	}

}
