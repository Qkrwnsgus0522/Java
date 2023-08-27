package class08;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework02 {
	
	public static int findIndex(int[] arr, int num) {
		int index = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
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
		System.out.print("정수를 입력해 주세요) ");
		int num = sc.nextInt();
		int res = findIndex(arr, num);
		if (res != -1) {
			System.out.println(num + "은 arr[" + res + "]에 저장되어 있습니다.");
		} else {
			System.out.println(num + "은 배열에 없습니다!");
		}
		
	}

}
