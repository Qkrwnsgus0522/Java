package class06;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int randNum = rand.nextInt(3) + 3;
		int [] data = new int[randNum];
		
		// 1) 반복을 한다!
		// 2) 몇번할지는 모른다! -> while문
		
		// data 배열이 완성될때까지 계속
		int index = 0; // 현재 위치를 나타내는 변수
		while (index < data.length) { // data 배열이 완성될 떄 까지 계속
			data[index] = rand.nextInt(6) + 100; // 랜덤수를 열심히 저장하고,
			
			// [flag 알고리즘]
			boolean flag = false; // 초기상태
			
			// 특별한 일이 발생하면,
			// [데이터 중복]
			for (int i = 0; i < index; i++) {		
				if (data[i] == data[index]) {					
					flag = true;
				}
			}
			
			// 잘 되었다면
			if (flag) {
				continue; // 아래로 내려가면 안된다!!!
			}
			
			index++; // 다음으로!
		}
		
		/*
		while (true) {
			if (data 배열이 완성되었니?) {
				break;
			}
		}
		*/
		
		for (int v : data) {
			System.out.println(v);
		}
		

	}

}
