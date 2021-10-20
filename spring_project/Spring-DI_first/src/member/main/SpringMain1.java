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
	//순서6-1.
	//ApplicationContext 인터페이스는 객체를 생성하고 보관해주는 컨테이너 역할을 한다.
	//스프링에서는 이런식의 컨테이너는 사용되지 않는다. mvc패턴의 스프링에서는 서블릿 컨텍스트가 이 역할을 하고, 스프링이 알아서 컨테이너로 동작하게 한다.
	static ApplicationContext ctx;
	public static void main(String[] args) {
		
		//순서6-2
		//ApplicationContext인터페이스를 GenericXmlApplicationContext 클래스 통해서  클래스로 완성 시킴 
		//그리고 설정파일인 xml 파일을 받아서 최종적으로 컨테이너 완성시킴
		ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		
		//순서1. 
		Scanner sc = new Scanner(System.in);
		
		//순서3.
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
	//순서5
	private static void processChangePw(String[] values) {
		//조립기 등장으로 필요 없어진 문장
		//ChangePasswordService service = new ChangePasswordService(new MemberDao());
		//ChangePasswordService service = assembler.getPasswordService();
		ChangePasswordService service = ctx.getBean("changePwService", ChangePasswordService.class);
		//getBean 메소드 : 스프링 컨테이너가 만들어 놓은 객체를 반환해 준다.
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	//순서4.
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
			System.out.println(e.getMessage());//이메일이 중복되었다는 메시지 출력하기
		}
	}
	//순서2
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
