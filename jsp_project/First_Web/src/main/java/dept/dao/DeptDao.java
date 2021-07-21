package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {
	//싱글톤 패턴
	//1. 인스턴스 생성을 막는다.
	private DeptDao() {}
	//2. 클래스 내부에서 인스턴스를 생성.
	//외부에서의 접속을 막기 위해 private
	private static DeptDao dao = new DeptDao();
	//3. 외부에서 참조 값을 반환 받을 수 있는 메소드 필요.
	public static DeptDao getInstance() {
		return dao;
		//return dao==null? new DeptDao(): dao;   --이렇게 쓰기도 함. 근데 dao가 안만들어질 수 없기 때문에 그냥 dao 달랑 하나만 써도 무관함.
	}
	
	// 리스트에서 필요한 부분 - 객체 반환하는 dept 타입
	public List<Dept> getDeptList(Connection conn) { // 전체 데이터 가지고 오기 위해 connection 을 매개변수로 함
		Statement stmt = null;
		ResultSet rs = null;
		//응답 주는 것 필요
		List<Dept> list = null;

		//dept_list.jsp의 list 가져오기
		try {
			stmt = conn.createStatement();//try catch
			
			String sql = "select * from dept";
			
			//resultset에 sql 문 넣기
			rs = stmt.executeQuery(sql);
			
			//오류 나면 null 값으로 보낼 것이고 있다라면 list에 객체 넣을 것임.
			list = new ArrayList<Dept>();
			
			while(rs.next()) {
				list.add(makeDept(rs));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}
	
	//insert 하는 메소드
	public int insertDept(Connection conn, Dept dept) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);//try catch
			//객체 안에 있는 메소드를 가지고 세팅하기
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	public int deleteDept(Connection conn, int deptno) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	//Dept 객체 만들어 반환해주는 메소드
	public Dept selectByDeptno(Connection conn, int deptno) {
		Dept dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery(); //update가 아니라 query 인 것 주의
			
			if(rs.next()) {
				dept = makeDept(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return dept;
	}
	
	public int updateDept(Connection conn, Dept dept) {
		int resultCnt =0;
		
		PreparedStatement pstmt = null;
		
		String sql = "update dept set dname=?, loc=? where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	private Dept makeDept(ResultSet rs) throws SQLException {
		Dept dept = new Dept();
		dept.setDeptno(rs.getInt("deptno")); //exception 생김
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		
		return dept;
	}
	
}

