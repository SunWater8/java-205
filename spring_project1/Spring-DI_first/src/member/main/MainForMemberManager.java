package member.main;

import java.util.Scanner;

import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class MainForMemberManager {
	//조립기 등장으로 필요 없어진 문장
	//static MemberDao dao = new MemberDao();
	
	static Assembler assembler = new Assembler(); 
	
	public static void main(String[] args) {
		
		// 2. scanner 를 통해 배열로 입력받고 입력받은 데이터로 가입/수정 하기
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			printMenu();
			
			String command = sc.nextLine();
			//프로그램의 종료 분기
			if(command.equalsIgnoreCase("exit")) { //equalsIgnoreCase : 대소문자 무시하고 비교하기
				//탈출한다는 exit을 사용자가 입력한다면 프로그램 종료하기
				System.out.println("프로그램 종료");
				return; //main 메소드 프로그램 종료
			}
			//new로 시작할 떄 
			if(command.startsWith("new")) {
				//new라고 시작하며 입력을 이어 나간다면, 공백을 기준으로 배열을 만들기
				String[] values = command.split(" ");
				// values[0] 에는 king@gmail.com가 들어가게 됨.
				
				proccessNewMember(values);
				continue; //다시 위로 올라가서 처리하기
			}
			if(command.startsWith("change")) {
				String[] values = command.split(" ");
				processChangePw(values);
			}
			
		}
	}
	
	//4. 비밀번호 수정하기
	private static void processChangePw(String[] values) {
		//조립기 등장으로 필요 없어진 문장
		//ChangePasswordService service = new ChangePasswordService(dao);
		ChangePasswordService service = assembler.getPasswordService();
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			//changePassword 메소드의 "존재하지 않는 회원!" 
			//혹은 Member의 changePassword 메소드의 "비밀번호 불일치!" 예외 메시지가 뜬다.
		}
		
		
	}
	//3. 회원가입하기
	private static void proccessNewMember(String[] values) {
		
		//배열타입의 values 가 들어오면 MemberRegService 를 이용해서 정보를 저장하기
		
		//MemberRegService service = new MemberRegService(dao);
		//이렇게 하면 의존하는 것이기 때문에 의존성이 없도록 바꿔 주어야 함. 
		
		MemberRegService service = assembler.getRegService();
		
		//사용자로부터 입력받은 데이터를 저장하기
		RegRequest request = new RegRequest();
		request.setEmail(values[1]); //1번지에 있는 email을 매개변수로 넣기
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);
		
		//비밀번호가 일치하는지
		if(!request.isPasswordEqualToConfirmPassword()) {
			//비밀번호가 다르면
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return; //종료. 다시 입력하게 하기.
		}
		try {
			service.regMember(request);
			System.out.println("등록 되었습니다.");
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			//이메일이 중복되었다는 메시지 출력하기
			//- changePassword 메소드 혹은 regMember 메소드의 예외 메시지가 표시됨.
			// "존재하지 않는 회원!" or "중복 이메일!"
		}
	}
	// 1. 메뉴 출력하기
	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("--------------------------------");
		//띄어쓰기를 이용해서 데이터 받기
		System.out.println("new 이메일 이름 비밀번호 비밀번호(확인)");
		System.out.println("new King@gmail.com KING 123 123");
		System.out.println("회원 수정----------------------------");
		System.out.println("change 이메일 현재비번 새로운비번");
		System.out.println("change king@gmail.com 123 0000");
		System.out.println("----------------------------------");
	}
}
