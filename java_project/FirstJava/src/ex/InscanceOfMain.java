package ex;

public class InscanceOfMain {

	public static void wrapBox(Box box) {
		//형 변환 여부 확인하기
		box.wrap(); //오버라이딩 되었으므로 이 공간의 코드가 더 이상 늘어나지 않는다.
	}
	
	public static void main(String[] args) {
		Box box = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box);
		wrapBox(box2);
		wrapBox(box3);
	}

}

class Box{
	public void wrap() {
		System.out.println("SimpleWrap");
	}
}
class PaperBox extends Box{
	public void wrap() {
		System.out.println("PaperWrap");
	}
}

class GoldPaperBox extends PaperBox{
	public void wrap() {
		System.out.println("GoldPaperWrap");
	}
}