package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC와 관련된 1, 2 => connect()
//4 코드를 "모듈화" => disconnect()
//-> 별도의 클래스로 캡슐화하는 것이 더 유리함!

//-> 공통의 로직을 별도로 클래스화하는 것
//	  == Util 클래스

// 장점
//	: 코드 재사용성이 증가
//	: 중복코드 최소화
//	: 오류의 파급효과 줄어듦
//	: 유지보수 용이
//	: 개발 시간, 비용 단축
//	: 영업이익증가

public class JDBCUtil {
	
	// 권한측정 일시정지 흐름제어 등 connect 메소드 이외에도 자주 사용할 가능성이 있기 때문에 상단에 선언
	static final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
	static final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
	static final String url_MySQL = "jdbc:mysql://localhost/jun";
	static final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String userName = "root";
	static final String passwd = "1234";

	public static Connection connect() {
		
		Connection conn = null;
		
		try {
			Class.forName(driverName_MySQL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void disconnect(Statement stmt, Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect(ResultSet rs, Statement stmt, Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
