package class06;

public class Test01 {

	public static void main(String[] args) {
		
		// 1.
		// *****
		//  ****
		//   ***
		//    **
		//     *
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");					
				}
			}
			System.out.println();
		}
		*/
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		// ---------------------------------
		
		// 2.
		// *****
		// ****
		// ***
		// **
		// *
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		*/
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i; j++ ) {
				System.out.print(" ");
			}
			System.out.println();
		}
		*/
		
		// ---------------------------------
		
		// 3.
		//     *
		//    **
		//   ***
		//  ****
		// *****
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (4 - i > J) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		*/
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		// ---------------------------------
		
		// 4.
		//   *
		//  ***
		// *****
		
		/*
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (2 - i > j || 2 + i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		*/
		
		/*
		for (int i = 0; i < 3; i++)  {
			for (int j = 0; j < 2 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
	}
}
