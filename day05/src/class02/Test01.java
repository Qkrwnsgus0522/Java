package class02;

import java.util.Arrays;

public class Test01 {

	public static void func1(int num) {
		num += 100;
	}
	public static int func2(int num) {
		return num--;
	}
	public static void func3(int[] arr) {
		// 함수를 호출할때에 인자로 배열을 사용하는 경우,
		// (배열 특성상 주소값이 이동하기때문에)
		// 참조에 의한 호출(call by reference)
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 123;
		}
	}
	
	public static void main(String[] args) {
		
		int num = 10;
		int[] data = new int[3];
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1; // [ 1, 2, 3 ]
		}
		
		System.out.println("data= " + Arrays.toString(data));
		func1(num);
		System.out.println("num1= " + num); // 10
		func2(num);
		System.out.println("num2= " + num); // 10
		func3(data);
		System.out.print("data= [ ");
		for (int v : data) {
			System.out.print(v + " ");
		}
		System.out.println("]");
	}

}
