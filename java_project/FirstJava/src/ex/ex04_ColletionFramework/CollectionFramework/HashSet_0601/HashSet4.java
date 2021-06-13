//값을 비교하는 기준을 오버라이딩을 통해 내가 바꾸어서 인스턴스 생성된 값이더라도 중복된 값을 무시해서 출력하도록 만들기
package ex.CollectionFramework.HashSet_0601;

import java.util.*;

public class HashSet4 {

	public static void main(String[] args) {
		HashSet<SimpleNumber1> hashSet = new HashSet<SimpleNumber1>();

		// 데이터 저장
		hashSet.add(new SimpleNumber1(10));
		hashSet.add(new SimpleNumber1(20));
		hashSet.add(new SimpleNumber1(30));
		hashSet.add(new SimpleNumber1(20));

		// 데이터의 일괄 처리
		Iterator<SimpleNumber1> itr = hashSet.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

class SimpleNumber1 {
	int num;

	SimpleNumber1(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		return num%3;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		//obj는 null이 아니고, obj는 SimpleNumber타입	으로 형변환이 가능해야 한다..는 조건을 만든다.
		if(obj!=null && obj instanceof SimpleNumber1) {
			SimpleNumber1 sNum = (SimpleNumber1)obj; //obj를 simpleNumber타입으로 형변환 해준다.
			if(this.num == sNum.num) {
				result = true;
			}
		}
		return result;
	}
	public String toString() {
		return String.valueOf(num);
	}
}
