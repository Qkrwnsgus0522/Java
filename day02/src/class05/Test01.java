package class05;

// [ 중첩 반복문 ] (이중for문)
// 구구단
// 별찍기

public class Test01 {

	public static void main(String[] args) {
		
		int res;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				res = i * j;
				System.out.println(i + " X " + j + " = " + res);
			}
		}
		
	}

}
