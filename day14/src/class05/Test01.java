package class05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) {
		
		// "유지보수 용이"
		final String path_START = "D:\\PJH\\resource\\";
		final String path_FILE01 = "test01";
		final String path_FILE02 = "test02";
		final String path_END = ".txt";
		
		// 파일 생성하기
		File file1 = new File("D:\\PJH\\resource\\test01.txt");
		File file2 = new File("D:\\PJH\\resource\\test02.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("파일 생성완료!");
		}
		
		// 파일 작성하기
		try {
			FileOutputStream fos1 = new FileOutputStream("D:\\PJH\\resource\\test01.txt");
			FileOutputStream fos2 = new FileOutputStream("D:\\PJH\\resource\\test02.txt");
			
			//   문자    0 ~ 9
			// 아스키코드 48 ~ 57
			
			fos1.write(51);
			fos1.write(53);
			
			int i = 'a';
			while (i <= 'z') {
				fos2.write(i);
				i++;
			}
			
			fos2.flush();
			fos2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("파일 작성완료!");
		}
		
		// 파일 읽어오기
		try {
			FileInputStream fis1 = new FileInputStream("D:\\PJH\\resource\\test01.txt");
			FileInputStream fis2 = new FileInputStream("D:\\PJH\\resource\\test02.txt");
			
			int data;
			boolean flag = false;
			while ((data = fis1.read()) != -1) {
				flag = data % 2 == 0 ? true : false;
			}
			if (flag) {
				System.out.println("입력되어있는 정수는 짝수입니다.");
			} else {
				System.out.println("입력되어있는 정수는 홀수입니다.");
			}
			
			while ((data = fis2.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("파일 읽기완료!");
		}
		
	}

}
