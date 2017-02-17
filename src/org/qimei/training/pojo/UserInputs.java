package org.qimei.training.pojo;

public class UserInputs {

	//to assemble all collected data from user under same pojo to be used when updating details of any of the table
	Employee emp;
	IdCard idCard;
	WorkStation workStation;
	String columnName;
	Object columnValue;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public WorkStation getWorkStation() {
		return workStation;
	}

	public void setWorkStation(WorkStation workStation) {
		this.workStation = workStation;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Object getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(Object columnValue) {
		this.columnValue = columnValue;
	}

}
