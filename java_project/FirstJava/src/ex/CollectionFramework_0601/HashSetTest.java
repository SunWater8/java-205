package ex.CollectionFramework_0601;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		//HashSet 저장 공간 생성의 특징 : 인스턴스 저장, 중복 저장을 허용하지 않는다. 저장 순서를 저장하지 않는다.
		
		HashSet<String> hashSet = new HashSet<String>(); //뒤에 있는 <>괄호에 타입은 생략해도 된다. 하지만 명시하는 것이 가장 좋음.
		
		//데이터 저장
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First");
		
		//데이터의 일괄 처리
		Iterator<String> itr = hashSet.iterator();//iterator 타입의 참조값을 반환해 준다.
		
		while(itr.hasNext()) { //입력의 순서대로 출력이 되지 않음. 그리고 중복된 값은 하나만 나옴. equals메소드로 값을 비교함.
			System.out.println(itr.next());
		}
	}

}
