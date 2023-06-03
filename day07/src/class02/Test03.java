package class02;

class Home {
	String name;
	static int money = 10000;
	
	Home(String name) {
		this.name = name;
		System.out.println(this.name + " 구성원 생성!");
	}
	
	boolean use(int use) {
		Home.money -= use;
		if (Home.money <= 0) {
			System.out.println(this.name + "님 " + use + "원 결제중, 잔액 : " + Home.money);
			return true;
		}
		System.out.println(this.name + "님 " + use + "원 결제중, 잔액 : " + Home.money);
		return false;
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Home[] person = new Home[3];
		person[0] = new Home("홍길동");
		person[1] = new Home("김길동");
		person[2] = new Home("박길동");
		
		int i = 0;
		while (true) {
			if (person[i++].use(1500)) {
				break;
			}
			if (i == person.length) {
				i = 0;
			}
		}

	}

}
