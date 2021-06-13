//데이터 저장하고 끄집어 내기

package ex.CollectionFramework.Map_0601;

import java.util.*;

import ch11.MyCollectionFramework.Football4HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		//Map 은 key-value 형식으로 저장한다.
		//key : 저장한 데이터를 식별하기 위한 값이다.  중복허용x 
		//value : 저장하고자 하는 데이터이다.       중복허용o
		
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		
		//데이터 저장 : put(e)
		map.put(new Integer(1), "일번");
		map.put(5, "오번");
		map.put(8, "팔번");
		
		//데이터 탐색
		System.out.println(map.get(5));
		System.out.println(map.get(1));
		System.out.println(map.get(8));
		System.out.println(map.get(10));//(저장)입력한 적이 없기 때문에 null값이 나온다.
		
	}
}
