package class02;

import java.util.HashSet;
import java.util.Set;

public class Test01 {

	public static void main(String[] args) {
		
		// 추상클래스 Set
		// Set류의 부모클래스
//		Set data = new HashSet();
		HashSet<Integer> data = new HashSet<Integer>();
		
		// 집합(Set)
		// 1. 순서가 없음(index XXX)
		// 2. 중복 허용 xxx
		// 3. 다양한 자료형 저장 가능
		//		-> but, 이렇게 사용하지않음!!!!
		//		-> 제네릭 <> 함께사용
		data.add(10);
		data.add(10);
		data.add(10);
		data.add(1234);
		data.add(1);
		data.add(2);
		data.add(12);
		data.add(13);
		data.add(11);
//		data.add("apple");
		
		System.out.println(data);
		System.out.println(data.size());
	}

}
