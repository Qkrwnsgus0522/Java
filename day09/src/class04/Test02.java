package class04;

import java.util.Random;

class Pokemon {
	String name;
	int exp;
	int lv;
	final static int maxExp = 100;
	
	Pokemon(String name) {
		Random rand = new Random();
		this.name = name;
		this.exp = rand.nextInt(11); // 0 ~ 10 랜덤
		this.lv = rand.nextInt(6); // 0 ~ 5 랜덤
	}
	
	void game() {
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		if (randNum == 1) {
			this.win();
		} else {
			this.lose();
		}
		this.calLvExp();
	}
	
	void talk(String str) {
		System.out.println(str);
	}
	
	void print() {
		System.out.println(this.name + "은(는) Lv." + this.lv + " [" + this.exp + "/" + Pokemon.maxExp + "]");
	}
	
	void calLvExp() {
		if (this.exp >= 100) {
			this.lv += this.exp / Pokemon.maxExp;
			this.exp = this.exp % Pokemon.maxExp;
			System.out.println(this.name + " LV UP!");
		}
	}
	
	void win() {
		Random rand = new Random();
		this.exp += rand.nextInt(41) + 10; // 10 ~ 50 랜덤 상승
	}
	
	void lose() {
		Random rand = new Random();
		this.exp += 10; // 10 상승
	}
}

class Pikachu extends Pokemon {

	Pikachu() {
		super("피카츄");
	}
	
	// 오버라이딩
	void game() {
		this.win();
		this.calLvExp();
	}
	
	void talk() {
		this.talk("피카피카");
	}
	
}

class Pyree extends Pokemon {

	Pyree() {
		super("파이리");
	}
	
	// 오버라이딩
	void game() {
		Random rand = new Random();
		int randNum = rand.nextInt(5) + 1;
		if (randNum == 1) {
			this.win();
		} else {
			this.lose();
		}
		this.calLvExp();
	}
	
	void talk() {
		this.talk("파이파이");
	}
	
}

public class Test02 {

	public static void main(String[] args) {
		
		Pikachu pika1 = new Pikachu();
		Pikachu pika2 = new Pikachu();
		Pyree py = new Pyree();
		
		pika1.print();
		pika2.print();
		py.print();
		
		for (int i = 0; i < 10; i++) {
			pika1.game();
			pika2.game();
			py.game();
		}
		
		pika1.print();
		pika2.print();
		py.print();
		
		pika1.talk();
		pika2.talk();
		py.talk();
	}

}
