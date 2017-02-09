package org.qimei.training.pojo;

public class EmployeeDataSummary {

	//added all pojo under one class to make it into a group for better UI
	private Employee emp;
	private IdCard empIdCard;
	private WorkStation empWorkStation;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public IdCard getEmpIdCard() {
		return empIdCard;
	}

	public void setEmpIdCard(IdCard empIdCard) {
		this.empIdCard = empIdCard;
	}

	public WorkStation getEmpWorkStation() {
		return empWorkStation;
	}

	public void setEmpWorkStation(WorkStation empWorkStation) {
		this.empWorkStation = empWorkStation;
	}

}
