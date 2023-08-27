package class02;

class Family extends Thread {
	Account account = new Account();
	
	
	
	
	///////////////////////
	@Override
	public void run() {
		account.pay();
	}
}

class Account {
	static int money = 20000;
	
	synchronized void pay() {
		if (money >= 6000) {
			System.out.println(Thread.currentThread().getName() + " 인출성공!");
			money -= 6000;
		} else {
			System.out.println(Thread.currentThread().getName() + " 인출실패...");
		}
		System.out.println("남은금액: " + money);
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		Family f = new Family();
		Thread t1 = new Thread(f, "엄마");
		Thread t2 = new Thread(f, "아빠");
		Thread t3 = new Thread(f, "동생");
		Thread t4 = new Thread(f, "누나");
		Thread t5 = new Thread(f, "나");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
