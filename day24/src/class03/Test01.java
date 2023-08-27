package class03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import class01.StudentVO;

public class Test01 {

	public static void main(String[] args) {
		
		// JDBC의 4가지 순서
		
		// 1. JAVA와 DB를 연결해줄 자원(resource)을 가진
		//	  클래스(==드라이버 : 서로 다른 시스템, 이종기기간의 연결을 위해 필요한 객체)를
		//	  메모리로 불러와야함 == load(적재)
		//	  위 드라이버들은 기본제공되는 클래스가 아님!
		
		//	  유지보수에 용이한 코드를 만들어내기 위해 상단에 코드로 정의하는것이 보편적
		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
		
		try {
			// static : 객체와 무관하게 불러올 수 있는 메서드
			Class.forName(driverName_MySQL);
			// 클래스명, 드라이버명
			// oracle.jdbc.driver.OracleDriver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. DB와 연결
		//	: Connection 객체가 필요하다!
		final String url_MySQL = "jdbc:mysql://localhost/jun";
		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userName = "root";
		final String passwd = "1234";
		Connection conn = null;
//		DriverManager.getConnection("jdbc:mysql://localhost/DB명", "root", "1234");
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. DB에 데이터를 작성하거나(write),
		//	  DB의 데이터를 받아오거나(read) 할 수 있음
		//	: Statement 객체를 생성하고 사용하는것이 목표!
		Statement stmt = null;
		ResultSet rs = null;
		
		// ----- VIEW 시작
		Scanner sc = new Scanner(System.in);
		int studentNum;
		while (true) {
			try {
				System.out.println("확인할 학생의 번호을 입력하세요.");
				studentNum = sc.nextInt();
				if (studentNum <= 0) {
					System.out.println("0보다 큰 정수를 입력하세요");
					continue;
				}
				break;
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수를 입력하세요!");
			}
		}
		// ----- VIEW 끝
		
		// ----- CTRL 시작
		StudentVO sVO = new StudentVO(studentNum, null, 0);
		// ----- CTRL 끝
		
		final String sql_SELECTONE = "SELECT NUM, NAME, SCORE FROM STUDENT WHERE NUM = '" + sVO.getNum() + "';";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE);
			// Query -> SELECT
			// Update -> INSERT, UPDATE, DELETE
			
			if (rs.next()) {
				// ----- CTRL 시작
				StudentVO sVO2 = new StudentVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("SCORE"));
				// ----- CTRL 끝
				
				// ----- VIEW 시작
				System.out.println(sVO2);
				System.out.println();
				// ----- VIEW 끝
			} else {
				// ----- VIEW 시작
				System.out.println("없는 학생입니다!");
				System.out.println();
				// ----- VIEW 끝
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 4. DB와 연결해제 ★
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("	로그: 프로그램종료");
	}

}
