package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MyDeptMain11 {
	public static void main(String[] args) {
		// 1-2. 리스트를 가져 올 때 쓰이는 connection 클래스를 가져오기.
		Connection conn = null;
		// 1-3. 드라이버 로드와 DB 연결하는 내용 붙여넣기.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");

			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!!!");

			// 1-1. 리스트를 가져온다.
			MyDeptDao dao = new MyDeptDao();
			List<Dept> list = dao.getDeptList(conn);
			
			//1-5. 출력해보기 (시험용)
//			for(Dept dept : list) {
//				System.out.println(dept); //toString 출력됨.
//			}
			
			//2-1 다음을 입력하기 이전에 sql 가서 seq가 deptno가 50이 나오는 차례인지 확인하기 (dept테이블에 deptno가 primary key로 제약걸렸기 대문에)
			
			//2-2 입력받을 Scanner 사용
			Scanner sc = new Scanner(System.in);
			System.out.println("부서입력을 시작합니다.");
			System.out.println("부서번호, 부서이름, 부서위치 순으로 입력해주세요.");
			System.out.println("예) 50 dev seoul");
			String deptData = sc.nextLine();
			//2-3 입력받은 것을 배열로 바꿔주기
			String[] deptDatas = deptData.split(" ");
			//2-4 데이터 받은 것을 배열로 바꿔줬으면 Dept 객체를 생성하고 Dao 메소드를 호출하기
			//deptDatas[0]은 integer이기 때문에 int형으로 변환해주기
			Dept dept = new Dept(Integer.parseInt(deptDatas[0]),deptDatas[1],deptDatas[2] );
			int result = dao.insertDept(conn, dept);
			
			if(result>0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
		//1-4. 붙여넣기 한 내용의 예외처리 정리해주기
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
