package class06;

public class Test04 {

	public static void main(String[] args) {

		// 비교 연산자
		System.out.println(10 > 5);
		System.out.println(10 < 5);
		System.out.println(10 < 10);
		System.out.println(10 == 5);
		System.out.println(10 != 5);

		// 논리 연산자
		int age = 50;
		System.out.println(age >= 19 && age < 45);
//		System.out.println(19 <= age <45); // 사용불가

		int price = 1500;
		System.out.println(price <= 1000 || price > 20000);
		
		System.out.println(!(price <= 1000 || price > 20000));
		
		boolean data = true;
		System.out.println(data);
		System.out.println(!data);
	}

}
