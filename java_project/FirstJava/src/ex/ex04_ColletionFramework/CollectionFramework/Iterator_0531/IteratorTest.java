package ex.CollectionFramework.Iterator_0531;
import java.util.*;

public class IteratorTest {

	public static void main(String[] args) {
		//ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
		//요소 저장 : add(T t)
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("================\n");
		System.out.println("[for 문으로 출력]");
		for(String str : list) {
			System.out.println((str));
		}
		System.out.println("----------------");
		System.out.println("[iterator 로 출력]");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String currentStr = itr.next();
			System.out.println(currentStr);
		}
	}
}
