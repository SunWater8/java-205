import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AdminDao {

	private AdminDao() {
	}

	static private AdminDao dao = new AdminDao();

	public static AdminDao getInstance() {
		return dao;
	}

	ArrayList<Admin> getList(Connection con) {

		ArrayList<Admin> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// sql��
			String sql = "select * from admin ";
			pstmt = con.prepareStatement(sql);
			// ��� �޾ƿ���
			rs = pstmt.executeQuery(sql);

			list = new ArrayList<>();

			// ����Ʈ ����
			while (rs.next()) {
				Admin mem = new Admin( rs.getString(1), rs.getString(2));
				list.add(mem);
			}
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
		return list;
	}

}
