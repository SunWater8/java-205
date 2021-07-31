package dept.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {

	Connection conn;
	Dept dept;
	DeptDao dao;
	int resultCnt;
	
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
		conn=ConnectionProvider.getConnection();
		dept = new Dept();
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
		assertNull("List 안의 값이 null이 예상 되는 경우", null);
	}

	@Test
	public void testInsertDept() { 
		resultCnt = dao.insertDept(conn, new Dept(50, "Marketing", "London"));
		assertSame("sql의 dept 테이블에 insert가 되었는지 테스트", resultCnt,1);
	}

	@Test
	public void testDeleteDept()  {
		resultCnt = dao.deleteDept(conn, 50);
		assertSame ("sql의 dept 테이블에 delete가 되었는지 테스트", resultCnt , 1);
	}

	@Test
	public void testSelectByDeptno()  {
		dept = dao.selectByDeptno(conn, 50);
		assertNull ("sql의 dept 테이블에서 seleect 되는지 테스트", null);
	}

	@Test
	public void testUpdateDept() {
		resultCnt = dao.updateDept(conn, new Dept(30,  "design", "wells"));
		assertSame ("sql의 dept 테이블에 update가 되었는지 테스트", resultCnt , 1);

	}

}
