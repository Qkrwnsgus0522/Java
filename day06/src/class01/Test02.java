package class01;

import java.util.Random;

// 메서드 시그니처
// 메서드(함수)의 3요소
// 1.input 2.output 3.기능
// public static int makeRandNum(int start, int end)

public class Test02 {
	
	// 함수 제작 방법 1)
	// 메서드 시그니처를 먼저 정의하고,
	// 내부 기능을 구현하는 방법
	
	// 시작 범위부터 ~ 끝 범위까지 중에서
	// 랜덤으로 정수 1개를 출력해주세요!~~
	// input: int start, int end -> int x2
	// output: X(void)
//	public static void makeRandNum(int L, int H) {		
	public static void printRandNum(int start, int end) {
		Random rand = new Random();
		int randNum = rand.nextInt(end - start + 1) + start;
		System.out.println("랜덤수 : " + randNum);
	}
	
	// 함수 제작 방법 2)
	// 내부 기능을 가져오고,
	// 가져온 그 기능에 맞게 메서드 시그니처를 작성하는 방법
	public static int func(int start, int end) {
		Random rand = new Random();
		int randNum = rand.nextInt(end - start + 1) + start;
		return randNum;
	}
	
	public static void main(String[] args) {
		
		// 이미 잘 만들어져있었던 기능을 뜯어감
		int start = 10;
		int end = 20;
		int randNum = func(start, end);
		System.out.println("랜덤수 : " + randNum);
		printRandNum(start, end);

	}

}
