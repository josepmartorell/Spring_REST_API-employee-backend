package com.crud.h2.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author jtech
 *
 */
@Entity
@Table(name="employee")
public class Employee {
	//Entity employe atributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incremental value
	private Long id;
	@Column(name = "dni")
	private int dni;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "job")	
	private String job;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;	
	
	@ManyToOne
    @JoinColumn(name="dep_code")
    private Department department;
    
	/**
	 * constructors
	 */
	public Employee() {
		//super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param dni
	 * @param name
	 * @param surname
	 * @param job
	 * @param fecha
	 * @param department
	 */
	public Employee(Long id, int dni, String name, String surname, String job, Date fecha, Department department) {
		//super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.job = job;
		this.fecha = fecha;
		this.department = department;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
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
		this.fecha = fecha;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", job=" + job
				+ ", fecha=" + fecha + ", department=" + department + "]";
	}






	

}