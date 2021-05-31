package ch02;

public class Member {

	public static void main(String[] args) {
		String name = "Jamie";
		int age = 10;
		double height = 130.5;
		boolean hasBook = true;
		
		System.out.println("My name is "+name);
		System.out.println("She is "+age+"years old");
		System.out.println("Her height is "+height);
		System.out.println("Having a Java Book : "+ hasBook);
		
		if(hasBook) {
			System.out.println("책 있어요");
		}else {
			System.out.println("책 없어요");
		}
		
	}

}
