package class06;

import java.util.Random;

class Animal {
	
	String name; // 이름
	int age; // 나이
	String voice; // 울음소리
	int playTime; // 산책시간
	int feedCnt; // 배고픔
	final static int maxPlayTime = 6;
	final static int maxFeedCnt = 4;
	static Random rand = new Random();
	
	Animal() {
		this("동물", 0, "울음소리");
	}
	
	Animal(String name) {
		this(name, 1, "울음소리");
	}
	
	Animal(String name, String voice) {
		this(name, 1, voice);
	}
	
	Animal(String name, int age, String voice) {
		this.name = name;
		this.age = age;
		this.voice = voice;
		this.playTime = 0;
		this.feedCnt = 0;
	}
	
	void walk() {
		play();
		warningPlay();
	}
	
	void play() {
		this.playTime += ( rand.nextInt(2) + 1 );
	}
	
	void warningPlay() {
		if (this.playTime >= maxPlayTime) {
			System.out.println(this.name + "은(는) 휴식이 필요합니다.");
			this.playTime = maxPlayTime;
		}
	}
	
	void doFeed() {
		feed();
		warningFeed();
	}
	
	void feed() {
		this.feedCnt += ( rand.nextInt(2) + 1 );
	}
	
	void warningFeed() {
		if (this.feedCnt >= maxFeedCnt) {
			System.out.println(this.name + "은(는) 과식 하였습니다.");
			this.feedCnt = maxFeedCnt;
		}
	}
	
	void printInfo() {
		System.out.println("이름 : " + this.name + " / 나이 : " + this.age + " / 소리 : " + this.voice + " / 산책시간 : [" + this.playTime + "/" + maxPlayTime + "] / 게이지 : " + this.feedCnt);
	}
	
}

class Dog extends Animal {
	
	Dog() {
		this(1);
	}
	
	Dog(int age) {
		super("강아지");
		this.age = age;
		this.voice = "멍멍";
	}
	
	void walk() {
		play();
		warningPlay();
	}
	
	void doFeed() {
		feed();
		warningFeed();
	}
}

class Cat extends Animal {
	
	Cat() {
		this(1);
	}
	
	Cat(int age) {
		super("고양이");
		this.age = age;
		this.voice = "야옹";
	}
	
	void walk() {
		play();
		warningPlay();
	}
	
	void doFeed() {
		feed();
		warningFeed();
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Animal[] a = new Animal[2];
		a[0] = new Animal();
		a[1] = new Animal("사자", "어흥");
		Dog[] d = new Dog[2];
		d[0] = new Dog();
		d[1] = new Dog(5);
		Cat[] c = new Cat[2];
		c[0] = new Cat();
		c[1] = new Cat(3);

		for (int i = 0; i < 2; i++) {
			a[i].printInfo();
			d[i].printInfo();
			c[i].printInfo();
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				a[i].walk();
				d[i].walk();
				c[i].walk();
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				a[i].doFeed();
				d[i].doFeed();
				c[i].doFeed();
			}
		}
		
		for (int i = 0; i < 2; i++) {
			a[i].printInfo();
			d[i].printInfo();
			c[i].printInfo();
		}


	}

}
