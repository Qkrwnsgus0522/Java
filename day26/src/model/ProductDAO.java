package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public boolean insert(ProductVO pVO) {
		return false;
	}
	
	// 상품구매
	public boolean update(ProductVO pVO) {
		final String sql_update = "UPDATE PRODUCT SET CNT=CNT-1 WHERE NUM=" + pVO.getNum();
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql_update);
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
		JDBCUtil.disconnect(rs, stmt, conn);
		return true;
	}
	
	public boolean delete(ProductVO pVO) {
		return false;
	}
	
	// 상품목록출력
	// 상품검색
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		// 상수화 선언
		final String sql_selectAll_NAME = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NAME LIKE '%" + pVO.getName() + "%'";			
		final String sql_selectAll_PRICE = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE PRICE BETWEEN " + pVO.getCnt() + " AND " + pVO.getPrice();			
		final String sql_selectAll_All = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NAME LIKE '%" + pVO.getName() + "%' AND PRICE BETWEEN " + pVO.getCnt() + " AND " + pVO.getPrice();		
		// 1. 자원로드
		// 2. DB연결
		// 3. rw
		// 4. DB연결해제
		ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			// 여기서 분류
			if (pVO.getTmpSearchCondition().equals("이름")) {
				rs = stmt.executeQuery(sql_selectAll_NAME);				
			} else if (pVO.getTmpSearchCondition().equals("가격")) {
				rs = stmt.executeQuery(sql_selectAll_PRICE);
			} else if (pVO.getTmpSearchCondition().equals("이름가격")) {
				rs = stmt.executeQuery(sql_selectAll_All);
			} else {
				return pdatas;
			}
			while(rs.next()) {
				pdatas.add(new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pdatas;
		}
		JDBCUtil.disconnect(rs, stmt, conn); 
		return pdatas;
	}
	
	// 상품선택(상품구매 시)
	public ProductVO selectOne(ProductVO pVO){
		final String sql_selectOne = "SELECT NUM, NAME, CNT, PRICE FROM PRODUCT WHERE NUM=" + pVO.getNum();
		// 1. 자원로드
		// 2. DB연결
		// 3. rw
		// 4. DB연결해제
		ProductVO pdata = null;
		
		conn = JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_selectOne);
		
			if(rs.next()) {
				pdata = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("CNT"), rs.getInt("PRICE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		JDBCUtil.disconnect(rs, stmt, conn); 
		return pdata;
	}
}
