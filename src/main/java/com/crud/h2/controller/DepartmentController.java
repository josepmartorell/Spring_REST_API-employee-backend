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

import com.crud.h2.dto.Department;
import com.crud.h2.service.DepartmentServiceImpl;

/**
 * @author jtech
 *
 */
@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl departmentServiceImpl;
	
	@GetMapping("/departments")
	public List<Department> listDepartments(){
		//it simply returns an entire list of departments
		return departmentServiceImpl.listDepartments();
	}
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department){
		return departmentServiceImpl.saveDepartment(department);
	}
	
	//read a specific department
	@GetMapping("/departments/{id}")
	public Department departmentXID(@PathVariable(name="id")Long id) {
		//we assign to an department instance what the departmentXID service method returns 
		Department department_xid = new Department();
		department_xid = departmentServiceImpl.departmentXID(id);
		System.out.println("Department XID" + department_xid);	
		return department_xid;
	}
	
	//update a specific department
	@PutMapping("/departaments/{id}")
	public Department updateDepartment(@PathVariable(name="id")Long id,@RequestBody Department department) {
		//two instances for department to selected and another to store nes vars
		Department selected_department = new Department();
		Department updated_department = new Department();
		/*use departmentXID service method with id parameter to store selected department
		id parameter needs @PathVariable annotation to pass through*/
		selected_department = departmentServiceImpl.departmentXID(id);
		//obtain from selected_employee all variables and set the new ones 
		selected_department.setCode(department.getCode());
		selected_department.setName(department.getName());
		selected_department.setBudget(department.getBudget());
		selected_department.setFecha(department.getFecha());
		/*we pass as a parameter the employee_selected instance with its updated attributes to the updateEmployee service method 
		and we assign it to the updated_employee instance that will be the return of this endpoint*/
		updated_department = departmentServiceImpl.updateDepartment(selected_department);
		System.out.println("The employee updated is: "+ updated_department);		
		return updated_department;		
	}
	
	@DeleteMapping("departaments/{id}")
	public void deleteEmployee(@PathVariable(name="id")Long id) {
		//@PathVariable annotation to pass through the id parameter to the service method in order to locate the specific employee
		departmentServiceImpl.deleteDepartment(id);
	}

}
