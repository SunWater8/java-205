//프로그래머가 직접 정렬 기준 정의하기

package ex.CollectionFramework.TreeSet_0601;
import java.util.*;

public class TreeSet2 {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>(); 

		// 데이터 저장
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First");

		// 데이터의 일괄 처리
		Iterator<String> itr = hashSet.iterator();

		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
	}

}
