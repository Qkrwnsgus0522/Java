package class08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Test02 {
	public static void main(String[] args) {

		ArrayList<MovieVO> mdatas=Test01.sample();
		//////////////////////////////////////////////////

		final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle="oracle.jdbc.driver.OracleDriver";
		// 유지보수 용이
		try {
			Class.forName(driverName_MySQL);
			// 클래스명,드라이버명
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. DB와 연결
		//  : Connection 객체가 필요하다!
		final String url_MySQL="jdbc:mysql://localhost/kim";
		final String url_Oracle="jdbc:oracle:thin:@localhost:1521:xe";
		final String userName="root";
		final String passwd="1234";
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url_MySQL, userName, passwd);
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. DB에 데이터를 작성하거나(write),
		//    DB의 데이터를 받아오거나(read) 할 수 있음
		//  : Statement 객체를 생성하고, 사용하는것이 목표!
		Statement stmt=null;


		for(MovieVO v:mdatas) {

	
			final String sql_INSERT="INSERT INTO MOVIE (NAME,ODATE) VALUES('"+v.getName()+"','"+v.getOdate()+"');";

			try {
				stmt=conn.createStatement();
				stmt.executeUpdate(sql_INSERT);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}


		//////////////////////////////////////////////////




		ResultSet rs=null;
		final String sql_SELECTALL="SELECT NUM,NAME,ODATE FROM MOVIE;";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql_SELECTALL);

			while(rs.next()) {
				// --- CTRL 시작
				MovieVO mVO=new MovieVO(rs.getInt("NUM"),rs.getString("NAME"),rs.getString("ODATE"));
				// --- CTRL 끝

				// --- VIEW 시작
				System.out.println(mVO);
				System.out.println();
				// --- VIEW 끝
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(" 로그: 프로그램 종료");





	}
}
