package myJdbc;
import java.sql.*;
import java.util.ArrayList;

public class MyDeptDao {
////	싱글톤 패턴 : 여러개의 인스턴스를 생성하지 못하도록 하는 디자인 패턴
////	싱클톤 순서
////	1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
////	private MyDeptDao(){}
//	
////	2. 클래스 내부에서 인스턴스를 만들고 
//	static private MyDeptDao dao = new MyDeptDao(); //static:프로그램 시작할 때 호출됨.
////	3. 메소드를 통해서 반환하도록 처리
//	public static MyDeptDao getInstance() {
//		return dao;
//	}
	
	//1-1. 전체 데이터 검색 기능을 하는 메소드 만들기
	//	반환 타입은 List<Dept> 이고
	//	매개변수 - Connection 객체 (statement 객체 만들기 위해 필요) = Connection 클래스가 getDeptList 메소드의 매개변수
	ArrayList<Dept> getDeptList(Connection conn){
		
		ArrayList<Dept> list = null;
		
		//1-2 데이터 베이스의 dept 테이블 이용해서 select 결과를 list에 저장하기
		//접속하기 위해서 Statement 클래스 사용함.
		Statement stmt = null;
		//1-6 sql query 받을 클래스 사용하기
		ResultSet rs = null;
		
		try {
			//1-3.Statement메소드 사용.
			stmt = conn.createStatement();
			//1.5 sql 만들기
			String sql = "select * from dept order by deptno";
			
			//1-7 결과 받아오기
			rs=stmt.executeQuery(sql);
			//1-8
			list = new ArrayList<>();
			
			//1-9 데이터를 dept 객체로 생성하고 list에 저장해 준다.  dept테이블의 한 행씩 저장됨.
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1),rs.getString(2), rs.getString(3))); //Dept 클래스의 생성자 활용!
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//1-4. close 해주기
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
		
	}
	
	//2-1. DEPT 테이블에 데이터 저장하는 메소드 만들기
	//반영 횟수 반환한다. (정수타입 반환)
	//사용자로부터 데이터 받기-> Dept 객체로 받기
	int insertDept(Connection conn,Dept dept) {
		//2-2반환할 정수를 default 하기
		int result = 0;
		//2-3 전달받은 Dept 객체의 데이터로 Dept 테이블에 저장 하고 결과 값을 반환
		PreparedStatement pstmt = null;
		
		try {
			//2-4.
			String sql = "insert into dept01 values (DEPT01_DEPTNO_SEQ.nextVal, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	//3. DEPT 테이블의 데이터를 수정하는 메소드
	//반영된 행의 개수 반환하기
	//사용자로부터 데이터를 받아서 처리 -> Dept 객체
//	int editDept(Connection conn, Dept dept) {
//
//		 int result = 0;
//		 PreparedStatement pstmt = null;
//		 String sql = "update dept01 set dname=?, loc=? where deptno=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dept.getDname());
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return result;
//	}
//	
//	//4. Dept 테이블의 데이터를 삭제
//	// 삭제된 행의 개수를 반환
//	//사용자로부터 deptno 를 입력 받아서 처리 - 매개변수가 필요
//	int deleteDept(Connection conn, int deptno) {
//		int result = 0;
//		
//		//데이터 베이스 처리 sql
//		PreparedStatement pstmt = null;
//		
//		try {
//			String sql ="delete from dept where deptno=?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1,deptno);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return result;
//	}
}


