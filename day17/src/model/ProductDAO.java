package model;

import java.util.ArrayList;

// 목록출력,목록검색_이름,목록검색_가격순,목록검색_조회수
public class ProductDAO {
	private ArrayList<ProductVO> datas;
	private static int PK=1001;
	public ProductDAO() {
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO(PK++,"장갑",12000,2));
		datas.add(new ProductVO(PK++,"화장지",1000,1));
		datas.add(new ProductVO(PK++,"장화",23000,0));
		datas.add(new ProductVO(PK++,"지갑",120000,1));
		datas.add(new ProductVO(PK++,"화분",5500,2));
	}
	
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		// 높은 응집도를 위해
		// 여러기능을 하나의 메서드에서 작성
		if (pVO == null) {
			return datas;
		} else if (pVO.getName().equals("expensive")) {
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
			for (ProductVO data : datas) {
				if (data.getPrice() > pVO.getPrice()) {
					mdatas.add(data);
				}
			}
			return mdatas;
		} else if (pVO.getName().equals("cheap")) {
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
			for (ProductVO data : datas) {
				if (data.getPrice() < pVO.getPrice()) {
					mdatas.add(data);
				}
			}
			return mdatas;
		} else if (pVO.getName().equals("filter")) { // searchCondition
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
			for (ProductVO data : datas) {
				if (data.getPrice() > pVO.getPrice() && data.getPrice() < pVO.getCnt()) {
					mdatas.add(data);
				}
			}
			return mdatas;
		} else {
		// 상품목록출력을 할때에는 인자(pVO)가 null이므로
		// pVO가 null이 아니라면 이름으로 검색임!
			ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
			for (ProductVO data : datas) {
				if (data.getName().contains(pVO.getName())) {
					// pVO.getName() == 사용자가 검색한 단어
					mdatas.add(data);
				}
			}
			return mdatas;
		}
	}
	public ProductVO selectOne(ProductVO pVO){
		if (pVO.getName().equals("expensive")) {
			int max = datas.get(0).getPrice();
			int maxIndex = 0;
			for (int i = 1; i < datas.size(); i++) {
				if (max < datas.get(i).getPrice()) {
					max = datas.get(i).getPrice();
					maxIndex = i;
				}
			}
			return datas.get(maxIndex);
		} else if (pVO.getName().equals("cheap")) {
			int minIndex = 0;
			for (int i = 1; i < datas.size(); i++) {
				if (datas.get(minIndex).getPrice() > datas.get(i).getPrice()) {
					minIndex = i;
				}
			}
			return datas.get(minIndex);
		} else {
			return pVO;
		}
	}
	public boolean insert(ProductVO pVO) {
		return true;
	}
	public boolean update(ProductVO pVO) {
		return true;
	}
	public boolean delete(ProductVO pVO) {
		return true;
	}
}
