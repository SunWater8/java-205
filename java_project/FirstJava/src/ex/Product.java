package ex;

public class Product {
	final int price;
	int bonusPoint;
	
	Product(int price){
		this.price =price;
		bonusPoint = (int)(price/10.0);//소수점 이하 자르기
	}
}