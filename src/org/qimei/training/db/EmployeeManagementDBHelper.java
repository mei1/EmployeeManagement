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

}
