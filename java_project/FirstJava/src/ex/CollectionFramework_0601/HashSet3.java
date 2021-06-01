//인스턴스로 저장을 하면 중복되는 값을 무시하지 않고 출력 한다. 

package ex.CollectionFramework_0601;

import java.util.*;

public class HashSet3 {

	public static void main(String[] args) {

		HashSet<SimpleNumber> hashSet = new HashSet<SimpleNumber>();

		// 데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(30));
		hashSet.add(new SimpleNumber(20));

		// 데이터의 일괄 처리
		Iterator<SimpleNumber> itr = hashSet.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

class SimpleNumber {
	int num;

	SimpleNumber(int num) {
		this.num = num;
	}

	public String toString() {
		return String.valueOf(num);
	}
}
