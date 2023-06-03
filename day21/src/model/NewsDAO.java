package model;

import java.util.ArrayList;
import java.util.Arrays;

public class NewsDAO {
	// 필드===========================================================
	private ArrayList<NewsVO> datas;// VO 정보를 담는 ArrayList

	// 생성자==========================================================
	public NewsDAO() {
		//      this.datas = new ArrayList<NewsVO>();
		this.datas = Crawling.sample();
	}

	// 메서드=========================================================
	// R
	public ArrayList<NewsVO> selectAll(NewsVO mVO) {
		if (mVO == null) {// 전체 목록 출력
			return datas;
		}else if(mVO.getTitle()!= null) {

			if (mVO.getTitle().equals("랭킹순위")) {// 랭킹 순위 검색

				NewsVO[] arr = new NewsVO[datas.size()];
				
				for (int i = 0; i < datas.size(); i++) {
					arr[i] = datas.get(i);
				}
				Arrays.sort(arr);
				ArrayList<NewsVO> ndatas = new ArrayList<NewsVO>();
				for (int i = 0; i < arr.length; i++) {
					ndatas.add(arr[i]);
				}
				return ndatas;
			} else if(mVO.getTitle().equals("인기글")) {// PK를 선택하지 않았다면..(가장 인기있는 뉴스 출력)

				ArrayList<NewsVO> mdatas = new ArrayList<NewsVO>();
				int max = datas.get(0).getCnt();// 최대값에 0번째 인덱스 값 저장
				for (int i = 1; i < datas.size(); i++) {// datas 길이만큼 조회수가 제일 큰 값 비교
					if (datas.get(i).getCnt() >= max) {// 조건 찾기
						max = datas.get(i).getCnt();// 최댓값 갱신
					}
				} // end for(최대값 갱신)
				for (int i = 0; i < datas.size(); i++) {
					if (datas.get(i).getCnt() == max) {
						mdatas.add(datas.get(i));
					}
				}
				return mdatas;
			}else if (mVO.getGenre() == null) {// 기사 제목 검색
				ArrayList<NewsVO> tdatas = new ArrayList<NewsVO>();
				for (int i = 0; i < datas.size(); i++) {
					if (datas.get(i).getTitle().contains(mVO.getTitle())) {
						tdatas.add(datas.get(i));
					}
				}
				return tdatas;
			}

		}

		else if (mVO.getTitle() == null) {// 분야 검색
			ArrayList<NewsVO> gdatas = new ArrayList<NewsVO>();
			for (int i = 0; i < datas.size(); i++) {
				if (mVO.getGenre().equals(datas.get(i).getGenre())) {
					gdatas.add(datas.get(i));
				}
			}
			return gdatas;
		} 
		return null;

	}// end selectAll

	//=====================================================================================================================
	public NewsVO selectOne(NewsVO mVO) {

		for (int i = 0; i < datas.size(); i++) {// PK가 있는지 확인
			if (mVO.equals(datas.get(i))) {
				return datas.get(i);
			}
		} // end for(PK 찾기)
		return null;// PK가 일치하지 않는다면

	}// end selectOne
	//=====================================================================================================================
	// C

	public boolean insert(NewsVO mVO) {
		return false;
	}// end insert
	//=====================================================================================================================
	// U

	public boolean update(NewsVO mVO) {
		for (int i = 0; i < datas.size(); i++) {// PK가 있는지 확인
			if (mVO.equals(datas.get(i))) {
				datas.get(i).setCnt(datas.get(i).getCnt() + 1);// 조회수 하나 증가
			}

		}

		return false;
	}// end update
	//=====================================================================================================================

	// D
	public boolean delete(NewsVO mVO) {
		return false;
	}// end delete

}