package class06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// "사진 복사하기"
public class Test01 {

	public static void main(String[] args) {
		
		final String path = "D:\\\\PJH\\\\resource\\\\";
//		final String fileName = "test.png";
//		final String fileCopy = "test - 복사본.png";
		final String fileName = "default.jpg";
		final String fileCopy = "default - 복사본.jpg";
		
		try {
			FileInputStream fis = new FileInputStream(path + fileName);
			FileOutputStream fos = new FileOutputStream(path + fileCopy);
			
			int data;
			// 사진 버퍼 공간
			byte[] buff = new byte[10000];
			while ((data = fis.read(buff)) != -1) {
//				System.out.println("확인");
				fos.write(buff, 0, data);
			}
			
			fos.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
