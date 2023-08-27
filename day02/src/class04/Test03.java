package class04;

public class Test03 {

	public static void main(String[] args) {
		
		// 1. a = 5, b = 3
		// 작은수부터 큰수까지 출력해주세요
		// 3 4 5
		
		int a = 5;
		int b = 3;
		
		int min1 = a < b ? a : b;
		int max1 = a > b ? a : b;		
		
		for (int i = min1; i <= max1; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		// 2. a = 1, b = 10
		// 작은수부터 큰수까지 출력해주세요
		// 1 3 5 7 9		
		
		int c = 1;
		int d = 10;
		
		int min2 = c < d ? c : d;
		int max2 = c > d ? c : d;
		
		for (int j = min2; j <= max2; j++) {
			if (j % 2 == 1) // 홀수일 때 출력 o
			System.out.print(j + " ");
		}
		
		System.out.println();
		// 2-1.
		
		for (int l = min2; l <= max2; l++) {
			if (l % 2 == 0) { // 짝수일 때 출력 x
				continue;
			}
			System.out.print(l + " ");
		}
		
		System.out.println();
		// 3. 1부터 100까지 총합을 출력해주세요
		
		int e = 1;
		int f = 100;
		int res = 0;
		
		for (int k = e; k <= f; k++) {
			res += k;
		}
		System.out.println(res);

	}

}
