package sort;

import java.util.Random;

public class BubbleSort2 {

	public static void main(String[] args) {

		Random rand = new Random();   
		int temp;
		int[] data = new int[5];   // data 배열

		int index = 0 ; // 현재 위치를 나타내는 변수

		while(index < data.length) { // data 배열이 완성될때까지 계속
			data[index] = rand.nextInt(10) + 1; //랜덤수를 열심히 저장하고,

			//[ flag 알고리즘 ]
			boolean flag = false; // 초기상태

			// 특별한 일(데이터 중복)이 발생하면 
			for(int i = 0; i < index ; i++) {
				if(data[i] == data[index]) {
					flag = true;
				}
			}

			if(flag) {
				continue; // 아래로 내려가면 안 된다
			}
			// 잘 되었다면
			index++;
		}
		for(int v : data){
			System.out.print(v + " ");
		}

		for(int i = 0; i < data.length - 1 ; i++) {
			for(int j = 0 ; j < data.length - i - 1; j++) {
				if(data[j] > data[j+1]) {
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
				System.out.println();
				for(int v : data) {
					System.out.print(v + " ");
				}
			}
		}
	}
}
