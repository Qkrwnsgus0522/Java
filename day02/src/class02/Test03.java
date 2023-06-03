package class02;

public class Test03 {

	public static void main(String[] args) {
		
		System.out.println();
		
		int c = -5;
		int d = -3;
		
		while (c <= d) {
			System.out.print(c + " ");
			c++;
		}
		
		System.out.println();
		
		int e = 2;
		int f = 2;
		
		while (e <= f) {
			System.out.print(e + " ");
			e++;
		}
		
		System.out.println();
		
		int g = 3;
		int h = 1;
		int i;
		
		if (g > h) {
			i = g - h;
			while (i >= 0) {
				System.out.print(h + " ");
				h++;
				i--;
			}
		} else {
			i = h - g;
			while (i >= 0) {
				System.out.print(g + " ");
				g++;
				i--;
			}
		}
		
		System.out.println();

	}

}
