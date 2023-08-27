package class01;

class A {
	
}

class Pokemon {
	String name;
	
	Pokemon() {
		this("포켓몬");
	}
	
	Pokemon(String name) {
		this.name = name;
	}
	
	void printInfo() {
		 System.out.println("이 포켓몬은 " + this.name + "입니다.");
	}
	// 최상위클래스 Object로부터 상속받은 메서드이 equals()를
	// 살짝 바꿔서 사용하고싶음!
	//	-> 오버라이딩(메서드 재정의 -> 메서드 시그니처)
	
	void func(double d) { // int 10이 인자로 설정됨
		d = 10.0;
		int i = (int)d; // 형변환(캐스팅)
		
	}
	
	@Override // 어노테이션 : 프로그램이 인지하는 주석
	public boolean equals(Object obj) {
		/*
		double d = 3; // 3.0
		// 자동 형변환
		// 업 캐스팅
		*/
		Pokemon pokemon = (Pokemon)obj;
		// 명시적 형변환
		// 다운 캐스팅
		
		if (this.name.equals(pokemon.name)) {
			return true;
		}
		return false;
	}
}

class Pika extends Pokemon {
	Pika() {
		super("피카츄");
	}
}

class Charmander extends Pokemon {
	Charmander() {
		super("파이리");
	}
}

public class Test01 {
	
	public static void main(String[] args) {
	
		Pika p1 = new Pika();
		Pika p2 = new Pika();
		Charmander c1 = new Charmander();
		
		// p1, c1을 키우미집에 맡겼다!
		// 객체르 비교할 때, 두개의 객체가 같은주소야? xxxx
		// 연산자의 대상이 객체가 될 수 없음!!!!
		// ex) 문자열
		// equals() 메서드는 두개의 객체가 같은 주소일 떄 T
		if (p1.equals(p2)) {
			System.out.println("알을 획득했습니다!");
		} else {
			System.out.println(".....");
		}
		
		// ★★★ Object 클래스
		//	: Java에서 기본제공해주는 최상위 클래스
		
		// 키우미집
		// : 포켓몬 - 1 / 포켓몬 - 2
		// -> 피카츄 피카츄 -> 알
		// ->파이리 피카츄 -> 알 x
		
	}
	
}
