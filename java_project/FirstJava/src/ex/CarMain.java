//java_10_객체지향_상속_12p 문제1

package ex;

class Car{
	int gasolinegauge;
	
	Car(int gas){
		this.gasolinegauge=gas;
	}
}
class HybridCar extends Car{
	int electronicGauge;
	
	HybridCar(int gas,int eg) {
		super(gas);
		this.electronicGauge=eg;
		
	}
}
class HybridWaterCar extends HybridCar{
	int waterGauge;
	
	HybridWaterCar(int gas, int eg, int wg) {
		super(gas, eg);
		this.waterGauge=wg;
	}
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : "+gasolinegauge);
		System.out.println("잔여 가솔린 : "+electronicGauge);
		System.out.println("잔여 가솔린 : "+waterGauge);
	}
}
public class CarMain {
	public static void main(String[] args) {
		HybridWaterCar car = new HybridWaterCar(200,300,400);
		car.showCurrentGauge();
	}
}

