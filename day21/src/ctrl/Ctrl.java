package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.NewsDAO;
import model.NewsVO;
import view.View;

public class Ctrl {
	private NewsDAO nDAO;
	private MemberDAO mDAO;
	private View view;
	private MemberVO member;
	
	public Ctrl() {
		this.nDAO = new NewsDAO();
		this.mDAO = new MemberDAO();
		this.view = new View();
		this.member = null;
	}
	
	public void startApp() {
		while(true) {
			int action = view.printProgramMenu(3);
// ===========================로그인=============================
			if (action == 1) {
				
				MemberVO mdata = view.signIn();

				member = mDAO.selectOne(mdata);
				
				if (member == null) {
					view.signInFalse();
					continue;
				}
				
				view.signInTrue();
				
				while(true) {
					action = view.printUserMenu(6);
// ===========================뉴스 목록출력=============================
					if (action == 1) { // 뉴스 목록출력
						// 뉴스목록을 ndatas에 저장
						ArrayList<NewsVO> ndatas = nDAO.selectAll(null);
						// ndatas 출력
						view.printNewsList(ndatas);
					}
// ===========================뉴스 검색=============================
					else if (action == 2) { // 뉴스 검색
						action = view.getSearchNews(3);
						
						if (action == 1) { // 랭킹 순위 검색
							// !질문!
							NewsVO rank = view.printNewsRank();
							ArrayList<NewsVO> ndatas = nDAO.selectAll(rank);
							
							view.printPopularNews(ndatas);
							
							int num = view.getPickNum();
							NewsVO ndata = new NewsVO(num, null, null);
							NewsVO res = nDAO.selectOne(ndata);
							
							if (res == null) {
								view.printFalseNum();
								continue;
							}
							
							nDAO.update(res);
							view.printNews(res);
							
						}
// ===========================분야 검색=============================
						else if (action == 2) { // 분야 검색
							// 분야 입력시 그 분야 뉴스 출력
							// !질문!
							String gnere = view.getNewsGenre();
							
							NewsVO nVO = new NewsVO(0, null, gnere);
							ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO);
							view.printNewsList(ndatas);
						}
						else if (action == 3) { // 제목 검색
							String title = view.getNewsTitle();
							
							NewsVO nVO = new NewsVO(0, title, null);
							ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO);
							
							view.printNewsList(ndatas);
						}
					}
// ===========================인기있는 뉴스출력=============================
					else if (action == 3) { // 인기있는 뉴스출력
						// nVO의 PK가 0 이면
						// 장르에 메세지 전달 "인기"
						NewsVO nVO = new NewsVO(0, "인기글", null);
						ArrayList<NewsVO> ndatas = nDAO.selectAll(nVO);
						view.printPopularNews(ndatas);
					}
// ===========================뉴스 보기=============================			
					else if (action == 4) { // 뉴스 보기
						// nVO의 PK가 0 이 아니면
						ArrayList<NewsVO> ndatas = nDAO.selectAll(null);
						view.printNewsList(ndatas);
						
						int num = view.getPickNum();
						NewsVO ndata = new NewsVO(num, null, null);
						NewsVO res = nDAO.selectOne(ndata);
						
						if (res == null) {
							view.printFalseNum();
							continue;
						}
						// !질문!
						nDAO.update(res);
						view.printNews(res);
						
						MemberVO mVO = new MemberVO(member.getMid(), null, Integer.toString(res.getPK()));
						mDAO.update(mVO);
					}
// ===========================마이페이지=============================
					else if (action == 5) { // 마이페이지
						action = view.printMyPage(3);
						if (action == 1) { // 조회했던 뉴스출력
							for(int i=0; i<member.getCart().size(); i++) {
								NewsVO nVO = new NewsVO(member.getCart().get(i), null, null);
								NewsVO ndata = nDAO.selectOne(nVO);
								view.printNews(ndata);
							}
						}
// ===========================비밀번호 변경=============================
						else if (action == 2) { // 비밀번호 변경
							String mpw = view.getMpw();
							if (!member.getMpw().equals(mpw)) {
								view.printChangeMpwFalse();
								continue;
							}
							
							String npw = view.getChangeMpw();
							MemberVO mVO = new MemberVO(member.getMid(), npw, null);
							
							if(!view.getRealChangeMpw()) {
								view.printChangeMpwFalse();
								continue;
							}
							if (!mDAO.update(mVO)) {
								view.printChangeMpwFalse();
								continue;
							}
							view.printChangeMpwTrue();
							
						}
// ===========================회원탈퇴=============================
						else if (action == 3) { // 회원탈퇴
							String mpw = view.getMpw();
							if (!member.getMpw().equals(mpw)) {
								view.printMpwFalse();
								continue;
							}
							if(!view.getRealDelete()) {
								view.printMemberDeleteFalse();
								continue;
							}
							if (!mDAO.delete(member)) {
								view.printMemberDeleteFalse();
								continue;
							}
							
							
							view.printMemberDeleteTrue();
							view.printEndMypage();
							break;
						}
					}
// ===========================로그아웃=============================
					else if (action == 6) { // 로그아웃
						member = null;
						view.printSeeUAgain();
						break;
					}
				}
			}
			
// ===========================회원가입=============================
			else if (action == 2) { // 회원가입
				if (mDAO.insert(view.signUp())) {
					view.signUpTrue();
				} else {
					view.signUpFalse();
				}
			}
			
// ===========================프로그램 종료=============================
			else if (action == 3) { // 프로그램 종료
				view.printProgramEnd();
				break;
			}
		}
	}
}
