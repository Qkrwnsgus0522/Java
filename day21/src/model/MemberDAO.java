package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberVO> datas;

	public MemberDAO() {
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO("junwon", "1234", "류준원"));
		datas.add(new MemberVO("1", "1", "류준원"));
	}

	//===========================================================================================================================================
	// 목록 출력(?)
	public ArrayList<MemberVO> selectAll(MemberVO mVO) { 
		return datas;
	}

	//===========================================================================================================================================

	// 로그인, 장바구니
	public MemberVO selectOne(MemberVO mVO) {
		for(MemberVO v : datas) {
			if(mVO.getMid().equals(v.getMid())) {
				if(mVO.getMpw().equals(v.getMpw())) {
					return v;
				}
			}
		}
		System.out.println(" 로그 : MemberDAO : SelectOne() : 해당 아이디가 존재하지 않습니다.");
		return null;
	}

	//===========================================================================================================================================

	// 회원가입
	public boolean insert(MemberVO mVO) { 
		boolean flag = false;
		for(MemberVO v : datas) {
			if(v.equals(mVO)) {
				flag = true;
				System.out.println(" 로그: MemberDAO: insert() : 해당 아이디가 이미 존재합니다.");
				break;
			}
		}
		if(flag) {
			System.out.println(" 로그 : MemberDAO : insert() : 회원가입 실패.");
			return false;
		}
		datas.add(new MemberVO(mVO.getMid(), mVO.getMpw(), mVO.getName()));
		return true;
	}

	//===========================================================================================================================================

	//비밀번호 변경, 장바구니 추가
	
	// 뉴스를 보면 카트에 담아야함
	// 누가 검사하는 것인지 먼저 검사
	public boolean update(MemberVO mVO) {
		boolean flag = false;
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).getMid().equals(mVO.getMid())) {
				if(mVO.getName() == null) { // 비밀번호 변경
					datas.get(i).setMpw(mVO.getMpw());
					return true;
				}
				else if(mVO.getMpw() == null) { // 내가 본 뉴스
					int mVOcnt = Integer.valueOf(mVO.getName());
					for(int j = 0; j < datas.get(i).getCart().size(); j++) {
						if(datas.get(i).getCart().get(j) == mVOcnt) {
							flag = true;
							break;
						}
					}
					if(!flag) {
						datas.get(i).getCart().add(mVOcnt);
						return true;
					}
				}
			}
		}
		return false;
	
//		boolean flag = false; // 카트 담기 위해
//
//		for(MemberVO v : datas) {
//			if(v.getMid().equals(mVO.getMid())) {
//				if(v.getName().equals(mVO.getCart())) {
//					flag = true;
//					break;
//				}
//			}		
//		}	
//		if(flag) {
//			return false;
//		}
//		ndatas.add(mVO);
//		return true;
	}

	//===========================================================================================================================================

	// 회원탈퇴
	public boolean delete(MemberVO mVO) { 
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).equals(mVO)) {
				datas.remove(i);
				return true;
			}
		}
		System.out.println(" 로그 : MemberDAO : delete() : 해당 아이디를 찾을 수 없습니다.");
		return false;
	}
}
