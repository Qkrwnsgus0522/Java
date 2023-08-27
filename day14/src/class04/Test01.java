package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) {
		
		// 1. 파일 생성하기
		File file = new File("D:\\PJH\\resource\\test.txt");
		// 해당 파일이 존재하지않으면, 새로 생성해줌!
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("파일객체생성 완료!");
		}
		
		// 2. 파일 읽어오기
		try {
			FileInputStream fis = new FileInputStream("D:\\PJH\\resource\\test.txt");
			//FileInputStream fis = new FileInputStream(file);
			
			int data;
			while ( (data = fis.read()) != -1 ) {
				// 읽어온 데이터가 -1이면 다 읽었다는 뜻
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("파일 읽어오기 작업 완료!");
		}
		
		// 3. 파일 작성하기
		try {
			FileOutputStream fos = new FileOutputStream("D:\\PJH\\resource\\test.txt");
			// 파일이 존재하지 않으면 새로 생성
			// 파일이 존재하면 덮어쓰기
//			FileOutputStream fos = new FileOutputStream("D:\\PJH\\resource\\test.txt", true);
			// 파일이 존재할 때, '이어쓰기' : ,true
			
			fos.write(65); // 'A'
			fos.write(97); // 'a' -> 아스키 코드
			
			// ★★★★★★
			// OS와 소통하던 통로를 직접 닫아주지않으면 다음 수행시 문제가 발생할수도있다!
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("fos객체로 파일 작성하기 작업 완료!");
		}
	}
}
