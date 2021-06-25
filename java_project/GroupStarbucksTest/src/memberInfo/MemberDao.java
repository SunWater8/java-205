package memberInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
//	public static id = 
	private MemberDao(){}
	static private MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}
	
	ArrayList<Member> getMemberList(Connection conn) {

		ArrayList<Member> list = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from member order by memcode";
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();

			while (rs.next()) {

				Member m = new Member(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7));

				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}
	
	//회원이 자신의 정보 조회 (내 정보 보기)
	void selectMember(Connection conn, Member member) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger"; 
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("회원 정보 조회");
			String sqlSelect = "select name, id, pw, address, phone, point from member where id = ? ";
			pstmt = conn.prepareStatement(sqlSelect);
			
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name"); 
				System.out.print(member.getName()+"\t");
				String id = rs.getString("id");
				System.out.print(member.getId()+"\t");
				String pw2 = rs.getString("pw");
				System.out.print(member.getPw()+"\t");
				String address = rs.getString("address");
				System.out.print(member.getAddress()+"\t");
				String phone = rs.getString("phone");
				System.out.print(member.getPhone()+"\t");
				int point = rs.getInt("point");
				System.out.print(member.getPoint()+"\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//회원 가입 메소드
	int insertMember(Connection conn, Member member) {

		int result = 0;
		// 전달받은 Member 객체의 데이터로 Member 테이블에 저장 후 그 결과 값을 반환한다.
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into Member values (Member_memcode_seq.nextval, ?, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	//회원이 자신의 정보를 수정할 때 사용되는 메소드
	int editMember(Connection conn, Member member) {

		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "update member set pw=?, address=?, phone=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getAddress());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	//회원 번호를 입력하면 삭제하는 메소드
	int deleteMember(Connection conn, String id) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}

}
