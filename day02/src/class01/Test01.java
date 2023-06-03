package class01;

// ★ 유효성 검사
public class Test01 {

	public static void main(String[] args) {

		// 과제 1
		// 월이 저장된 데이터(==변수)가 있습니다.
		// 3, 4, 5 -> 봄
		// 6, 7, 8 -> 여름
		// 9, 10, 11 -> 가을
		// 12, 1, 2 -> 겨울
		// 라고 출력 해 주세요
		int month = 5;

		if (month >= 3 && month <= 5) {
			System.out.println("봄");
		} else if (month >= 6 && month <= 8) {
			System.out.println("여름");
		} else if (month >= 9 && month <= 11) {
			System.out.println("가을");
		} else { // month >= 12 || month <= 2
			System.out.println("겨울");
		}
		
		// ---------------------------------------------------------------------------
		
		int monthA = 5; // 월이 저장된 데이터

		String season; // 결과를 저장할 변수


		if (1 <= monthA && monthA <= 12) {
			if (3 <= monthA && monthA <= 5) { // month == 3 || month == 4 || month == 5
				season = "봄";
			} else if (6 <= monthA && monthA <= 8) {
				season = "여름";
			} else if (9 <= monthA && monthA <= 11) {
				season = "가을";
			} else {
				season = "겨울";
			}
			System.out.println("현재 : " + season);
		} else {
			System.out.println("잘못된 값 입니다.");
		}

		

	}

}
