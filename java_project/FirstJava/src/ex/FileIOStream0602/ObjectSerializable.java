package ex.FileIOStream0602;
import java.io.*;

import ex.FileIOStream0602.ObjectSerializable.Circle;

class Circle implements Serializable{
	//implements Serializable: 직렬화 대상임을 의미한다. 마킹.
	int x;
	int y;
	double r;
	
	public Circle(int x, int y, double r) {
		this.x=x;
		this.y=y;
		this.r=r;
	}
	public void showCircleInfo() {
		System.out.printf("원점 [%d, %d] \n", x, y);
		System.out.println("반지름 : "+r);
	}
}
public class ObjectSerializable {
	public static void main(String[] args) {
		
		try {
			//인스턴스를 저장하기
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1,1,2.4)); //serializable를 implements 한 클래스만 들어올 수 있다.
			out.writeObject(new Circle(2,2,4.8));
			out.writeObject("Hello");
			out.writeObject(new String("String implements Serializable"));
			out.close();
			
			System.out.println("인스턴스 저장 완료");
			
			//인스턴스 복원
			//지금 만든 파일 Object.ser의 내용을 가져와서 복원하기
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			//복원 순서는 저장한 순서대로 해야 한다.
			Circle cl1 = (Circle)in.readObject(); //예외 발생 염두해 두기 
			Circle cl2 = (Circle)in.readObject();
			String str = (String)in.readObject();
			in.close();
			
			System.out.println("복원된 인스턴스의 데이터를 출력");
			
			cl1.showCircleInfo();
			cl2.showCircleInfo();
			System.out.println(str);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}