package ex.FileIOStream0602.SerializableInstMember;
import java.io.*;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
class Circle implements Serializable{
	Point p;
	double rad;
	
	public Circle(int x, int y, double r) {
		p=new Point(x,y);
		rad=r;
	}
	public void showCircleInfo() {
		System.out.printf("[%d, %d] \n", p.x, p.y);
		System.out.println("rad : "+rad);
	}
}
public class SerializableInstMember {

	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(2,2,4.8));
			out.writeObject(new String("String implements Serializable"));
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			Circle cl1 = (Circle)in.readObject();
			Circle cl2 = (Circle)in.readObject();
			String message = (String)in.readObject();
			in.close();
			
			cl1.showCircleInfo();
			cl2.showCircleInfo();
			System.out.println(message);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
