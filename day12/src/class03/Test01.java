package class03;

import java.util.HashSet;
import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		// 1개씩 10번 VS 10개를 1번
		// -> 어떤 자료형을 선택하는지?
		// 배열 < 컬렉션(배열리스트, 집합)
		// 배열리스트 < 집합
		
		// Set은 정렬방식에 따라 이름이 붙임
		// Hash는 크기를 비교해서 정렬
		// Set은 인덱스 개념과 순서 개념이 없어서 정렬 어려움
		HashSet<Integer> data = new HashSet<Integer>();
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			int num = rand.nextInt(15) + 1;
			System.out.println("랜덤수: " + num);
			data.add(num);
		}
		
		System.out.println(data.size());
		System.out.println(data);
		
		// +) 만약, 정렬이 하고싶다면?
		// 집합 xxx -> 배열리스트로 이동해서 정렬
	}
}
