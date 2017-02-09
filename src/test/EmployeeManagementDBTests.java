package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.db.EmployeeManagementDBManager;
import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeManagementDBTests {

	//logger is to print messages to console or file, similar Sysout
	private static final Logger logger = Logger.getLogger(EmployeeManagementDBTests.class);
	
	EmployeeManagementDBManager dbManager = null;
	EmployeeManagementDBHelper dbHelper = null;
	
	static ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setUp() throws Exception {
		dbManager = EmployeeManagementDBManager.getInstance();
		dbHelper = EmployeeManagementDBHelper.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertEmployee() throws SQLException {
		
		Employee emp = new Employee();
		emp.setFirstName("Qi Mei");
		emp.setLastName("Tan");
		emp.setAddress("Singapore");
		emp.setAge(28);
		emp.setDob(new Date("1/1/1989"));
		emp.setJoinDate(new Date("1/1/2017"));
		emp.setSalary(10000);
		
		int rowCount = dbHelper.insertIntoEmps(emp);
		
		assert(rowCount > 0);
	}
	
	@Test
	public void testInsertIdCard() throws SQLException {
		
		IdCard empIdCard = new IdCard();
		Employee emp = new Employee();
		emp.setEmpId(1);
		empIdCard.setCompanyName("Google");
		empIdCard.setEmployee(emp);
		empIdCard.setEmployeeName("Tan Qi Mei");
		empIdCard.setEmployeePhoto("Pretty photo");
		empIdCard.setIssueDate(new Date("1/1/2017"));
		empIdCard.setNewOrReplace("New");
		
		int rowCount = dbHelper.inserIntoIdCard(empIdCard);
		
		assert (rowCount > 0);
		
	}
	
	@Test
	public void testInsertWorkStation() throws SQLException {
		
		Employee emp = new Employee();
		emp.setEmpId(1);
		WorkStation empWorkStation = new WorkStation();
		empWorkStation.setEmployee(emp);
		empWorkStation.setDeskPhoneNumber(1231231);
		empWorkStation.setFloorNumber(23);
		empWorkStation.setLaptop("Dell");
		empWorkStation.setLaptopId(12321);
		empWorkStation.setMouse("Logitech");
		empWorkStation.setMouseId(12312);
		empWorkStation.setSeatNumber(234);
		empWorkStation.setSeatNumber(3);
		
		int rowCount = dbHelper.insertIntoWorkStation(empWorkStation);
	//pass below condition or test will fails	
		assert (rowCount > 0);
	}
	
	@Test
	public void testGetEmpFromDB() throws SQLException, JsonProcessingException {
		List empDatas = dbHelper.getAllEmpsFromDB();
		//logger is to print strings and mapper is to convert java objects to JSon strings
		logger.info(mapper.writeValueAsString(empDatas));
		
		assert (empDatas.size() > 0);
	}
	
	@Test
	public void testGetIdCardFromDB() throws SQLException, JsonProcessingException {
		List empIdCardDatas = dbHelper.getAllIdCardFromDB();
		logger.info(mapper.writeValueAsString(empIdCardDatas));
		
		assert (empIdCardDatas.size() > 0);
	}

	@Test
	public void testGetWorkStationFromDB() throws SQLException, JsonProcessingException {
		List empWorkStationDatas = dbHelper.getAllWorkStationFromDB();
		logger.info(mapper.writeValueAsString(empWorkStationDatas));
		
		assert (empWorkStationDatas.size() > 0);
	}
	
	@Test
	public void testGetEmpFromDBById() throws SQLException, JsonProcessingException{
		Employee empData = dbHelper.getEmpById(0);
		logger.info(mapper.writeValueAsString(empData));
		
		assert (empData != null);
	}
	
	@Test
	public void testGetIdCardFromDBById() throws SQLException, JsonProcessingException{
		IdCard empIdCardData = dbHelper.getIdCardById(0);
		logger.info(mapper.writeValueAsString(empIdCardData));
		
		assert (empIdCardData != null);
	}
	
	@Test
	public void testGetWorkStationFromDBById() throws SQLException, JsonProcessingException{
		WorkStation empWorkStationData = dbHelper.getWorkStationById(0);
		logger.info(mapper.writeValueAsString(empWorkStationData));
		
		assert (empWorkStationData != null);
	}
	
}
