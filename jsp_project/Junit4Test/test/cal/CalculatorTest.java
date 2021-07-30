package cal;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorTest {
	
	//Calculator cal = new Calculator();
	Calculator cal;
	
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
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		
		assertEquals("add() 메소드 테스트", 12, cal.add(10, 2));
		//괄호 안의 의미 : 표시되는 메시지, 예상되는 값, 실제 실행되는 메소드
		
		//System.out.println(cal.add(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		assertEquals("substract() 메소드 테스트", 8, cal.substract(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		assertEquals("multiply() 메소드 테스트", 20, cal.multiply(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		assertEquals("divide() 메소드 테스트", 5, cal.divide(10, 2));
		//fail("Not yet implemented");
	}
	
	// 예외 타입을 비교해서 테스트
	// RuntimeException 예외가 발생할 것이라는 예상을 입력해주기
	@Test(expected = SQLException.class)
	public void test1() throws SQLException {
		System.out.println("@Test 실행 중 예외타입을 테스트");
		throw new SQLException();
	}
	
	//사용자 응답하는데 걸리는 시간에 대한 성능테스트
	// 1/10 초를 벗어나면 에러처리하기
	@Test(timeout = 100)
	public void test2() {
		System.out.println("@Test 테스트 중 허용시간 ms 안에 실행이 완료 되는지 테스트");
		cal.add(100,200);
		cal.substract(10, 2);
	}
	
	//assertEquals는 값을 비교해서 같으면 성공이라고 해주었다면, 결과가 null이다 아니다를 처리해주는 메소드
	@Test
	public void test3() {
/*		
  		fail("테스트 미실행으로 이 메소드는 실패");
		assertTrue("메소드의 반환값이 boolean인 경우 사용", true);  //failure trace에 아무런 메시지 표시 없이 성공함
		assertTrue("메소드의 반환값이 boolean인 경우 사용", false); //failure trace에 실패한 메시지 표시
		
		assertNull(null);
		assertNull("null");
		
		assertNull("메소드의 실행 값이 null이 예상되는 경우",  new Object());
		assertNotNull("메소드의 실행 값이 null이 예상되지 않은 경우",  null);
		
		assertSame("같은 값일 경우", 1, 1);
		assertNotSame("다른 값 예상", 1, 2);
		
		assertTrue("메소드의 반환값이 true로 예상될 때", true);
		assertTrue("메소드의 반환값이 true로 예상될 때", false);
*/		
	}

}
