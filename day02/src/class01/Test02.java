package class01;

public class Test02 {

	public static void main(String[] args) {
		
		// 과제 2
		// 나이가 저장된 변수가 있습니다.
		// 나이가 8 ~ 19이면 1,000원
		// 나이가 20 ~ 65이면 2,000원
		// 나머지는 무료!
		// 라고 출력 해 주세요
		int age = 26;

		if (age >= 8 && age <= 19) {
			System.out.println("1000원");
		} else if (age >= 20 && age <= 65) {
			System.out.println("2000원");
		} else { // age >= 66 || age <= 7
			System.out.println("무료!");
		}

		// --------------------------------------------------------------------
		
		int ageA = 26;
		int res;
		
		if (ageA < 1 || 200 <= ageA) {
			System.out.println("유효하지않은 값입니다.");
		} else {
			if (8 <= ageA && ageA <= 19) {
				res = 1000;
			} else if (20 <= ageA && ageA <= 65) {
				res = 2000;
			} else {
				res = 0;
			}
			
			if (res == 0) {
				System.out.println("무료!");
			} else {
				System.out.println(res + "원 입니다.");
			}
		} 

	}

}
