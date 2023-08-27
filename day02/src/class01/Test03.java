package class01;

public class Test03 {

	public static void main(String[] args) {
		
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
		
		// -------------------------------------------------------------------------------------------------
		
		int h = 3;
		int m = 30;
		
		System.out.println(h + "시 " + "분의 1시간 20분 전 시간은");
		
		h--;
		m = m -20;
		
		if (m < 0) {
			m = m + 60;
			h--;
		}
		if (h < 1) {
			h += 12;
		}
		
		System.out.println(h + "시" + m + "분 입니다.");
		
		
	}

}
