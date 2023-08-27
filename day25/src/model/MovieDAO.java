package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// JDBC와 관련된 1, 2 => connect()
// 4 코드를 "모듈화" => disconnect()
// -> 별도의 클래스로 캡슐화하는 것이 더 유리함!
// -> 공통의 로직을 별도로 클래스화하는 것
//	  == Util 클래스

public class MovieDAO {
	
	// 이 부분을 DB로 대체
	/*
	private ArrayList<MovieVO> mdatas;

	public MovieDAO() {
		mdatas = new ArrayList<MovieVO>();
	}
	 */
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	// Q. 배열리스트를 받아오는데,
	// insert()를 그럼 1번하나요?
	// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
	public boolean insert(MovieVO mVO) {

		conn = JDBCUtil.connect();

		final String sql_INSERT = "INSERT INTO MOVIE (NAME, ODATE) VALUES('" + mVO.getName() + "', '" + mVO.getOdate() + "');";

		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql_INSERT);
			
			if (result <= 0) {
				// 적용된 row가 없음
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);			
		}
		
		return true;
	}

	public boolean update(MovieVO mVO) {

		conn = JDBCUtil.connect();

		String sql_UPDATE = "";
		if (mVO.getOdate() == null) { // 영화제목 변경
			sql_UPDATE = "UPDATE MOVIE SET NAME = '" + mVO.getName() + "' WHERE NUM = '" + mVO.getNum() + "';";			
		} else if (mVO.getName() == null) { // 개봉날짜 변경
			sql_UPDATE = "UPDATE MOVIE SET ODATE = '" + mVO.getOdate() + "' WHERE NUM = '" + mVO.getNum() + "';";
		}

		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql_UPDATE);
			
			if (result <= 0) {
				// 적용된 row가 없음
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);			
		}
		
		return true;
	}

	public boolean delete(MovieVO mVO) {

		conn = JDBCUtil.connect();

		final String sql_DELETE = "DELETE FROM MOVIE WHERE NUM = '" + mVO.getNum() + "';";

		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql_DELETE);
			
			if (result <= 0) {
				// 적용된 row가 없음
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);			
		}
		
		return true;
	}

	public ArrayList<MovieVO> selectAll(MovieVO mVO) {

		conn = JDBCUtil.connect();
		
		final String sql_SELECTALL = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NAME like '%" + mVO.getName() + "%';";
		
		ArrayList<MovieVO> mdatas = new ArrayList<MovieVO>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTALL);

			while (rs.next()) {
				MovieVO mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
				mdatas.add(mdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(rs, stmt, conn);			
		}
		
		return mdatas;
	}

	public MovieVO selectOne(MovieVO mVO) {

		conn = JDBCUtil.connect();

		MovieVO mdata = null;
		
		final String sql_SELECTONE = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NUM = " + mVO.getNum() + ";";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE);

			if (rs.next()) {
				mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
				return mdata;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(rs, stmt, conn);			
		}
		
		return null;
	}
}
