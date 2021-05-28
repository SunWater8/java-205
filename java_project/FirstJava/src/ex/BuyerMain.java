package ex;

public class BuyerMain {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		Tv tv = new Tv(100);
		Computer com = new Computer(30);
		
		buyer.buy(tv);
		buyer.buy(com);
		
		System.out.println("현재 잔돈 : "+buyer.money);
		System.out.println("현재 포인트 : "+buyer.bonusPoint);
	}
}
