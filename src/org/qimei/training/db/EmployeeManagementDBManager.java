package org.qimei.training.db;

import java.sql.SQLException;

import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class EmployeeManagementDBManager {

	private static EmployeeManagementDBManager dbManager;
	private static Dao<Employee, Object> empDao;
	private static Dao<IdCard, Object> idCardDao;
	private static Dao<WorkStation, Object> workStationDao;
	private static JdbcConnectionSource connectionSource;

	private EmployeeManagementDBManager() {
		super();
	}

	public static EmployeeManagementDBManager getInstance() throws SQLException {
		if (null == dbManager) {
			dbManager = new EmployeeManagementDBManager();
			dbManager.connectToDB();
			dbManager.createDaoObjects();
			dbManager.createTablesIfNotExist();
		}

		return dbManager;
	}

	private void connectToDB() throws SQLException {
		connectionSource = new JdbcConnectionSource("jdbc:sqlite:EmployeeManagement.db");
	}

	private void createDaoObjects() throws SQLException {
		empDao = DaoManager.createDao(connectionSource, Employee.class);
		idCardDao = DaoManager.createDao(connectionSource, IdCard.class);
		workStationDao = DaoManager.createDao(connectionSource, WorkStation.class);
	}

	private void createTablesIfNotExist() throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Employee.class);
		TableUtils.createTableIfNotExists(connectionSource, IdCard.class);
		TableUtils.createTableIfNotExists(connectionSource, WorkStation.class);
	}

	public Dao<Employee, Object> getEmpDao() {
		return empDao;
	}

	public Dao<IdCard, Object> getIdCardDao() {
		return idCardDao;
	}

	public Dao<WorkStation, Object> getWorkStationDao() {
		return workStationDao;
	}

}
