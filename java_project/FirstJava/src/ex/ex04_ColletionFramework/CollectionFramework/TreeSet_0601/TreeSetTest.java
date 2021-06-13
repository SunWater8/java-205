package ex.CollectionFramework.TreeSet_0601;
import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {
		//TreeSet : tree 알고리즘을 이용해서 저장한다. 정렬 기준에는 오름차순과 내림차순이 있다.
		//정렬의 기준은 프로그래머가 정의 가능하다.
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		//데이터저장
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(4);
		treeSet.add(2);
		treeSet.add(1);
		treeSet.add(3);
		treeSet.add(1);
		
		//오름차순으로 정렬 됨.
		Iterator<Integer> itr = treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
