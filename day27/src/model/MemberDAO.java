package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 자바 개입이 없는 코드를 상단 배치함으로써 응집도 ↑
	static final String sql_insert = "INSERT INTO MEMBER (MID, MPW) VALUES(?. ?)";
	static final String sql_update_CHANGETOTAL = "UPDATE MEMBER SET TOTAL=TOTAL+? WHERE MID=?";
	static final String sql_update_CHANGEMPW = "UPDATE MEMBER SET MPW=? WHERE MID=?";
	static final String sql_delete = "DELETE FROM MEMBER WHERE MID=?";
	static final String sql_selectOne = "SELECT MID, MPW, TOTAL FROM MEMBER WHERE MID=? AND MPW=?";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 회원가입
	public boolean insert(MemberVO mVO) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, mVO.getMid()); // [1]로 시작함!!!!!
			pstmt.setString(2, mVO.getMpw());
			pstmt.executeUpdate();
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
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	// 상품구매
	// 비번변경
	public boolean update(MemberVO mVO) {
		
		
		conn = JDBCUtil.connect();
		try {
			if (mVO.getTmpAction().equals("토탈변경")) {
				pstmt = conn.prepareStatement(sql_update_CHANGETOTAL);	
				pstmt.setInt(1, mVO.getTmpPrice());
				pstmt.setString(2, mVO.getMid());
			} else if (mVO.getTmpAction().equals("비밀번호변경")) {
				pstmt = conn.prepareStatement(sql_update_CHANGEMPW);
				pstmt.setString(1, mVO.getMpw());
				pstmt.setString(2, mVO.getMid());
			} else {
				return false;
			}
			int result = pstmt.executeUpdate();
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
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	// 회원탈퇴
	public boolean delete(MemberVO mVO) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, mVO.getMid());
			int result = pstmt.executeUpdate();
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
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	// 기능이 없기때문에 private
	private ArrayList<MemberVO> selectAll(MemberVO mVO){
		return null;
	}
	
	// 로그인
	// 로그이웃
	public MemberVO selectOne(MemberVO mVO){
		MemberVO mdata = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			rs = pstmt.executeQuery();
			
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
