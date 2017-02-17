package test;

import java.sql.SQLException;
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

	//Junit to test application 
	//logger is to print messages to console or file, similar Sysout
	private static final Logger logger = Logger.getLogger(EmployeeManagementDBTests.class);

	EmployeeManagementDBManager dbManager = null;
	EmployeeManagementDBHelper dbHelper = null;

	static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		dbManager = EmployeeManagementDBManager.getInstance();
		dbManager.initDbConnection("jdbc:sqlite:EmployeeManagement.db", false);
		dbHelper = EmployeeManagementDBHelper.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertEmployee() throws SQLException {

		Employee emp = new Employee();
		emp.setFirstName("Shan");
		emp.setLastName("N");
		emp.setAddress("Oz");
		emp.setAge(34);
		emp.setDob(new Date("1/1/1983"));
		emp.setJoinDate(new Date("2/1/2017"));
		emp.setSalary(100);

		int rowCount = dbHelper.insertIntoEmps(emp);

		assert (rowCount > 0);
	}

	@Test
	public void testInsertIdCard() throws SQLException {

		IdCard empIdCard = new IdCard();
		Employee emp = new Employee();
		emp.setEmpId(2);
		empIdCard.setCompanyName("own fucking biz");
		empIdCard.setEmployee(emp);
		empIdCard.setEmployeeName("Sudarshan N");
		empIdCard.setEmployeePhoto("Ugly photo");
		empIdCard.setIssueDate(new Date("2/1/2017"));
		empIdCard.setNewOrReplace("Old");

		int rowCount = dbHelper.inserIntoIdCard(empIdCard);

		assert (rowCount > 0);

	}

	@Test
	public void testInsertWorkStation() throws SQLException {

		Employee emp = new Employee();
		emp.setEmpId(2);
		WorkStation empWorkStation = new WorkStation();
		empWorkStation.setEmployee(emp);
		empWorkStation.setDeskPhoneNumber(345345345);
		empWorkStation.setFloorNumber(34);
		empWorkStation.setLaptop("Dell");
		empWorkStation.setLaptopId(6753);
		empWorkStation.setMouse("No Mouse");
		empWorkStation.setMouseId(5675);
		empWorkStation.setSeatNumber(434);

		int rowCount = dbHelper.insertIntoWorkStation(empWorkStation);
		// pass below condition or test will fails
		assert (rowCount > 0);
	}

	@Test
	public void testGetAllEmpsFromDB() throws SQLException, JsonProcessingException {
		List empDatas = dbHelper.getAllEmpsFromDB();
		// logger is to print strings and mapper is to convert java objects to
		// JSon strings
		logger.info(mapper.writeValueAsString(empDatas));
		System.out.println(mapper.writeValueAsString(empDatas));

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
	public void testGetEmpFromDBById() throws SQLException, JsonProcessingException {
		List<Employee> empData = dbHelper.getEmpById(1);
		logger.info(mapper.writeValueAsString(empData));

		assert (empData != null);
	}

	@Test
	public void testGetIdCardFromDBById() throws SQLException, JsonProcessingException {
		List<IdCard> empIdCardData = dbHelper.getIdCardById(1);
		logger.info(mapper.writeValueAsString(empIdCardData));

		assert (empIdCardData != null);
	}

	@Test
	public void testGetWorkStationFromDBById() throws SQLException, JsonProcessingException {
		List<WorkStation> empWorkStationData = dbHelper.getWorkStationById(1);
		logger.info(mapper.writeValueAsString(empWorkStationData));

		assert (empWorkStationData != null);
	}

	@Test
	public void testUpdateEmpFromDB() throws SQLException {

		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setFirstName("Qi Mei");
		emp.setLastName("Tan");
		emp.setAddress("Melbourne, Australia");
		emp.setAge(28);
		emp.setDob(new Date("1/1/1989"));
		emp.setJoinDate(new Date("1/1/2017"));
		emp.setSalary(10000);

		int updateEmp = dbHelper.updateExistingEmp(emp);

		assert (updateEmp > 0);
	}

	@Test
	public void testUpdateEmpFromDBByColumn() throws SQLException {
		int updateEmp = dbHelper.updateEmpById(2, "address", "Australia");

		assert (updateEmp > 0);
	}

	@Test
	public void testUpdateIdCardFromDBByColumn() throws SQLException {
		int updateEmpIdCard = dbHelper.updateEmpIdCardById(2, "companyName", "big biz");
		int updateEmpIdCard2 = dbHelper.updateEmpIdCardById(2, "employeePhoto", "pic");

		assert (updateEmpIdCard > 0 && updateEmpIdCard2 > 0);
	}

	@Test
	public void testUpdateWorkStationFromDBByColumn() throws SQLException {
		int updateEmpWorkStation = dbHelper.updateWorkStationById(1, "laptop", "Mac");

		assert (updateEmpWorkStation > 0);
	}

}
