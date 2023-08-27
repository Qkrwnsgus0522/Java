package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	
	static final String sql_update = "UPDATE PRODUCT SET CNT=CNT-1 WHERE NUM=?"; 
	static final String sql_selectAll_NAME = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NAME LIKE CONCAT('%', ?, '%')";			
	static final String sql_selectAll_PRICE = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE PRICE BETWEEN ? AND ?";			
	static final String sql_selectAll_All = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NAME LIKE CONCAT('%', ?, '%') AND PRICE BETWEEN ? AND ?";
	static final String sql_selectOne = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NUM=?";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean insert(ProductVO pVO) {
		return false;
	}
	
	// 상품구매
	public boolean update(ProductVO pVO) {
		
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, pVO.getNum());
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
		JDBCUtil.disconnect(rs, pstmt, conn);
		return true;
	}
	
	public boolean delete(ProductVO pVO) {
		return false;
	}
	
	// 상품목록출력
	// 상품검색
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
				
		// 1. 자원로드
		// 2. DB연결
		// 3. rw
		// 4. DB연결해제
		ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
		conn = JDBCUtil.connect();
		try {
			// 여기서 분류
			if (pVO.getTmpSearchCondition().equals("이름")) {
				pstmt = conn.prepareStatement(sql_selectAll_NAME);	
				pstmt.setString(1, pVO.getName());
			} else if (pVO.getTmpSearchCondition().equals("가격")) {
				pstmt = conn.prepareStatement(sql_selectAll_PRICE);
				pstmt.setInt(1, pVO.getCnt());
				pstmt.setInt(2, pVO.getPrice());
			} else if (pVO.getTmpSearchCondition().equals("이름가격")) {
				pstmt = conn.prepareStatement(sql_selectAll_All);
				pstmt.setString(1, pVO.getName());
				pstmt.setInt(2, pVO.getCnt());
				pstmt.setInt(3, pVO.getPrice());
			} else {
				return pdatas;
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pdatas.add(new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pdatas;
		}
		JDBCUtil.disconnect(rs, pstmt, conn); 
		return pdatas;
	}
	
	// 상품선택(상품구매 시)
	public ProductVO selectOne(ProductVO pVO){
		
		// 1. 자원로드
		// 2. DB연결
		// 3. rw
		// 4. DB연결해제
		ProductVO pdata = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, pVO.getNum());
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				pdata = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		JDBCUtil.disconnect(rs, pstmt, conn); 
		return pdata;
	}
}
