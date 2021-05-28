package ex;

public class Buyer{
	
	int money;
	int bonusPoint;
	
	Buyer(){
		this.money=10000;
		this.bonusPoint=0;
	}

	//물건 사는 메소드 만들기
	void buy(Product p) {//상위클래스를 매개변수의 타입으로 하기
		//보유 금액 확인해서 제품 구매할 수 있는 지 여부 확인하기.
		if(money <p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return; //이 return 의 의미: 메소드를 종료 시키기 위함. + 값을 반환함.
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}