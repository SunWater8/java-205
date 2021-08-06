package member.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain2 {
	
	static ApplicationContext ctx;
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		// MemberRegService 객체를 컨테이너로부터 받아서  scope을 설정하지 않았을 때의 기본값인 singleton 이 적용이 되는지 살펴볼 것이다.
		// (두번 인스턴스할 시 두 참조변수가 같은 값을 갖고 있는지를 비교할 것이다.)
		Dao dao1 = ctx.getBean("memberDao", Dao.class);
		Dao dao2 = ctx.getBean("memberDao", Dao.class);
		
		System.out.println("===================================");
		System.out.println("dao1 == dao2 : " + (dao1 == dao2)); //결과 값: true - 같은 참조값을 반환
		
		MemberRegService regService1 = ctx.getBean("regService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("regService", MemberRegService.class);
		// - regService는 appCtx4.xml의 bean 객체의 아이디이다.
		 
		
		System.out.println("regService1 == regService2 :"+(regService1 == regService2));
		
		ChangePasswordService passwordService1 = ctx.getBean("changePwService",ChangePasswordService.class);
		ChangePasswordService passwordService2 = ctx.getBean("changePwService",ChangePasswordService.class);

		System.out.println("passwordService1 == passwordService2 :"+(passwordService1 == passwordService2));
	}
}
