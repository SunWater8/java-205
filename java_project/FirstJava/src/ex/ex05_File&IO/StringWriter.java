package ex.FileIOStream0602;
import java.io.*;

public class StringWriter {
	public static void main(String[] args) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("String.txt "));
			
			System.out.println("쓰기 시작");
			out.write("손흥민 - 메시 멈추게 하는 데에 집중하겠다. ");//out다음에 나오는 template proposals 한 번 살펴보기
			out.newLine();
			out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
			out.write("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
			out.newLine();
			out.write("환상적인 결승전이 될 것이다.");
			out.newLine();
			out.newLine();
			out.write("기사 제보 및 보도자료");
			out.newLine();
			out.write("press@goodnews.co.kr");
			
			out.close();
			
			System.out.println("기사 입력 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
