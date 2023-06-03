package class05;

// 클래스
class Book {
	// 멤버변수
	String title;
	int price;
	int cnt;
	
	Book(String title, int price) {
		this.title = title;
		this.price = price;
		this.cnt = 0;
		System.out.println(this.title + " 생성 완료!");
	}
	
	Book(String title, int price, int cnt) {
		this.title = title;
		this.price = price;
		this.cnt = cnt;
		System.out.println(this.title + " 생성 완료!");
	}
	
	void sellBook() {
		this.cnt += 10;
		System.out.println(this.title + " 판매 완료!");
	}
	
	// 메서드
	void printInfo() {
		System.out.println(this.title + "은(는) " + this.price + "원, 판매량은 " + this.cnt + "개 입니다.");
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		// 객체들
		Book b1 = new Book("어린왕자", 7800); // 선언하지 않아도 기본적으로 제공되는 생성자
		Book b2 = new Book("해리포터", 23000); // 기본(디폴트)생성자 : 인자없음
		Book b3 = new Book("데미안", 16000, 100);
		
		b1.printInfo();
		b2.printInfo();
		b3.printInfo();
		
		b1.sellBook();
		b3.sellBook();
		
		b1.printInfo();
		b2.printInfo();
		b3.printInfo();
		

	}

}
