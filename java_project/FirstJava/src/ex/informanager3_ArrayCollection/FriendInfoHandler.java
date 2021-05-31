package ex.informanager3_ArrayCollection;
import java.util.*;

public class FriendInfoHandler {
	//2021-05-31
	//배열->컬렉션
	ArrayList<Friend> friends;
//	Friend[] friends;
//	int numOfFriend; 
	public FriendInfoHandler(int num) { 
		friends = new ArrayList<Friend>(num); //배열을 컬렉션으로 하기.
//		this.friends = new Friend[num];
//		this.numOfFriend; 
	}

	public void addFriend(int choice) { 
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

			addFriendInfo(new HighFriend(name, phoneNum, address, work));
		}else { 
			System.out.println("전공을 입력해 주세요>");
			String major = s.nextLine();

			addFriendInfo(new UnivFriend(name, phoneNum, address, major));//위의 두 문장과 합치기
		}
	}
	public void addFriendInfo(Friend f) { 
		
		friends.add(f); //컬렉션 : List에 요소 추가
//		friends[numOfFriend++] = f;
		System.out.println("정보가 저장되었습니다.");
	}
	
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		//2021-05-31 : 수정
		// 요소의 저장방식이 배열 > 컬렉션 > 반복문 수정
		if(friends.size()>0) {
			
			for(int i=0; i<friends.size(); i++) {
				friends.get(i).showData();
				System.out.println("====================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("====================");
				
	}
	
	public void showAllBasicData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		//2021-05-31 : List 출력 수정
		if(!friends.isEmpty()) { //friends배열에 비어있지 않지??라고 묻고 비어 있지 않으면 true가 나옴.
			
			for(int i=0; i<friends.size(); i++) {
				friends.get(i).showBasicInfo();
				System.out.println("====================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("====================");
				
	}
}
