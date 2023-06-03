package class07;

public class Test01 {

	public static void main(String[] args) {
		
		int data = 10 > 5 ? 1 : 2;
		System.out.println(data);

		// a와 b를 비교하여 더 큰 수를 console에 출력해주세요
		int a = 100;
		int b = 200;
		
		int res1 = a > b ? a : b;
		System.out.println(res1);
		
		// c가 짝수라면 'E', 홀수라면 'O'를 console에 출력할 수 있도록 코딩해주세요
		int c = 9;
		
		char res2 = c % 2 == 0 ? 'E' : 'O';
		System.out.println(res2);
	}

}
