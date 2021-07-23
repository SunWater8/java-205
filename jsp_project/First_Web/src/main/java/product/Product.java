package product;

import java.util.Arrays;

// beans 형식의 클래스로 정의 : 상품정보를 저장
public class Product {
	//상품 목록 : 배열
	private String[] productList = {"item1", "item2", "item3", "item4", "item5"};
	//beans 형식이기 대문에 타입 앞에 private을 붙여 준다.
	
	//변수 : el 테스트
	private int price = 100;
	private int amount = 1000;
	
	//getter 만 생성 - 내부 변수의 값을 반환하기 위한 목적
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	// EL에서 ${product.display} 라고 입력할 떼 이 메소드를 호출 
	public String getDisplay() {
		return "price: "+this.price+", amount : "+this.amount;
	}
	
	@Override
	public String toString() {
		return "Product [pList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
}
