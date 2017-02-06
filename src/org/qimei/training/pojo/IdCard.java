package org.qimei.training.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "IdCards")
public class IdCard {

	@DatabaseField(foreign=true, foreignColumnName = "empId", canBeNull = false, useGetSet = true)
	private Employee employee;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String employeePhoto;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String companyName;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String employeeName;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String newOrReplace;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date issueDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEmployeePhoto() {
		return employeePhoto;
	}

	public void setEmployeePhoto(String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getNewOrReplace() {
		return newOrReplace;
	}

	public void setNewOrReplace(String newOrReplace) {
		this.newOrReplace = newOrReplace;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

}
