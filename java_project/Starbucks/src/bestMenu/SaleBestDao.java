package bestMenu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SaleBestDao {
	private SaleBestDao() {}
	static private SaleBestDao dao = new SaleBestDao();
	public static SaleBestDao getInstance() {
		return dao;
	}
	
//	db에서 꺼내오는 메소드
	ArrayList<Sale> getSaleBestList(Connection conn){
		ArrayList<Sale> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select  sname, count from (select distinct sname, count(sname) as count from sale group by sname order by count desc ) where rownum < 4";
			
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Sale( rs.getInt(2), rs.getString(1)));
			}
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
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
}