package class04;

import java.util.Random;

// [ 연습문제 ]
// 1. Home의 구성원 객체들을 3명 생성할 예정
// 2. 각 객체들은 고유한 이름(name)을 가짐
// 3. Home의 구성원 객체들이 공유하는 계좌가 있음
// 			== money
// 4. money에 10,000원 있음
// 5. person.use(5000);
//	  money를 5000만원 사용
// 6. 여러번 사용할 예정
// 7. money을 0원 이하로 만든사람의 이름을 출력해주세요!~~
// ※ 인스턴스 변수 vs 클래스 변수
// ※ 멤버변수, 메서드(+생성자) 고려할 것
// ※ 객체배열

class Home {
	String name;
	static int money = 10000;
	
	Home(String name) {
		this.name = name;
	}
	
	boolean use(int money) {
		System.out.println(this.name + "님이 " + money + "원 결제중입니다!");
		if (Home.money <= money) {
			System.out.println(this.name + "님이 과소비중입니다...");
			return false;
		}
		Home.money -= money;
		return true;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Home[] data = new Home[3];
		data[0] = new Home("홍길동");
		data[1] = new Home("홍길순");
		data[2] = new Home("홍길자");
		
		Random rand = new Random();
		int i = 0;
		while (true) {
			int randMoney = (rand.nextInt(50) + 1) * 100;
			if (!data[i++].use(randMoney)) {
				break;
			}
			if (i == data.length) {
				i = 0;
			}
		}
	}

}
