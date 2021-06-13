package ex.ex02Inheritance.product_0528;

public class Buyer{
	
	int money;
	int bonusPoint;
	
	Product[] item;
	int cnt;//구매한 제품의 갯수 -> 배열의 입력 index값
	
	Buyer(){
		this.money=10000;
		this.bonusPoint=0;
		this.item = new Product[10];
		this.cnt=0;
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
		
		//구매 내역에 제품을 추가
		item[cnt++] = p;
//		cnt++;
		
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void summary() {
		//구매 상품 리스트, 구매금액의 총합 출력
		int sum = 0; //구매 총액
		int bonusPoint=0;
		String itemList = "";//뒤에 문자열을 붙이기 위해 빈공간 출력
		
		//배열을 반복문을 이용해서 구매내역 완성하기
		for(int i=0; i<cnt;i++){
			//금액의 합
			sum += item[i].price;
			
			//구매 상품 이름
			itemList += item[i] + ", ";
			//적립될 보너스
			bonusPoint += item[i].bonusPoint;
		}
		System.out.println("구매하신 제품은 "+ itemList + "입니다.");
		System.out.println("구매하신 제품의 총 금액은 "+sum + "원 입니다.");
		System.out.println("구매하신 제품의 적립 포인트는 "+bonusPoint + "점 입니다.");
	}
}