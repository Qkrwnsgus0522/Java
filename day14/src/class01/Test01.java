package class01;

// 이미 JAVA에서 구현한 Thread 클래스를 가져다가 사용
// 코드를 재사용할 예정
// => 상속
class Th01 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Thread 01 " + i);
		}
	}
	
}

class Th02 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Thread 02 " + i);
		}
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Th01 t1 = new Th01(); // 생성
		// 생성이되면, 즉시 대기상태가 됨
		Th02 t2 = new Th02();
		
//		Thread t3 = new Thread();
		
		t1.start(); // 스레드 객체야, 일해!
		t2.start(); //	-> run()메서드를 실행시킴
		// 메모리를 먼저 할당받는 쪽이 먼저 실행
		
		// start()로 인해 run()을 수행하게되고,
		// 주어진 run()을 다 수행하게되면
		// 데드상태가 됨
		
		// 스레드 객체들은 현재 독립적으로 일을 수행하고있구나!
		
//		5개 남은 상품
//		t1(사용자1) -> 장바구니에 3개담음
//		t2(사용자2) => 5개를 즉시 구매
		
		// 스레드 생명주기(라이프사이클)
		// 생성 -> 대기 -> 수행 -> 데드
		// 블록 : 자원(메모리)을 할당받지 못하도록 막아둔상태
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1000 == 1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
