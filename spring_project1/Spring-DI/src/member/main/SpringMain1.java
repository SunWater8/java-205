package member.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain1 {
	
	static ApplicationContext ctx;
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			printMenu();
			
			String command = sc.nextLine();
			//프로그램의 종료 분기
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return; //main 메소드 프로그램 종료
			}
			//new로 시작할 떄 
			if(command.startsWith("new")) {
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
	
	private static void processChangePw(String[] values) {
		//조립기 등장으로 필요 없어진 문장
		//ChangePasswordService service = new ChangePasswordService(new MemberDao());
		//ChangePasswordService service = assembler.getPasswordService();
		ChangePasswordService service = ctx.getBean("ChangePasswordService", ChangePasswordService.class);
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void proccessNewMember(String[] values) {
		
		//배열타입의 values 가 들어오면 MemberRegService 를 이용해서 정보를 저장하기
		
		//MemberRegService service = new MemberRegService(new MemberDao());
		//이렇게 하면 의존하는 것이기 때문에 의존성이 없도록 바꿔 주어야 함. 
		
//		MemberRegService service = assembler.getRegService();
		MemberRegService service = ctx.getBean("regService", MemberRegService.class);
		
		RegRequest request = new RegRequest();
		request.setEmail(values[1]); //1번지에 있는 email을 매개변수로 넣기
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);
		
		//비밀번호가 일치하는지
		if(!request.isPasswordEqualsToConfirmPassword()) {
			//비밀번호가 다르면
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return; //종료. 다시 입력하게 하기.
		}
		try {
			service.regMember(request);
			System.out.println("등록 되었습니다.");
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());//이메일이 중복되었다는 메시지 출력하기
		}
	}

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
