package org.qimei.training.db;

import java.sql.SQLException;
import java.util.List;

import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

import com.j256.ormlite.stmt.UpdateBuilder;

public class EmployeeManagementDBHelper {

	private static EmployeeManagementDBHelper empMgmtDBHelper = null;

	private EmployeeManagementDBHelper() {
		super();
	}

	public static EmployeeManagementDBHelper getInstance() {
		if (empMgmtDBHelper == null) {
			empMgmtDBHelper = new EmployeeManagementDBHelper();
		}
		return empMgmtDBHelper;
	}

	// collect new data for employee/idcard/workstation
	public int insertIntoEmps(Employee emp) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getEmpDao().create(emp);

		return rowCount;
	}

	public int inserIntoIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().create(empIdCard);

		return rowCount;
	}

	public int insertIntoWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().create(empWorkStation);

		return rowCount;
	}

	// update current data for employee/idcard/workstation
	// ng - since this needs all the emp fields to be set - including the
	// primary key or foreign key
	public int updateExistingEmp(Employee emp) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getEmpDao().update(emp);

		return rowCount;
	}

	//update emp/idcard/workstation data by ID
	public int updateEmpById(long empId, String columnName, Object columnValue) throws SQLException {
		
		UpdateBuilder<Employee, Object> updateBuilder = EmployeeManagementDBManager.getInstance().getEmpDao().updateBuilder();
		//update the given column name with the given column value
		updateBuilder.updateColumnValue(columnName, columnValue);
		//set condition to update by given rowId
		updateBuilder.where().eq("empId", empId);
		return updateBuilder.update();

	}
	
	public int updateEmpIdCardById(long employee_empId, String columnName, Object columnValue) throws SQLException{
		
		UpdateBuilder<IdCard, Object> updateBuilder = EmployeeManagementDBManager.getInstance().getIdCardDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("employee_empId", employee_empId);
		return updateBuilder.update();
	}
	
	public int updateWorkStationById(long employee_empID, String columnName, Object columnValue) throws SQLException{
		
		UpdateBuilder<WorkStation, Object> updateBuilder = EmployeeManagementDBManager.getInstance().getWorkStationDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("employee_empId", employee_empID);
		return updateBuilder.update();
	}

	public int updateExistingIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().update(empIdCard);

		return rowCount;
	}

	public int updateExistingWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().update(empWorkStation);

		return rowCount;
	}

	// delete current data for employee/idcard/workstation
	public int deleteExistingEmp(Employee emp) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getEmpDao().delete(emp);

		return rowCount;
	}

	public int deleteExistingIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().delete(empIdCard);

		return rowCount;
	}

	public int deleteExistingWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().delete(empWorkStation);

		return rowCount;
	}

	// get data from DB table
	public List<Employee> getAllEmpsFromDB() throws SQLException {
		return EmployeeManagementDBManager.getInstance().getEmpDao().queryForAll();
	}

	public List<IdCard> getAllIdCardFromDB() throws SQLException {
		return EmployeeManagementDBManager.getInstance().getIdCardDao().queryForAll();
	}

	public List<WorkStation> getAllWorkStationFromDB() throws SQLException {
		return EmployeeManagementDBManager.getInstance().getWorkStationDao().queryForAll();
	}

	// get data from DB table by matching given ID
	public List<Employee> getEmpById(int empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getEmpDao().queryForEq("empId", empId);
	}

	public List<IdCard> getIdCardById(int empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getIdCardDao().queryForEq("employee_empId", empId);
	}

	public List<WorkStation> getWorkStationById(int empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getWorkStationDao().queryForEq("employee_empId", empId);
	}

}
