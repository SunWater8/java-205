package adminAccount;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import test0624_02.MemberDao;


public class AdminAccDao {
	private MemberDao() {}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance()	{
		return dao;
	}
	
	// 2. 내 정보 출력 (아이디 값을 받아서 memberDB에서 가져온다)
	void adminInfo(String currentId) {

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw2);

			List<Member> list = dao.getList(con, currentId);

			System.out.println("■■■■■■■■■■■■■■■■■■■■■ 관리자 정보 리스트 ■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("아이디 \t 비밀번호 \t 이름 \t 전화번호 \t\t 주소");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			for (Member mem : list) {
				System.out.printf("%s \t %s \t %s \t %s \t %s \n", mem.getId(), mem.getPw(), mem.getName(),
						mem.getPhone(), mem.getAddress());
			}
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
