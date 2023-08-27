package class03;

public class Test03 {

	public static void main(String[] args) {

		// a부터 b까지 출력해주세요!
		// a = 33
		// b = 29
		// 29 30 31 32 33
		// --> "무한루프를 활용해서" 풀어보세요
		
		int a = 33;
		int b = 29;
		
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int i = a;
		while (true) {
			System.out.print(i + " ");
			i++;
			if (i > b) {
				break;
			}
		}
		
	}

}
