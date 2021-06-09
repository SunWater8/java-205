//ObjectSerializable
package test;
import java.io.*;
import java.util.ArrayList;

class Circle implements Serializable{ //serializable의 의미는?
	
	int x;
	int y;
	transient double r; 
	// transient 의 의미는?
	
	public Circle(int x, int y, double r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	// 출력하는 것을 두 개나 만든 이유는?
	public void showInfo() {
		System.out.println("원점 x="+x+", y="+y+", 반지름="+r);
	}
	public String toString() {
		return "Circle [x="+x+", y="+y+", r="+r+"]";
	}
}
public class IOTest09 {
	public static void main(String[] args) {
		try {
			//확장자 ser의 의미는?serializable과 연관이 있는건지?
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			//왜 out.write가 아니지?인스턴스 생성한 객체를 쓰는 거라서 그런건지?
			out.writeObject(new Circle(1, 1, 2.4)); 
			out.writeObject(new Circle(2, 2, 4.8));
			out.writeObject("Hello"); //객체가 아닌데도 쓸 수 있다?
			
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1,2,3.4));
			list.add(new Circle(5,3,6.7));
			list.add(new Circle(9,10,6.4));
			list.add(new Circle(5,3,2.4));
			list.add(new Circle(7,12,4.6));
			out.writeObject(list);
			
			out.close();

			System.out.println("인스턴스 저장 완료");

			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));

			Circle cl1 = (Circle) in.readObject();
			Circle cl2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			for(Circle circle : list2) {
				System.out.println(circle);
			}
			System.out.println();
			System.out.println("복원된 인스턴스의 데이터를 출력");

			cl1.showInfo();
			cl2.showInfo();
			System.out.println(str);

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
