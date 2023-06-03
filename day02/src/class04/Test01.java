package class04;

public class Test01 {

	public static void main(String[] args) {
		
		int a = 33;
		int b = 29;
		
		int min = a < b ? a : b; // 최소값
		int max = a > b ? a : b; // 최대값
		
		while (true) {
			System.out.print(min + " ");
			min++;
			if (min > max) {
				break;
			}
		}

	}

}
