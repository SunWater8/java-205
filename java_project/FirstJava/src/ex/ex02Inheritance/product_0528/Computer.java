package ex.ex02Inheritance.product_0528;

public class Computer extends Product{

	Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
//		return "Computer [PRICE=" + price + ", bonusPoint=" + bonusPoint + "]";
		return "Computer";
	}
}
