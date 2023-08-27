package class03;

import java.util.Random;
// 자동 임포트 (Ctrl+Shift+O)

public class Test01 {

	public static void main(String[] args) {
		
		int[] stu = new int[6];
		
//		stu[0] = 29;
//		stu[1] = 99;
//		stu[2] = 30;
//		stu[3] = 22;
//		stu[4] = 87;
//		stu[5] = 57;
		
		// 랜덤으로 점수를 생성해보자
		Random rand = new Random();
		
		for (int i = 0; i < stu.length; i++) {
			// stu[i] = 랜덤수;
			stu[i] = rand.nextInt(101); // 0~100까지
			System.out.print(stu[i] + " ");
		}
		System.out.println();
		
		// 1. 평균점수
		int sum = 0;
		for (int i = 0; i < stu.length; i++) {
			sum += stu[i];
		}
		double avg = sum * 1.0 / stu.length;
		System.out.println("평균 : " + avg);
		
		// 2. 평균을 넘긴 학생 수
		// 5. 평균을 못 넘긴 학생들의 번호 --->> 변수 xxx
		//		: 저장공간을 예상하는 방법
		//		: 나중에 배열을 생성하는 방법
		int num = 0; // 평균을 넘긴 학생수를 저장 할 변수
		for (int i = 0; i < stu.length; i++) {
			if (stu[i] >= avg) { // [내가 보고있는 학생]이 평균을 넘결어?
				num++;
			} else {
				System.out.println((i + 1) + "번은 평균점수 이하입니다.");
			}
		}
		System.out.println("평균점수 이상을 받은 학생 수는 : " + num + "명");
		
		// 3. 6등의 번호
		//	-->> [최대값갖기 알고리즘] 활용
		int min = stu[0];
		int minIndex = 0;
		for (int i = 1; i < stu.length; i++) {
			if (min > stu[i]) {
				min = stu[i];
				minIndex = i;
			}
		}
		System.out.println("6등은 " + (minIndex + 1) + "번 입니다.");
		
		// 4. 짝수번 째 학생들의 총점
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < stu.length; i++) {
			if (i % 2 == 1) {
				res1 += stu[i];
			}
			if (i % 2 == 0) {
				continue;
			}
			res2 += stu[i];
		}
		System.out.println("짝수번째 학생들의 총점은 " + res1 + " " + res2 + "점 입니다.");
	}

}
