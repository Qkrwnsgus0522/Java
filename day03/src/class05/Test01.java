package class05;

import java.util.Arrays;
import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int sum = 0;
		double avg = 0;
		int oddSum = 0;
		int evenNum = 0;
		int evenSum = 0;
		double evenAvg = 0;
		
		int N = rand.nextInt(3) + 3;
		int[] data = new int[N];
		int data2[] = new int[N];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(6) + 100;
			sum += data[i];
		}
		
		avg = sum * 1.0 / N;
		
		for (int v : data) {
			if (v % 2 == 1) {
				oddSum += v;
			} else {
				evenSum += v;
				evenNum++;
			}
		}
		
		evenAvg = evenSum * 1.0 / evenNum;
		
		for (int i = 0; i < data2.length; i++) {
			// 랜덤수 생성
			int ranNum = rand.nextInt(6) + 100;
			data2[i] = ranNum;
			int j = 0; // 중복 확인 할 인덱스
			// 중복 확인
			while (j < i) { // 추가된 값 까지 확인
				data2[i] = ranNum; // i번째 인덱스에 랜덤 값 선언
				if (data2[j] != ranNum) { // 랜덤수와 j번째 인덱스가 다르면
					j++; // 다음 인덱스 배열 중복 확인
				} else {
					ranNum = rand.nextInt(6) + 100;
					j = 0; // 랜덤 수 생성하고 0번째부터 확인
				}
			}
		}
		
		System.out.println(Arrays.toString(data));
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("홀수들의 총합 : " + oddSum);
		System.out.println("짝수들의 평균 : " + evenAvg);
		System.out.println(Arrays.toString(data2));
		
		
	}

}
