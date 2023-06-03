package class03;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
	private int num; // PK
	private String name; // 이름
	private int price; // 가격
	private int cnt; // 재고
	
	Product(int num, String name, int price, int cnt) { // 상품 추가
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		System.out.println(this.name + "상품이 추가되었습니다.");
	}

	void sell(int cnt) { // 상품 구매
		this.cnt -= cnt;
		System.out.println(this.name + " " + cnt + "개 총가격 : " + this.price * cnt + "원 구매완료!");
	}
	
	void changeCnt(int cnt) { // 상품 재고 변경
		this.cnt += cnt;
		System.out.println(this.name + " 상품 재고가" + cnt + "개 추가되었습니다.");
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() { // 상품 정보
		if (this.cnt == 0) { // 재고가 0개 일때
			return "상품번호 : " + this.num + " " + this.name + " " + this.price + "원 재고 : [품절]";
		}
		return "상품번호 : " + this.num + " " + this.name + " " + this.price + "원 재고 : " + this.cnt + "개";
	}

}

public class Test01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> data = new ArrayList<Product>();
		
		int pkNum = 101; // 상품번호 101번부터 순서대로 부여
		int action; // 입력할 메뉴 번호
		int num; // 상품 번호
		String name; // 상품 이름
		int price; // 상품 가격
		int cnt; // 상품 재고
		
		// 사용자 메뉴
		String menu = "===============\n"
					+ "1. 상품목록출력\n"
					+ "2. 구매하기\n"
					+ "3. 프로그램종료\n"
					+ "===============";
		
		// 관리자 메뉴
		String adminMenu = "===============\n"
						 + "1. 상품추가\n"
						 + "2. 상품재고변경\n"
						 + "3. 상품삭제\n"
						 + "4. 관리자모드종료\n"
						 + "===============";
		
		data.add(new Product(pkNum++, "새우깡", 2500, 17));
		data.add(new Product(pkNum++, "감자깡", 3400, 43));
		data.add(new Product(pkNum++, "칙촉", 1700, 26));
		data.add(new Product(pkNum++, "빈츠", 2100, 12));
		data.add(new Product(pkNum++, "콜라", 3700, 0));
		
		while (true) {
			System.out.println(menu); // 사용자메뉴 출력
			System.out.print("입력) ");
			action = sc.nextInt();
			if (action == 1) { // 1번 입력시 상품목록출력
				for (Product product : data) {
					System.out.println(product);
				}
			} else if (action == 2) { // 2번 입력시 상품구매
				System.out.print("구매하실 상품 번호를 입력해주세요.) ");
				num = sc.nextInt();
				System.out.print("구매하실 상품 수량을 입력해주세요.) ");
				cnt = sc.nextInt();
				for (Product product : data) {
					if (num == product.getNum()) { // num이 data에 있는 상품 번호와 같으면
						product.sell(cnt); // 상품 구매
						break;
					}
				}
			} else if (action == 1234) { // 1234 입력시 관리자메뉴로 이동
				System.out.println("관리자모드로 이동합니다.");
				while (true) {
					System.out.println(adminMenu); // 관리자메뉴 출력
					System.out.print("입력) ");
					action = sc.nextInt();
					if (action == 1) { // 1번 입력시 상품추가
						System.out.print("추가할 상품 이름을 입력해주세요) ");
						name = sc.next(); // 상품 이름
						System.out.print("추가할 상품 가격을 입력해주세요) ");
						price = sc.nextInt(); // 상품 가격
						System.out.print("추가할 상품 재고를 입력해주세요) ");
						cnt = sc.nextInt(); // 상품 재고
						data.add(new Product(pkNum++, name, price, cnt)); // 상품 생성시 pkNum 증가
					} else if (action == 2) { // 2번 입력시 상품재고변경
						System.out.print("재고를 변경할 상품 번호를 입력해주세요) ");
						num = sc.nextInt(); // 상품 번호
						for (Product product : data) {
							if (num == product.getNum()) { // num이 data에 있는 상품 번호와 같으면
								System.out.println(product);
								System.out.print("추가할 수량을 입력해주세요) ");
								cnt = sc.nextInt(); // 추가 수량
								product.changeCnt(cnt); // 수량 변경
								break;
							}
						}
					} else if (action == 3) { // 3번 입력시 상품삭제
						System.out.print("삭제할 상품 번호를 입력해주세요) ");
						num = sc.nextInt(); // 상품 번호
						for (int i = 0; i < data.size(); i++) {
							if (num == data.get(i).getNum()) { // num이 data에 있는 상품 번호와 같으면
								// 상품 삭제 전 해당 index에 있는 값이 바뀌기 전에 출력
								System.out.println(data.get(i).getName() + " 상품이 삭제되었습니다.");
								data.remove(i); // 상품 삭제
								break;
							}
						}
					} else { // 4번 입력시 관리자모드 종료
						System.out.println("사용자모드로 이동합니다.");
						break;
					}
				}
			} else if (action == 3) { // 3번 입력시 프로그램종료
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
		
	}
	
}

