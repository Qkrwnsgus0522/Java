package class02;

public class Test02 {

	public static void main(String[] args) {
		
		// 평균점수
		// 평균을 넘긴 학생수
		// 6등의 번호
		// 짝수번째 학생들의 총점
		// 평균을 못 넘긴 학생들의 번호
		
		int[] stu = new int[6];
		stu[0] = 29;
		stu[1] = 99;
		stu[2] = 30;
		stu[3] = 22;
		stu[4] = 87;
		stu[5] = 57;
		
		// 총 점수 합
		int sum = 0;
		
		for (int i = 0; i < stu.length; i++) {
			sum += stu[i];
		}

		// 평균 점수
		double avg = sum * 1.0 / stu.length;
		
		// 평균을 넘긴 학생 수
		int overAvg = 0;
		
		// 짝수번째 학생들의 총점
		int evenSum = 0;
		
		// 6등의 번호
		int min = stu[0];
		int minIndex = 0;
		
		for (int i = 0; i < stu.length; i++) {
			// 평균을 넘긴 학생 수
			if (stu[i] > avg) {
				overAvg++;
			}
			// 짝수번쨰 학생들의 총점
			if ((i + 1) % 2 == 0) {
				evenSum += stu[i];
			}
			// 6등의 번호
			if (stu[i] < min) {
				min = stu[i];
				minIndex = i;
			}
		}
		
		System.out.println("평균 점수 : " + avg);
		System.out.println("평균을 넘긴 학생 수 : " + overAvg);
		System.out.println("6등의 번호 : " + (minIndex + 1));
		System.out.println("짝수번째 학생들의 총점 : " + evenSum);
		
		// 평균을 못 넘긴 학생들의 번호
		System.out.print("평균을 못 넘긴 학생 번호 : ");
		for (int i = 0; i < stu.length; i++) {
			if (stu[i] < avg) {
				System.out.print((i + 1) + "번 ");
			}
		}
	}

}
