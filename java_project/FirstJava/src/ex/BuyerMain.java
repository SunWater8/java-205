package ex;

public class BuyerMain {
	public static void main(String[] args) {
		//구매자 객체 생성
		Buyer buyer = new Buyer();
		
		//제품 객체 생성
		Tv tv = new Tv(100);
		Computer com = new Computer(30);
		
		//구매
		buyer.buy(tv);
		buyer.buy(com);
		
		//결과 지표
		System.out.println("현재 잔돈 : "+buyer.money);
		System.out.println("현재 포인트 : "+buyer.bonusPoint);
	}
}
