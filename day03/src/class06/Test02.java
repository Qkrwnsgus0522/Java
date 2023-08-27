package class06;

import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		
		// 중복없이 데이터 생성하기
		int[] data = new int[3];
		
		Random rand = new Random();
		int index = 0;
		while (true) {
			if (index == data.length) {
				break;
			}
			
			data[index] = rand.nextInt(10) + 1;
			
			boolean flag = false;
			
			for (int i = 0; i < index; i++) {
				if (data[index] == data[i]) {
					flag = true;
				}
			}
			
			if (flag) {
				continue;
			}
		}
		
		for (int v : data) {
			System.out.println(v);
		}
		
	}

}
