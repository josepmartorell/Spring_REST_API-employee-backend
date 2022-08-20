/**
 * 
 */
package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.h2.dto.Employee;
import com.crud.h2.service.EmployeeServiceImpl;

/**
 * @author jtech
 *
 */
@RestController
@RequestMapping("/api")
class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/employees")
	public List<Employee> listEmployees(){
		//it simply returns an entire list of employees
		return employeeServiceImpl.listEmployees();
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee){
		return employeeServiceImpl.saveEmployee(employee);
	}
	
	//read a specific employee
	@GetMapping("/employees/{id}")
	public Employee employeeXID(@PathVariable(name="id")Long id) {
		//we assign to an employee instance what the employeeXID service method returns and we return it
		Employee employee_xid = new Employee();
		employee_xid = employeeServiceImpl.employeeXID(id);
		System.out.println("Employee XID" + employee_xid);	
		return employee_xid;
	}
	
	//update a specific employee
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(name="id")Long id,@RequestBody Employee employee) {
		//two instances for employee to selected and another to store nes vars
		Employee selected_employee = new Employee();
		Employee updated_employee = new Employee();
		/*use employeeXID service method with id parameter to store selected employee
		id parameter needs @PathVariable annotation to pass through*/
		selected_employee = employeeServiceImpl.employeeXID(id);
		//obtain from selected_employee all variables and set the new ones 
		selected_employee.setDni(employee.getDni());
		selected_employee.setName(employee.getName());
		selected_employee.setSurname(employee.getSurname());
		selected_employee.setJob(employee.getJob());
		selected_employee.setDepartment(employee.getDepartment());
		selected_employee.setFecha(employee.getFecha());
		/*we pass as a parameter the employee_selected instance with its updated attributes to the updateEmployee service method 
		and we assign it to the updated_employee instance that will be the return of this endpoint*/
		updated_employee = employeeServiceImpl.updateEmployee(selected_employee);
		System.out.println("The employee updated is: "+ updated_employee);		
		return updated_employee;		
	}
	
	@DeleteMapping("employees/{id}")
	public void deleteEmployee(@PathVariable(name="id")Long id) {
		//@PathVariable annotation to pass through the id parameter to the service method in order to locate the specific employee
		employeeServiceImpl.deleteEmployee(id);
	}
	

	
}
