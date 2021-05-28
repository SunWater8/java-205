package ex.informanager;

import java.util.Scanner;

public class FriendInfoHandler {
	//저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가진 클래스

	Friend[] friends;
	int numOfFriend; //배열의 입력 index역할, 정보의 갯수를 세는 역할.
	public FriendInfoHandler(int num) {//num은 배열의 사이즈를 지정하기 위한 변수 . 배열 인스턴스를 생성하기 위한 변수.
		//		super(); //Object클래스가 상위 클래스라서 이 문장을 생각해도 됨.

		this.friends = new Friend[num];
		this.numOfFriend = 0; //생략해도 되지만 명시적으로 써주는 것이 좋음.
	}

	//데이터의 입력 처리
	//사용자로부터 친구의 정보를 입력 받아서 인스턴스를 생성하고 배열에 저장하도록 한다.
	public void addFriend(int choice) { //[1번-고교 or 2번-대학] 중 선택할 수 있게 하기.
		Scanner s=new Scanner(System.in);
		System.out.println("이름을 입력해 주세요>");
		String name = s.nextLine();
		System.out.println("전화번호를 입력해 주세요>");
		String phoneNum = s.nextLine();
		System.out.println("주소를 입력해 주세요>");
		String address = s.nextLine();

		if(choice == 1) {//고교친구
			System.out.println("직업을 입력해 주세요>");
			String work = s.nextLine();

			//인스턴스 생성   new 다음에 자동완성 누르면 알아서 변수가 들어가게 됨.
//			HighFriend hFriend = new HighFriend(name, phoneNum, address, work); //밑에 있는 메소드 호출하는 문장과 합쳐짐.

			//배열에 요소 추가 //메소드가 만들어지니 이 문단은 필요 없어짐.
			//friends[numOfFriend] = hFriend;
			//numOfFriend++;
			addFriendInfo(new HighFriend(name, phoneNum, address, work));
		}else { //대학친구. else if문에다가 choice 2번을 명시적으로 안써줘도 됨.
			System.out.println("전공을 입력해 주세요>");
			String major = s.nextLine();

//			UnivFriend uFriend = new UnivFriend(name, phoneNum, address, major);

			//배열에 요소를 추가 하기
//			addFriendInfo(uFriend);
			addFriendInfo(new UnivFriend(name, phoneNum, address, major));//위의 두 문장과 합치기
		}//커맨드 패턴으로 중복을 단순화 시켜서 (줄여서) 코드를 더 간단하게 할 수 있다.
	}
	//Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장
	public void addFriendInfo(Friend f) { 
		//배열에 요소 추가
		friends[numOfFriend++] = f;
		System.out.println("정보가 저장되었습니다.");
	}
	
	//모든 데이터를 출력하는 메소드
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		if(numOfFriend>0) {
			
			for(int i=0; i<numOfFriend; i++) {
				friends[i].showData();
				System.out.println("====================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("====================");
				
	}
	
	public void showAllBasicData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		if(numOfFriend>0) {
			
			for(int i=0; i<numOfFriend; i++) {
				friends[i].showBasicInfo();
				System.out.println("====================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("====================");
				
	}
}
