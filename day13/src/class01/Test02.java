package class01;

public class Test02 {

	public static void main(String[] args) {
		
		int[] data = new int[3];
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
		}
		
		try {
			System.out.println(data[3]);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 인덱스는 없는 인덱스입니다.");
		} finally {
			System.out.println("예외발생여부와 무관하게 예외 발생여부와 무관하게 항상 수행되는 코드");
		}

	}

}
