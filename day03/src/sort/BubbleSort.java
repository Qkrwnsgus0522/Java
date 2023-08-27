package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int temp;
		int[] data = new int[5];
		
		int index = 0 ; // 현재 위치를 나타내는 변수
		
		while(index < data.length) { // data 배열이 완성될때까지 계속
			data[index] = rand.nextInt(10) + 1; //랜덤수를 열심히 저장하고,

			//[ flag 알고리즘 ]
			boolean flag = false; // 초기상태

			// 특별한 일(데이터 중복)이 발생하면 
			for(int i = 0; i < index ; i++) {
				if(data[i] == data[index]) {
					flag = true;
					break;
				}
			}

			if(flag) {
				continue; // 아래로 내려가면 안 된다
			}
			// 잘 되었다면
			index++;
		}
//		System.out.println(Arrays.toString(data) + "처음");
//		
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data.length - i - 1; j++) {
//				if (data[j] > data[j + 1]) {
//					temp = data[j + 1];
//					data[j + 1] = data[j];
//					data[j] = temp;
//				}
//				System.out.println(Arrays.toString(data) + (i + 1) + "회전 " + (j + 1) + "비교");
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < data.length -1 ; i++) {		// i회차 만큼 실행 
			System.out.println((i+1) + " 회차");
			for(int j = 0 ; j < data.length - i - 1; j++) {	// 비교 횟수
				if(data[j] > data[j+1]) {		// 앞에 있는 숫자가 크다면 자리 교환
					// 교환 알고리즘
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}

				
				for(int v : data) {
					System.out.print(v + " ");
				}
				System.out.println();
			}
		}


	}

}
