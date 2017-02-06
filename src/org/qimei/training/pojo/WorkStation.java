package org.qimei.training.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "WorkStations")
public class WorkStation {

	@DatabaseField(foreign = true, foreignColumnName = "empId", canBeNull = false, useGetSet = true)
	private Employee employee;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String laptop;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int laptopId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String mouse;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int mouseId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int floorNumber;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int seatNumber;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int deskPhoneNumber;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getLaptop() {
		return laptop;
	}

	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public int getMouseId() {
		return mouseId;
	}

	public void setMouseId(int mouseId) {
		this.mouseId = mouseId;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getDeskPhoneNumber() {
		return deskPhoneNumber;
	}

	public void setDeskPhoneNumber(int deskPhoneNumber) {
		this.deskPhoneNumber = deskPhoneNumber;
	}

}
