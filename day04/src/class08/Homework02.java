package class08;

import java.util.Random;
import java.util.Scanner;

public class Homework02 {
	
	public static int findIndex(int[] arr, int num) {
		int index = -1;
		
		return index;
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100) + 1;
		}
		
		int num = sc.nextInt();
		int res = findIndex(arr, num);
		if (res != -1) {
			System.out.println(num + "은 [" + res + "]에 저장되어 있습니다.");
		} else {
			System.out.println(num + "은 배열에 없습니다!");
		}
		
	}

}
