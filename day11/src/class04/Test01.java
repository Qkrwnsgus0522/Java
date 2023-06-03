package class04;

import java.util.Random;
import java.util.Scanner;

class Player {
	private final static int maxIndex = 3; // 최대 포켓몬 개수
	private int preIndex; // 현재 포켓몬 개수
	private Pokemon[] data; // 포켓몬 저장 배열
	private static Random rand = new Random();
		
	
//	Player() {
//		this.preIndex = 1; // 기본 포켓몬 1개
//		this.data = new Pokemon[maxIndex]; // 포켓몬 저장 배열 생성
//		this.data[0] = new Pika(); // 기본 피카츄 생성
//	}
	Player() {
		this.preIndex = 0; // 기본 포켓몬 개수
		this.data = new Pokemon[maxIndex]; // 포켓몬 저장 배열 생성
		this.data[this.preIndex++] = new Pika(); // 기본 피카츄 생성S
	}
	
	void play() {
		if (this.preIndex < 2) { // 저장된 포켓몬 개수가 2마리 미만일 떄 게임 불가
			System.out.println("저장된 포켓몬이 2마리 미만입니다.");
			return;
		}
		// 랜덤 인덱스 번호 생성
		int num1 = rand.nextInt(this.preIndex);
		int num2 = rand.nextInt(this.preIndex);
		if (this.data[num1].equals(this.data[num2])) { // 포켓몬 클래스 타입이 같을 때 게임 불가
		// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		// this.data[num1]가 equals()를 수행하는 주체
		// 타입 == 포켓몬		피카츄, 파이리, 메타몽, ...
		// 부모.메서드()했어도, 알아서
		// 자식이 구현한 메서드가 실행되는 현상
		//	== 동적바인딩 -> "다형성"이 실현되었다!
			
			// ☆ 실제 equals()를 수행하는 주체(주어)가
			// 피카츄, 파이리, 꼬부기, ...
			System.out.println("서로 같은 포켓몬입니다.");
			return;
		}
		if (this.data[num1].game(this.data[num2])) { // 주체 포켓몬이 이겼을 때
			this.data[num1].hello();
		} else { // 반대일 때
			this.data[num2].hello();
		}
	}
	
	
	void addPoke(int num) { // 포켓몬 생성
		if (num == 1) { // 1번 입력시 피카츄 생성
			this.data[this.preIndex] = new Pika();
			System.out.println(this.data[this.preIndex].getName() + " 생성이 완료되었습니다."); 
		} else if (num == 2) { // 2번 입력시 파이리 생성
			this.data[this.preIndex] = new Pyree();
			System.out.println(this.data[this.preIndex].getName() + " 생성이 완료되었습니다."); 
		} else { // 3번 입력시 꼬부기 생성
			this.data[this.preIndex] = new Tle();
			System.out.println(this.data[this.preIndex].getName() + " 생성이 완료되었습니다."); 
		}
		preIndex++; // 현재 포켓몬 개수 증가
	}
	
	public int getPreIndex() {
		return preIndex;
	}

	public void setPreIndex(int preIndex) {
		this.preIndex = preIndex;
	}

	public Pokemon[] getData() {
		return data;
	}

	public void setData(Pokemon[] data) {
		this.data = data;
	}

	public static int getMaxindex() {
		return maxIndex;
	}

	@Override
	public String toString() {
		String list = ""; // 현재 포켓몬 목록
		for (Pokemon poke : this.data) {
			if (poke == null) { // 현재 포켓몬이 있을 때
				break;
			}
			list += poke + "\n"; // 목록에 추가
		}
		return list;
	}
}

abstract class Pokemon {
	private String name;
	private int win;
	
	Pokemon(String name) {
		this.name = name;
		this.win = 0;
	}
	
	abstract void hello();
	
//	@Override
//	public boolean equals(Object obj) {
//		Pokemon poke = (Pokemon)obj; // 다운 캐스팅
//		if (this.name.equals(poke.name)) { // 주체 포켓몬 이름과 비교할 포켓몬 이름이 같을 때
//			return true;
//		}
//		return false;
//	}

	boolean game(Pokemon pokemon) {
		boolean flag = false;
		if (this.win == pokemon.win) {
			flag = true;
		} else if (this.win % 2 != 0 && pokemon.win % 2 != 0) {
			flag = this.win < pokemon.win ? true : false;
		} else if (this.win == 0 && pokemon.win % 2 == 0) {
			flag = this.win > pokemon.win ? true : false;
		} else {
			flag = this.win % 2 != 0 ? true : false;
		}
		if (flag == true) {
			System.out.println(this.name + " 이(가) 승리하였습니다.");
			this.setWin(this.win + 1);
		} else {
			System.out.println(pokemon.name + " 이(가) 승리하였습니다.");
			pokemon.setWin(pokemon.win + 1);
		}
		return flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	@Override
	public String toString() {
		return name + " win=[" + win + "]";
	}
	
	
}

class Pika extends Pokemon {
	Pika() {
		super("피카츄");
	}
	
	@Override
	void hello() {
		System.out.println("피카피카");
	}

	// ★★★★★
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pika) { // obj 가 Pika를 상속받는 클래스인지 확인
			return true;
		}
		return false;
	}
}

class Pyree extends Pokemon {
	Pyree() {
		super("파이리");
	}
	
	@Override
	void hello() {
		System.out.println("파이파이");
	}
	
	// ★★★★★
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pyree) { // obj 가 Pyree를 상속받는 클래스인지 확인
			return true;
		}
		return false;
	}
}

class Tle extends Pokemon {
	Tle() {
		super("꼬부기");
	}
	
	@Override
	void hello() {
		System.out.println("꼬북꼬북");
	}
	
	// ★★★★★
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tle) { // obj 가 Tle를 상속받는 클래스인지 확인
			return true;
		}
		return false;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Player player = new Player();
		
		String menu = "===================\n"
					+ "1. 포켓몬 추가\n"
					+ "2. 가진 포켓몬 전체 출력\n"
					+ "3. 게임시키기\n"
					+ "4. 프로그램 종료\n"
					+ "===================";
		
		String createPoke = "생성할 포켓몬을 선택 해 주세요.\n"
						+ "1. 피카츄\n"
						+ "2. 파이리\n"
						+ "3. 꼬부기";
		
		int action;
		
		while (true) {
			System.out.println(menu); // 메뉴 출력
			action = sc.nextInt();
			if (action == 4) { // 4번 입력시 프로그램 종료
				System.out.println("프로그램 종료");
				break;
			} else if (action == 1) { // 1번 포켓몬 추가
				if (player.getPreIndex() >= Player.getMaxindex()) { // 현재 포켓몬 개수가 최대 포켓몬 개수보다 크거나 같을 때
					System.out.println("최대 " + Player.getMaxindex() + "마리의 포켓몬을 소유할 수 있습니다.");
					continue;
				}
				while (true) {
					System.out.println(createPoke);
					action = sc.nextInt();
					if (action < 1 || action > 3) {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					player.addPoke(action);
					break;
				}
			} else if (action == 2) {
				System.out.println(player.toString());
			} else if (action == 3) {
				player.play();
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}
