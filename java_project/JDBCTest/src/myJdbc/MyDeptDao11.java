package myJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyDeptDao11 {

	ArrayList<Dept> getDeptList(Connection conn){
		
		ArrayList<Dept> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from dept order by deptno";
			rs=stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1),
								  rs.getString(2),
								  rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

}
