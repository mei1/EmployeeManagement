package org.qimei.training.db;

import java.sql.SQLException;

import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

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
	
	//collect new data for employee/idcard/workstation
	public int insertIntoEmps(Employee emp) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getEmpDao().create(emp);

		return rowCount;
	}

	public int inserIntoIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().create(empIdCard);

		return rowCount;
	}

	public int insetIntoWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().create(empWorkStation);

		return rowCount;
	}
	//update current data for employee/idcard/workstation
	public int updateExistingEmp(Employee emp) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getEmpDao().update(emp);
		
		return rowCount;
	}
	
	public int updateExistingIdCard(IdCard empIdCard) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getIdCardDao().update(empIdCard);
		
		return rowCount;
	}
	
	public int updateExistingWorkStation(WorkStation empWorkStation) throws SQLException {
		int rowCount = EmployeeManagementDBManager.getInstance().getWorkStationDao().update(empWorkStation);
		
		return rowCount;
	}
	
	//delete current data for employee/idcard/workstation
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

}
