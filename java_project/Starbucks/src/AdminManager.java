import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminManager {
	private AdminDao dao;
	public AdminManager(AdminDao dao) {
		this.dao = dao;
	}
	
	Scanner sc = new Scanner(System.in);
	public static String currentId;


	void chkLogin() {
		// ��ü ����
		Connection con = null;

		// ����
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		ArrayList<Admin> admin = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			admin = dao.getList(con);
			for (int i = 0; i < admin.size(); i++) {
				map.put(admin.get(i).getId(), admin.get(i).getPw());
			}
			while (true) {
				System.out.println("���̵�� ��й�ȣ�� �Է��մϴ�.");
				System.out.print("���̵� �Է��ϼ��� > ");
				currentId = sc.nextLine().trim();
				System.out.print("��й�ȣ�� �Է��ϼ��� > ");
				String password = sc.nextLine().trim();
				System.out.println();

				if (!map.containsKey(currentId)) {
					System.out.println("�Է��Ͻ� ���̵�� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
					continue;
				} else {
					if (!(map.get(currentId)).equals(password)) {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
					} else {
						System.out.println("�α����ϼ̽��ϴ�.");
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
