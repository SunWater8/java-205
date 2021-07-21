package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {
	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public List<Member> getMemberList(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from members";
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}

		return list;
	}

	public int insertMem(Connection conn, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into members values(default, ?,?,?,default)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());

			resultCnt = pstmt.executeUpdate();

			return resultCnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
