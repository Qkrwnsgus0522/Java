package class04;

import java.util.Random;
import java.util.Scanner;

// [ 최종문제 ]
// PokeMon 클래스 생성
// 인스턴스변수 (이름, 레벨, 경험치)
// PokeMon(이름, 레벨) 생성자 {
// 이름
// 레벨
// 경험치 => 0 ~ 10랜덤생성
// }

class PokeMon {
	String name;
	int level;
	int exp;
	final int maxExp = 100;

	PokeMon(String name, int level) {
		Random rand = new Random();

		this.name = name;
		this.level = level;
		this.exp = rand.nextInt(11);
	}

	void game() {
		Random rand = new Random();
		if (rand.nextInt(2) == 0) {
			System.out.println(this.name + " 게임 실패! 경험치 +10");
			this.exp += 10;
		} else {
			int plus = rand.nextInt(101) + 50;
			this.exp += plus;
			System.out.println(this.name + " 게임 성공! 경험치 +" + plus);
		}
		if (this.exp >= this.maxExp) {
			this.levelUp();
		}
	}

	void levelUp() {
		this.level += this.exp / this.maxExp;
		this.exp = this.exp % this.maxExp;
		System.out.println(this.name + ", 레벨업!");
	}

	void printInfo() {
		System.out.println(this.name + " Lv." + this.level + "[" + this.exp + "/100]");
	}
}

public class Test02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int N = 2;
		PokeMon[] po = new PokeMon[N];

		int j = 0;
		while (true) { 
			String name;
			int level;
			String ans;
			boolean flag;
			if (j == po.length) {
				break;
			}
			flag = false;
			while (true) {
				System.out.print((j + 1) + "번째 포켓몬 이름을 입력해주세요) ");
				name = sc.next();
				while (true) {
					System.out.print(name + "으로 하시겠습니까? Y / N) ");
					ans = sc.next();
					if (!ans.equals("N") && !ans.equals("n") && !ans.equals("Y") && !ans.equals("y")) {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					if (ans.equals("N") || ans.equals("n")) {
						System.out.println("이름을 다시 입력합니다.");
						break;
					}
					flag = true;
					break;
				}
				if (flag) {
					break;
				}
				continue;
			}
			flag = false;
			while (true) {
				System.out.print((j + 1) + "번째 포켓몬 레벨을 입력해주세요) ");
				level = sc.nextInt();
				if (level < 0) {
					System.out.println("레벨은 0 이상으로 입력해주세요.");
					continue;
				}
				while (true) {
					System.out.print(level + "레벨 으로 하시겠습니까? Y / N) ");
					ans = sc.next();
					if (!ans.equals("N") && !ans.equals("n") && !ans.equals("Y") && !ans.equals("y")) {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					if (ans.equals("N") || ans.equals("n")) {
						System.out.println("레벨을 다시 입력합니다.");
						break;
					}
					flag = true;
					break;
				}
				if (flag) {
					break;
				}
				continue;
			}
			po[j++] = new PokeMon(name, level);
		}

		//	po[0] = new PokeMon("피카츄", 5);
		//	po[1] = new PokeMon("파이리", 3);
		//	po[2] = new PokeMon("꼬부기", 3);

		for (int i = 0; i < po.length; i++) {
			po[i].printInfo();
		}

		int i = 0;
		while (true) {
			po[i].printInfo();
			po[i].game();
			po[i++].printInfo();
			if(i == po.length) {
				i = 0;
			}	
		}

	}

}
