package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	// 회원가입
	public boolean insert(MemberVO mVO) {
		final String sql_insert = "INSERT INTO MEMBER (MID, MPW) VALUES('" + mVO.getMid() +  "', '" + mVO.getMpw() + "')";
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_insert);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// StackTrace가 섞이지 않게
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}
	
	// 상품구매
	// 비번변경
	public boolean update(MemberVO mVO) {
		final String sql_update_CHANGETOTAL = "UPDATE MEMBER SET TOTAL=TOTAL+" + mVO.getTmpPrice() + " WHERE MID='" + mVO.getMid() + "'";
		final String sql_update_CHANGEMPW = "UPDATE MEMBER SET MPW='" + mVO.getMpw() + "' WHERE MID='" + mVO.getMid() + "'";
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			int result = 0;
			if (mVO.getTmpAction().equals("토탈변경")) {
				result = stmt.executeUpdate(sql_update_CHANGETOTAL);				
			} else if (mVO.getTmpAction().equals("비밀번호변경")) {
				result = stmt.executeUpdate(sql_update_CHANGEMPW);				
			} else {
				return false;
			}
			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// StackTrace가 섞이지 않게
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}
	
	// 회원탈퇴
	public boolean delete(MemberVO mVO) {
		final String sql_delete = "DELETE FROM MEMBER WHERE MID='" + mVO.getMid() + "'";
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql_delete);
			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// StackTrace가 섞이지 않게
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}
	
	// 기능이 없기때문에 private
	private ArrayList<MemberVO> selectAll(MemberVO mVO){
		return null;
	}
	
	// 로그인
	// 로그이웃
	public MemberVO selectOne(MemberVO mVO){
		final String sql_selectOne = "SELECT MID, MPW, TOTAL FROM MEMBER WHERE MID='" + mVO.getMid() + "' AND MPW='" + mVO.getMpw() + "'";

		MemberVO mdata = null;
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_selectOne);
			
			if(rs.next()) {
				mdata = new MemberVO(rs.getString("MID"), rs.getString("MPW"), rs.getInt("TOTAL"));
			}
		} catch (SQLException e) {
			try {
				// StackTrace가 섞이지 않게
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return mdata;
	}
}
