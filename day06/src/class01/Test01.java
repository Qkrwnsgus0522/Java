package class01;

import java.util.Random;
import java.util.Scanner;

// flag 알고리즘
//	: 특정상황이 T인지 F인지 판단할 떄 활용
//	: 이때 '특정상황'이 반복문, 함수 등처럼
//	  시간이 좀 흘러야,
//	  범위를 모두 확인해야
//	  알 수 있을 때!

public class Test01 {
	
	public static void main(String[] args) {
		
		int[] data = new int[5];
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++) {
			data[i] = rand.nextInt(100) + 1; // 1 ~ 100
		}
		// data.length == 배열의 크기
		//			   != 저장되어있는 데이터으 ㅣ개수
		
		System.out.print("[ ");
		for (int v : data) {
			System.out.print(v + " ");
		}
		System.out.println("]");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력) ");
		int num = sc.nextInt();
		
		boolean flag = false; // OFF. 배열에 num이 없는 상황을 의미
		int index = -1;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] == num) {
				flag = true;
				index = i;
			}
		}
		
		if (flag) {
			System.out.println(num + "은 [" + index + "]에 존재합니다!");
		} else {
			System.out.println(num + "은 배열에 존재하지 않습니다!");
		}
	}

}
