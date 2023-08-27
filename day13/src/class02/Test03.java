package class02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		// 1
		int i = 0;
		final int CNT = 10;
		int num;
		while (i < CNT) {
			try {
				System.out.print("정수입력) ");
				num = sc.nextInt();
				System.out.println("num= " + num);
				data.add(num);
				i++;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로만 입력해주세요.");
			}
		}
		System.out.println(data);
		
		// 2
		int j = 0;
		while (j < data.size()) {
			if (data.get(j) <= 0) {
				data.remove(j);
				continue;
			}
			j++;
		}
		System.out.println(data);
		
		// 3
		int maxIndex = 0;
		int max = 0;
		
		if (!data.isEmpty()) {
			max = data.get(0);
			for (int k = 1; k < data.size(); k++) {
				if (data.get(k) > max) {
					max = data.get(k);
					maxIndex = k;
				}
			}
		}
		if (max == 0) {
			System.out.println("배열에 숫자가 존재하지 않음");
		} else {
			System.out.println("[" + maxIndex + "]번");			
		}
		
		// 4
		if (!data.isEmpty()) {
			data.remove(maxIndex);			
		}
		int sum = 0;
		for (int v : data) {
			sum += v;			
		}
		double avg = sum * 1.0 / data.size();
		System.out.println(sum + " " + avg);
	}

}
