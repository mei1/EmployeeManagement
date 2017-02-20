package org.qimei.training.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PerformanceReview")
public class PerformanceReview {

	@DatabaseField(foreign = true, foreignColumnName = "empId", canBeNull = false, useGetSet = true)
	private Employee employee;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int punctuality;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int workQuality;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int workSkills;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private double overallScore;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String comment;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getPunctuality() {
		return punctuality;
	}

	public void setPunctuality(int punctuality) {
		this.punctuality = punctuality;
	}

	public int getWorkQuality() {
		return workQuality;
	}

	public void setWorkQuality(int workQuality) {
		this.workQuality = workQuality;
	}

	public int getWorkSkills() {
		return workSkills;
	}

	public void setWorkSkills(int workSkills) {
		this.workSkills = workSkills;
	}

	public double getOverallScore() {

		int sum = getPunctuality() + getWorkQuality() + getWorkSkills();
		double average;

		average = Double.valueOf(sum) / 3;

		return average;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
