package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin","1234","관리자"));
		datas.add(new MemberVO("coding_helper","timo","작은 티모"));
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas;
	}
	public MemberVO selectOne(MemberVO mVO){
		for (MemberVO v : datas) {
			if (mVO.getMid().equals(v.getMid())) {
				if (mVO.getMpw().equals(v.getMpw())) {
					return v;				
				}
				System.out.println(" 	로그: MemberDAO: selectOne(): 비밀번호가 일치하지않습니다!"); 
				return null;
			}
		}
		System.out.println(" 	로그: MemberDAO: selectOne(): 해당 아이디가 없습니다!"); 
		return null;
	}
	
//	mVO가 의미하는것 == 회원가입할 정보
	public boolean insert(MemberVO mVO) {
//		mVO를 datas에 넣어줄예정
//		PK 중복검사를 해야하고, 성공하면 add()
		boolean flag = false;
		for (MemberVO data : datas) {
			if (data.equals(mVO)) {
				flag = true;
				System.out.println(" 	로그: MemberDAO: insert(): 아이디 중복");
				break;
			}
		}
		if (flag) {
//			실패하면 false 반환
			return false;
		}
//		datas에 mVO정보를 저장 add()
		datas.add(new MemberVO(mVO.getMid(), mVO.getMpw(), mVO.getName()));
		/* 1) datas.add(new MemberVO()); 
		 * -> datas DB공간에 new 새로운 데이터터를 추가
		 * 2) MemberVO(데이터1, 데이터2, 데이터3)
		 * -> 데이터들을 mVO에서 추출하면됨
		 */
		return true;		
	}
	public boolean update(MemberVO mVO) {
		for(MemberVO v : datas) {
			if(v.equals(mVO)) {
				v.setMpw(mVO.getMpw());
				return true;
			}
		}
		return false;
	}
	public boolean delete(MemberVO mVO) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).equals(mVO)) {
				datas.remove(i);
				return true;
			}
		}
		return false;
	}
}
