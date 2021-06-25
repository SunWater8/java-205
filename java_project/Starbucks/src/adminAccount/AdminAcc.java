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
	
	// 2. �� ���� ��� (���̵� ���� �޾Ƽ� memberDB���� �����´�)
	void adminInfo(String currentId) {

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw2);

			List<Member> list = dao.getList(con, currentId);

			System.out.println("���������������������� ������ ���� ����Ʈ �����������������������");
			System.out.println("���̵� \t ��й�ȣ \t �̸� \t ��ȭ��ȣ \t\t �ּ�");
			System.out.println("�������������������������������������������");
			for (Member mem : list) {
				System.out.printf("%s \t %s \t %s \t %s \t %s \n", mem.getId(), mem.getPw(), mem.getName(),
						mem.getPhone(), mem.getAddress());
			}
			System.out.println("���������������������������������������������������������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
