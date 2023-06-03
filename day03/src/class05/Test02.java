package class05;

import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int randNum = rand.nextInt(3) + 3;
		int[] data = new int[randNum];
		
		System.out.print("[ ");
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(6) + 100;
			System.out.print(data[i] + " ");
		}
		System.out.println("]");
		
		int oSum = 0;
		int eSum = 0;
		int eCnt = 0;
		double eAvg;
		
		for (int v : data) {
			if (v % 2 == 0) {
				eSum += v;
				eCnt++;
			} else {
				oSum += v;
			}
		}
		
		eAvg = eSum * 1.0 / eCnt;
		
		System.out.println("홀수 총합 : " + oSum);
		System.out.println("짝수 평균 : " + eAvg);
	}

}
