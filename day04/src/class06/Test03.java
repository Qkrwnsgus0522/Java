package class06;

public class Test03 {

	public static void printGrade(int score) {
		if (score < 0 || score > 100) {
			System.out.println("점수가 유효하지않습니다! 확인이 필요합니다.");
			return; // 함수를 즉시종료하겠습니다.
		}
		
		char grade = 'C';
		if (score >= 80) {
			grade = 'A';
		} else if (score >= 60) {
			grade = 'B';
		}
		System.out.println(score + "점은 " + grade + "등급 입니다.");
	}
	
	public static void main(String[] args) {
		printGrade(101);
		printGrade(85);
		printGrade(68);
		printGrade(1);
	}

}
