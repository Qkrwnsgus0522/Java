//package class05;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//// JDBC와 관련된 1, 2 => connect()
//// 4 코드를 "모듈화" => disconnect()
//// -> 별도의 클래스로 캡슐화하는 것이 더 유리함!
//// -> 공통의 로직을 별도로 클래스화하는 것
////	  == Util 클래스
//
//public class MovieDAO {
//	
//	// 이 부분을 DB로 대체
//	/*
//	private ArrayList<MovieVO> mdatas;
//
//	public MovieDAO() {
//		mdatas = new ArrayList<MovieVO>();
//	}
//	 */
//	
//	private Connection conn;
//	private Statement stmt;
//	
//	// Q. 배열리스트를 받아오는데,
//	// insert()를 그럼 1번하나요?
//	// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
//	public boolean insert(MovieVO mVO) {
//
//		// JDBC의 4가지 순서
//		// 1. 드라이버 로드
//		// 2. DB 연결
//		// 3. 데이터 read, write
//		// 4. DB 연결해제
//
//		// 1. 드라이버 로드
//		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
//		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
//
//		// 유지보수 용이
//		try {
//			Class.forName(driverName_MySQL);
//			// 클래스명, 드라이버명
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 2. DB 연결
//		//	: Connection 객체인 conn를 생성하는 것이 목표!
//		final String url_MySQL = "jdbc:mysql://localhost/jun";
//		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
//		final String userName = "root";
//		final String passwd = "1234";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
//			// conn 객체는 DB와의 연결통로 역할!
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 3. 데이터 read, write
//		//	: Statement 객체를 생성하고 사용하는것이 목표!
//		Statement stmt = null;
//		final String sql_INSERT = "INSERT INTO MOVIE (NAME, ODATE) VALUES('" + mVO.getName() + "', '" + mVO.getOdate() + "');";
//
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql_INSERT);
//			// Query -> SELECT
//			// Update -> INSERT, UPDATE, DELETE
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 4. DB 연결해제
//		try {
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//
//	public boolean update(MovieVO mVO) {
//
//		// JDBC의 4가지 순서
//		// 1. 드라이버 로드
//		// 2. DB 연결
//		// 3. 데이터 read, write
//		// 4. DB 연결해제
//
//		// 1. 드라이버 로드
//		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
//		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
//
//		// 유지보수 용이
//		try {
//			Class.forName(driverName_MySQL);
//			// 클래스명, 드라이버명
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 2. DB 연결
//		//	: Connection 객체인 conn를 생성하는 것이 목표!
//		final String url_MySQL = "jdbc:mysql://localhost/jun";
//		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
//		final String userName = "root";
//		final String passwd = "1234";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
//			// conn 객체는 DB와의 연결통로 역할!
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 3. 데이터 read, write
//		//	: Statement 객체를 생성하고 사용하는것이 목표!
//		Statement stmt = null;
//
//		String sql_UPDATE = "";
//		if (mVO.getOdate() == null) { // 영화제목 변경
//			sql_UPDATE = "UPDATE MOVIE SET NAME = '" + mVO.getOdate() + "' WHERE NAME = '" + mVO.getName() + "';";			
//		} else if (mVO.getName() == null) { // 개봉날짜 변경
//			sql_UPDATE = "UPDATE MOVIE SET ODATE = '" + mVO.getOdate() + "' WHERE NAME = '" + mVO.getName() + "';";
//		}
//
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql_UPDATE);
//			// Query -> SELECT
//			// Update -> INSERT, UPDATE, DELETE
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 4. DB 연결해제
//		try {
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//
//	public boolean delete(MovieVO mVO) {
//
//		// JDBC의 4가지 순서
//		// 1. 드라이버 로드
//		// 2. DB 연결
//		// 3. 데이터 read, write
//		// 4. DB 연결해제
//
//		// 1. 드라이버 로드
//		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
//		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
//
//		// 유지보수 용이
//		try {
//			Class.forName(driverName_MySQL);
//			// 클래스명, 드라이버명
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 2. DB 연결
//		//	: Connection 객체인 conn를 생성하는 것이 목표!
//		final String url_MySQL = "jdbc:mysql://localhost/jun";
//		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
//		final String userName = "root";
//		final String passwd = "1234";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
//			// conn 객체는 DB와의 연결통로 역할!
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 3. 데이터 read, write
//		//	: Statement 객체를 생성하고 사용하는것이 목표!
//		Statement stmt = null;
//		final String sql_DELETE = "DELETE FROM MOVIE WHERE NAME = '" + mVO.getName() + "';";
//
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql_DELETE);
//			// Query -> SELECT
//			// Update -> INSERT, UPDATE, DELETE
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//		// 4. DB 연결해제
//		try {
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//
//	public ArrayList<MovieVO> selectAll(MovieVO mVO) {
//
//		// JDBC의 4가지 순서
//		// 1. 드라이버 로드
//		// 2. DB 연결
//		// 3. 데이터 read, write
//		// 4. DB 연결해제
//
//		// 1. 드라이버 로드
//		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
//		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
//
//		// 유지보수 용이
//		try {
//			Class.forName(driverName_MySQL);
//			// 클래스명, 드라이버명
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 2. DB 연결
//		//	: Connection 객체인 conn를 생성하는 것이 목표!
//		final String url_MySQL = "jdbc:mysql://localhost/jun";
//		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
//		final String userName = "root";
//		final String passwd = "1234";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
//			// conn 객체는 DB와의 연결통로 역할!
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 3. 데이터 read, write
//		//	: Statement 객체를 생성하고 사용하는것이 목표!
//		Statement stmt = null;
//		ResultSet rs = null;
//		ArrayList<MovieVO> mdatas = new ArrayList<MovieVO>();
//
//		final String sql_SELECTALL = "SELECT NUM, NAME, ODATE FROM MOVIE;";
//
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql_SELECTALL);
//
//			while (rs.next()) {
//				MovieVO mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
//				mdatas.add(mdata);
//			}
//			// Query -> SELECT
//			// Update -> INSERT, UPDATE, DELETE
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 4. DB 연결해제
//		try {
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return mdatas;
//	}
//
//	public MovieVO selectOne(MovieVO mVO) {
//
//		// JDBC의 4가지 순서
//		// 1. 드라이버 로드
//		// 2. DB 연결
//		// 3. 데이터 read, write
//		// 4. DB 연결해제
//
//		// 1. 드라이버 로드
//		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
//		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
//
//		// 유지보수 용이
//		try {
//			Class.forName(driverName_MySQL);
//			// 클래스명, 드라이버명
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 2. DB 연결
//		//	: Connection 객체인 conn를 생성하는 것이 목표!
//		final String url_MySQL = "jdbc:mysql://localhost/jun";
//		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
//		final String userName = "root";
//		final String passwd = "1234";
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
//			// conn 객체는 DB와의 연결통로 역할!
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 3. 데이터 read, write
//		//	: Statement 객체를 생성하고 사용하는것이 목표!
//		Statement stmt = null;
//		ResultSet rs = null;
//		MovieVO mdata = null;
//		String sql_SELECTONE = "";
//		
//		if (mVO.getOdate().equals("번호검색")) {
//			sql_SELECTONE = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NUM = " + mVO.getNum() + ";";
//		} else if (mVO.getOdate().equals("제목검색")) {
//			sql_SELECTONE = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NAME = " + mVO.getName() + ";";
//		}
//
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql_SELECTONE);
//
//			if (rs.next()) {
//				mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
//				return mdata;
//			}
//			// Query -> SELECT
//			// Update -> INSERT, UPDATE, DELETE
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		// 4. DB 연결해제
//		try {
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return null;
//	}
//}
