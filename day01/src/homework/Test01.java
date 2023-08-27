package homework;

public class Test01 {

	public static void main(String[] args) {
		
		// 과제 1
		// 월이 저장된 데이터(==변수)가 있습니다.
		// 3, 4, 5 -> 봄
		// 6, 7, 8 -> 여름
		// 9, 10, 11 -> 가을
		// 12, 1, 2 -> 겨울
		// 라고 출력 해 주세요
		int month = 6;
		
		if (month >= 3 && month <= 5) {
			System.out.println("봄");
		} else if (month >= 6 && month <= 8) {
			System.out.println("여름");
		} else if (month >= 9 && month <= 11) {
			System.out.println("가을");
		} else { // month >= 12 || month <= 2
			System.out.println("겨울");
		}
		
		// 과제 2
		// 나이가 저장된 변수가 있습니다.
		// 나이가 8 ~ 19이면 1,000원
		// 나이가 20 ~ 65이면 2,000원
		// 나머지는 무료!
		// 라고 출력 해 주세요
		int age = 4;
		
		if (age >= 8 && age <= 19) {
			System.out.println("1000원");
		} else if (age >= 20 && age <= 65) {
			System.out.println("2000원");
		} else { // age >= 66 || age <= 7
			System.out.println("무료!");
		}
		
		// 과제 3
		// 3시 30분의 1시간 20분 전 시간은 2시 10분 입니다.
		// 1시 10분의 1시간 20분 전 시간은 11시 50분 입니다.
		// 라고 출력 해 주세요
		int a = 1;
		int b = 10;
		
		// decM <= 60
		int decH = 15;
		int decM = 20;
		
		int resH, resM;
		
		if (a - decH <= 0 && b - decM < 0) {
			resH = 12 - ((decH % 12) - a) - 1;
			resM = 60 - (decM - b);
		} else if (a - decH <= 0) {
			resH = 12 - ((decH % 12) - a);
			resM = b - decM;
		} else if (b - decM < 0) {
			resH = (a - decH - 1 == 0) ? 12 : a - decH - 1;
			resM = 60 - (decM - b);
		} else {
			resH = a - decH;
			resM = b - decM;
		}
		System.out.println(a + "시 " + b + "분의 " + decH + "시간 " + decM + "분 전 시간은 " + resH + "시 " + resM + "분 입니다.");
	}

}
