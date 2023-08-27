package class08;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework02E {
	
	public static void findIndex(int num) {
		
		Random rand = new Random();
		
		int[] arr = new int[10];
		
		int index = 0;
		
		while (index < arr.length) {
			arr[index] = rand.nextInt(100) + 1;
			
			boolean flag = false;
			
			for (int i = 0; i < index; i++) {
				if (arr[i] == arr[index]) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				continue;
			}
			index++;
		}
		System.out.println(Arrays.toString(arr));
		int fIndex = -1;
		String str = num + "은 배열에 없습니다!";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				fIndex = i;
			}
		}
		if (fIndex != -1) {
			str = num + "은 arr[" + fIndex  + "] 에 저장되어 있습니다.";
		}
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력해 주세요) ");
		int num = sc.nextInt();
		
		findIndex(num);
		
	}

}
