package dept.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeptDaoTest {

	DeptDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		dao = DeptDao.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testGetInstance() {
		System.out.println("testGetInstance()");
		assertNotNull("메소드의 실행 값이 null이 예상되지 않은 경우", dao);
	}

	@Test
	public void testGetDeptList() { 
		System.out.println("testGetDeptList()");
		assertNull("메소드의 실행 값이 null이 예상 되는 경우", null);
	}

	@Test(expected = SQLException.class)
	public void testInsertDept() throws SQLException { 
		System.out.println("@test 실행 중 예외 타입 테스트()");
		throw new SQLException();
	}

	@Test(expected = SQLException.class)
	public void testDeleteDept() throws SQLException {
		System.out.println("@test 실행 중 예외 타입 테스트()");
		throw new SQLException();
	}

	@Test(expected = SQLException.class)
	public void testSelectByDeptno() throws SQLException {
		System.out.println("@test 실행 중 예외 타입 테스트()");
		throw new SQLException();
	}

	@Test(expected = SQLException.class)
	public void testUpdateDept() throws SQLException {
		System.out.println("@test 실행 중 예외 타입 테스트()");
		throw new SQLException();
	}

}
