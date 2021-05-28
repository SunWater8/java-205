package ex;

public class InscanceOfMain {

	public static void wrapBox(Box box) {
		//형 변환 여부 확인하기
		if(box instanceof GoldPaperBox) {
			((GoldPaperBox)box).goldWrap();
		}else if(box instanceof PaperBox) {
			((PaperBox)box).paperWrap();
		}else {
			box.simpleWrap();
		}
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
	public void simpleWrap() {
		System.out.println("SimpleWrap");
	}
}
class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("PaperWrap");
	}
}

class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("GoldPaperWrap");
	}
}