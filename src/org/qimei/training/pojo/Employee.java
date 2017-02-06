package org.qimei.training.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Employees")
public class Employee {

	@DatabaseField(generatedId = true, canBeNull = false, useGetSet = true)
	private long empId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String firstName;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String lastName;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date dob;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String address;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private long age;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date joinDate;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private long salary;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
