package org.qimei.training.db;

import java.sql.SQLException;
import java.util.List;

import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.PerformanceReview;
import org.qimei.training.pojo.WorkStation;

import com.j256.ormlite.stmt.DeleteBuilder;
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
	
	public int insertIntoPerformanceReview(PerformanceReview empPerformanceReview) throws SQLException{
		int rowCount = EmployeeManagementDBManager.getInstance().getPerformanceReviewDao().create(empPerformanceReview);
		
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
	
	public int updateWorkStationById(long employee_empId, String columnName, Object columnValue) throws SQLException{
		
		UpdateBuilder<WorkStation, Object> updateBuilder = EmployeeManagementDBManager.getInstance().getWorkStationDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("employee_empId", employee_empId);
		return updateBuilder.update();
	}
	
	public int updatePerformanceReviewById(long employee_empId, String columnName, Object columnValue) throws SQLException{
		UpdateBuilder<PerformanceReview, Object> updateBuilder = EmployeeManagementDBManager.getInstance().getPerformanceReviewDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("employee_empId", employee_empId);
		return updateBuilder.update();
	}
	//update emp/idcard/workstation data by ID

	
	public int updateExistingIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().update(empIdCard);

		return rowCount;
	}

	public int updateExistingWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().update(empWorkStation);

		return rowCount;
	}

	// delete current data for employee/idcard/workstation
	//using deletebuilder from ORMLite to delete data for the whole column by id
	public int deleteExistingEmp(Employee empId) throws SQLException {
		DeleteBuilder<Employee, Object> deleteBuilder = EmployeeManagementDBManager.getInstance().getEmpDao().deleteBuilder();
		deleteBuilder.where().eq("empId", empId);

		return deleteBuilder.delete();
	}

	public int deleteExistingIdCard(long employee_empId) throws SQLException {
		DeleteBuilder<IdCard, Object> deleteBuilder = EmployeeManagementDBManager.getInstance().getIdCardDao().deleteBuilder();
		deleteBuilder.where().eq("employee_empId", employee_empId);
		
		return deleteBuilder.delete();
	}

	public int deleteExistingWorkStation(long employee_empId) throws SQLException {
		DeleteBuilder<WorkStation, Object> deleteBuilder = EmployeeManagementDBManager.getInstance().getWorkStationDao().deleteBuilder();
		deleteBuilder.where().eq("employee_empId", employee_empId);
		
		return deleteBuilder.delete();
	}
	
	public int deleteExistingPerformanceReview(long employee_empId) throws SQLException{
		DeleteBuilder<PerformanceReview, Object> deleteBuilder = EmployeeManagementDBManager.getInstance().getPerformanceReviewDao().deleteBuilder();
		deleteBuilder.where().eq("employee_empId", employee_empId);
		
		return deleteBuilder.delete();
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
	
	public List<PerformanceReview> getAllPerformanceReviewFromDB() throws SQLException{
		return EmployeeManagementDBManager.getInstance().getPerformanceReviewDao().queryForAll();
	}

	// get data from DB table by matching given ID
	public List<Employee> getEmpById(long empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getEmpDao().queryForEq("empId", empId);
	}

	public List<IdCard> getIdCardById(long empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getIdCardDao().queryForEq("employee_empId", empId);
	}

	public List<WorkStation> getWorkStationById(long empId) throws SQLException {
		return EmployeeManagementDBManager.getInstance().getWorkStationDao().queryForEq("employee_empId", empId);
	}
	
	public List<PerformanceReview> getPerformanceReviewById(long empId) throws SQLException{
		return EmployeeManagementDBManager.getInstance().getPerformanceReviewDao().queryForEq("employee_empId", empId);
	}

}
