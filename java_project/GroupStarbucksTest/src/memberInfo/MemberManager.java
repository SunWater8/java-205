package memberInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberManager {

	private MemberDao dao;
	private Scanner sc;

	public MemberManager(MemberDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	//관리자가 회원들 정보 조회
	void memberList() {
		//트랜젝션 시작
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Member> list = dao.getMemberList(conn);

			System.out.println("회원 정보 리스트");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("회원번호 \t 회원이름 \t 아이디 \t\t 비밀번호 \t\t 주소 \t 전화번호 \t\t 포인트현황 ");
			System.out.println("------------------------------------------------------------------------------");

			for (Member member : list) {
				System.out.printf("%d \t %s \t %s  \t %s \t %s \t %s \t %d\n", 
						member.getMemcode(), member.getName(), member.getId(),member.getPw() ,member.getAddress(), member.getPhone(),member.getPoint());
			}

			System.out.println("------------------------------------------------------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//회원이 본인의 정보 조회
	void selectData() {
		
		ResultSet rs = null;
		Connection conn = null;
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("소중한 정보를 조회하기 위해 아이디를 입력해 주세요.");
			String id = sc.nextLine();
			Member member = new Member(id);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//회원 가입 메소드
	// 사용에게 Scanner 클래스로 입력 받아 -> dao insertMember 메소드로 저장
	void inputData() {

		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			System.out.println("회원 정보를 입력합니다.");
			System.out.println("'회원이름 아이디 비밀번호 주소 전화번호' 형식으로 입력해주세요.");
			System.out.println("예시) 홍길동 hong abc123456 서울 010-1236-9874 ");
			String inputData = sc.nextLine();
			String[] mdata = inputData.split(" ");

			Member member = new Member(0, mdata[0], mdata[1], mdata[2], mdata[3], mdata[4], 0);

			int result = dao.insertMember(conn, member);

			if (result > 0) {
				System.out.println("입력되었습다.");
			} else {
				System.out.println("입력 실패!!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 데이터 수정  DB update
	// 사용자로부터 데이터를 받아 수정 -> dao editMember()메소드 이용
	void editMember() {
		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			System.out.println("회원 정보를 수정합니다.");
			System.out.println("아이디 비밀번호 주소 전화번호 형식으로 입력해 주세요.");
			System.out.println("입력한 아이디의 비밀번호, 주소, 전화번호가 수정됩니다.");
			String editData = sc.nextLine();
			String[] eData = editData.split(" ");

			Member member = new Member(eData[0], eData[1], eData[2], eData[3]);

			int result = dao.editMember(conn, member);

			if (result > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 데이터 삭제
	// 사용자로 부터 부서번호를 입력받아 부서정보를 삭제
	void delMember() {
		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			memberList();
			System.out.println("아이디를 입력해 주세요");
			String id= sc.nextLine();
			
			int result = dao.deleteMember(conn, id);
			
			if(result>0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("해당 아이디의 회원 정보가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}