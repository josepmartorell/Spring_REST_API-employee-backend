/**
 * 
 */
package com.crud.h2.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jtech
 *
 */
@Entity
@Table(name="departament")
public class Department {
	//Entity department atributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incremental value
	private Long code;
	@Column(name = "name")
	private String name;
	@Column(name = "budget")
	private  Long budget;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;	
	
    @OneToMany
    @JoinColumn(name="id")
    private List<Employee> employee;
	
	/**
	 * constructors
	 */
	public Department() {
		//super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param code
	 * @param name
	 * @param budget
	 */
	public Department(Long code, String name, Long budget) {
		//super();
		this.code = code;
		this.name = name;
		this.budget = budget;
		this.fecha = new Date();
	}
	//getters and setters
	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the budget
	 */
	public Long getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(Long budget) {
		this.budget = budget;
	}	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = new Date();
	}
	
	/**
	 * @return the employee
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Employee")
	public List<Employee> getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [code=" + code + ", name=" + name + ", budget=" + budget + "]";
	}
	
	

	
	
	
}