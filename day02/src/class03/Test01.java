package class03;

// 한 소스코드 내에서는
// 유사한 코드가 없도록 작성해보자!!!
public class Test01 {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 9;
		
		while (a <= b) {
			System.out.print(a + " ");
			a++;
		}
		
		System.out.println();
		// ---------------------------------------
		
		int c = 5;
		int d = 9;
		
		int i = c;
		while (i <= d) {
			System.out.print(i + " ");
			i++;
		}

		System.out.println();
		// ---------------------------------------
		
		int e = 10;
		int f = 9;
		
		int min = e > f ? f : e;
		int max = e > f ? e : f;
		
		int j = min;
		while (j <= max) {
			System.out.print(j + " ");
			j++;
		}
		
		System.out.println();
		// ---------------------------------------
		
		int g = 10;
		int h = 9;
		
		// 항상 a가 b보다 작을 수 있도록
		// "교환 알고리즘"을 활용
		if (g > h) { // a와 b의 값을 교환해줘!
			int tmp = g; // "임시저장변수"
			g = h;
			h = tmp;
		}
		
		int k = g;
		while (k <= h) {
			System.out.print(k + " ");
			k++;
		}
		
	}

}
