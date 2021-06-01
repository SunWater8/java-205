//Integer 타입의 hashSet

package ex.CollectionFramework.HashSet_0601;
import java.util.*;

public class HashSet2 {
	public static void main(String[] args) {

		HashSet<Integer> hashSet = new HashSet<Integer>(); 

		// 데이터 저장
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		// 데이터의 일괄 처리
		Iterator<Integer> itr = hashSet.iterator();

		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
	}
}
