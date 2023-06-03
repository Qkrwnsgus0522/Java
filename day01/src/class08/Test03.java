package class08;

public class Test03 {

	public static void main(String[] args) {
		
		int a = 100;
		
		// 만약, a가 10의 배수라면
		// [ 10의 배수입니다! ]
		// >> 위 상황을 >>>추가<<<하고싶어!!
		
		// ★★★★★ 조건문은 범위가 적은것 부터 넓은 순서대로 작성! ★★★★★
		
		if (a % 10 == 0) { // 만약 a가 10의 배수라면,
			System.out.println("10의 배수입니다!");
		} else if (a % 2 == 0) { // 위의 조건식이 아니야? 그럼, a가 짝수니?
			System.out.println("짝수입니다.");
			// else if 문은 여~러개 추가가능하다!
		} else {
			System.out.println("홀수입니다.");
		}

	}

}
