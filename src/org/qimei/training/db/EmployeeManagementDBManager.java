package org.qimei.training.db;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.PerformanceReview;
import org.qimei.training.pojo.WorkStation;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.SqliteDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class EmployeeManagementDBManager {

	private static EmployeeManagementDBManager dbManager;
	private static Dao<Employee, Object> empDao;
	private static Dao<IdCard, Object> idCardDao;
	private static Dao<WorkStation, Object> workStationDao;
	private static Dao<PerformanceReview, Object> performanceReviewDao;
	private static ConnectionSource connectionSource;

	private EmployeeManagementDBManager() {
		super();
	}

	public static EmployeeManagementDBManager getInstance() throws SQLException {
		if (null == dbManager) {
			dbManager = new EmployeeManagementDBManager();
		}

		return dbManager;
	}

	public void initDbConnection(String jndiString, boolean isJndi) throws SQLException, NamingException {

		if (isJndi) {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(jndiString);
			connectionSource = new DataSourceConnectionSource(dataSource, new SqliteDatabaseType());
		} else {
			connectionSource = new JdbcConnectionSource(jndiString);
		}
		
		initDaoAndTables();
	}

	private void initDaoAndTables() throws SQLException {
		dbManager.createDaoObjects();
		dbManager.createTablesIfNotExist();
	}

	private void createDaoObjects() throws SQLException {
		empDao = DaoManager.createDao(connectionSource, Employee.class);
		idCardDao = DaoManager.createDao(connectionSource, IdCard.class);
		workStationDao = DaoManager.createDao(connectionSource, WorkStation.class);
		performanceReviewDao = DaoManager.createDao(connectionSource, PerformanceReview.class);
	}

	private void createTablesIfNotExist() throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Employee.class);
		TableUtils.createTableIfNotExists(connectionSource, IdCard.class);
		TableUtils.createTableIfNotExists(connectionSource, WorkStation.class);
		TableUtils.createTableIfNotExists(connectionSource, PerformanceReview.class);
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
	
	public Dao<PerformanceReview, Object> getPerformanceReviewDao() {
		return performanceReviewDao;
	}

}
