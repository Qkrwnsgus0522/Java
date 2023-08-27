package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminView admin;
	private ClientView client;
	private MemberVO member; // 현재 로그인한 회원정보
//	private CommonView common; // 공통으로 사용할 view가 있으면
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
		member=null; // 세션 로그인 데이터
		// 프로그램을 실행한다고 해서, 자동 로그인이 되지는 않기 때문에 null로 초기화!
	}
	/*
	public Ctrl(MemberVO member) {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
		this.member=member; // 자동 로그인
	}
	*/

	public void startApp() {
		while(true) {
			int action=client.printClientMenu01(); // 1-1 -> 1-2
			if(action==1234) { // 관리자모드 실행 // 2-1
				while(true) { // 관리자모드 진입
					action=admin.printAdminMenu();
					// 2-1. 사용자가 관리자인 상황
					// 2-2. 관리자가 회원목록볼래~
					// 2-3. V가 C한테 말합니다. 회원목록보겠다는데?
					// 2-4. C가 아, 회원목록 데이터가 필요하구나? ㅇㅋ
					// 2-5. M한테 회원목록 좀 줘~
					// 2-6. M이 selectAll()합니다.
					// 2-7. AL<MVO>가 반환되고 C는 그걸~
					// 2-8. ~V한테 줍니다.
					if(action==1) { // 회원목록출력 // 2-2 -> 2-3
						/*
//						ArrayList<MemberVo> datas = model.selectAll(); // 2-4 -> 2-5 -> 2-6
						
//						view.회원목록출력(datas); // 2-7 -> 2-8
						
						ArrayList<MemberVO> mdatas = mDAO.selectAll(null);
						admin.printMemberList(mdatas);
						*/
						
						admin.printMemberList(mDAO.selectAll(null));
					}
					else if(action==2) { // 관리자모드 종료
						admin.printAdminEnd();
						break;
					}
				}
			}
			// 1-1. 사용자가 console에 회원가입할래~ 1번입력
			// 1-2. V는 입력한 값을 C한테 전달
			// 1-3. C는 아~ 회원가입하고싶구나? ㅇㅋ
			// 1-4. C는 V한테 회원가입할 정보를 입력받아오라고 지시
			// 1-5. V는 사용자한테 회원가입창 보여줌
			// 1-6. 사용자는 정보를 입력
			// 1-7. V는 사용자가 입력한 정보를 C한테 전달
			// 1-8. C는 이 정보를 M한테 전달
			// 1-9. M은 회원가입을 수행
			// 1-10. M은 insert()가 잘되었는지 아닌지를 T, F를 반환
			// 1-11. C는 결과에따라 맞는 V화면을 보여줄 수 있도록 지시
			// 1-12. 사용자는 V가 보여주는 화면을 보게됨
			else if(action==1) { // 회원가입 // 1-3
				/*
//				회원가입정보 a = view.회원가입화면(); // 1-4 -> 1-5 -> 1-6 -> 1-7
				MemberVO mVO = client.signUp();
				
//				boolean 성공실패여부 = mDAO.insert(a); // 1-8 -> 1-9 -> 1-10
				boolean flag = mDAO.insert(mVO);
				
//				if (성공실패여부) { // 1-11 -> 1-12
//					view.성공화면();
//				} else {
//					view.실패화면();
//				}
				if (flag) {
					client.signUpTrue();
				} else {
					client.signUpFalse();i
				}
				*/
				if(mDAO.insert(client.signUp())) {
					client.signUpTrue();
				}
				else {
					client.signUpFalse();
				}
			}
			else if(action==2) { // 로그인
//				if(mDAO.selectOne(client.signIn())!=null) {
				
				MemberVO mVO = client.signIn();
				// mVO에는 사용자가 입력한 아이디, 비밀번호가 저장되어있음!
				
				// 아이디 입력해봐! 라고 V가 사용자가에 요청
				// 비밀번호도 같이 입력해~~
				
//				mVO = mDAO.selectOne(mVO);
//				MemberVO mdata = mDAO.selectOne(mVO);
				member = mDAO.selectOne(mVO);
				// mdata에는 유효한 사용자 정보 or null
				// 유효한 사용자 정보 == 현재 로그인한 회원
				
				// C는 이 정보가 있는지, 그리고 맞는지(==유효한지)
				// 위의 여부를 M한테 판단을 부탁함
				//	-->> selectOne()
				
				if (member == null) {
					// 로그인 실패 V
					// 프로그램 모드에 계속 존재
					client.signInFalse();
					continue;
				}
				client.signInTrue();
				
				// 로그인 성공 V
				// 다음 스텝으로 이동
				
				// M은 VO를 반환 == 존재하는 회원
				// -> 로그인 성공 V
				//	=> 다음 스텝으로 이동
				//	null을 반환 == 없거나, 비밀번호가 틀림!
				// -> 로그인 실패 V
				//	=> 프로그램 모드에 계속 있어야함...
				
				
				while(true) { // 사용자모드 진입
					action=client.printClientMenu02(member);
					if(action==1) { // 로그아웃
												
						// 사용자가 로그아웃을 원하면,
						// C에 mdata가 현재 존재하는데, 이걸
						// 제거하고
						// 로그아웃이 되었음을 사용자에게 알려주자!~~~
						// V -> C -> V
						
						member = null;
						
						client.logout();
						client.printClientEnd02();
						break;
					}
					else if(action==2) { // 마이페이지
						action = client.printClientMenu03();
						// 1. 회원정보출력 2. 비밀번호변경
						if (action == 1) {
							client.printMemberInfo(mDAO.selectOne(member));
						} else if (action == 2) {
							// V가 변경할 비번을 입력받음
							// V는 비번을 C에게 전달
							// C는 M.update() 수행
							// T -> ㄱㄱ
							// F -> ㄴㄴ
							
							// 현재 비밀번호 확인
							String mpw = client.getMpw();
							if (!member.getMpw().equals(mpw)) {
								// 현재 비밀번호 확인 실패
								client.printMpwFalse();
								continue;
							}
							// 현재 비밀번호 확인 성공

							// 새로운 비밀번호 입력
							String npw = client.getNewMpw(member);
							MemberVO mdata = new MemberVO(member.getMid(), npw, null);
							boolean flag = mDAO.update(mdata);							
							// 비밀번호 변경
							if (flag) {
								// 비밀번호 변경 성공
								client.printMemberUpdateTrue();
							} else {								
								// 비밀번호 변경 실패
								client.printMemberUpdateFalse();
							}
						}
					}
					else if(action==3) { // 회원탈퇴
						// 현재 로그인한 상황.
						
						// 비밀번호를 한번더 확인하는 로직
						// 비밀번호가 불일치 -> 회원탈퇴 x
						String mpw = client.getMpw();
						if (!member.getMpw().equals(mpw)) {
							// 비밀번호 불일치
							client.printMpwFalse();
							continue;
						}
						// 비밀번호 일치
						
						if(!mDAO.delete(member)) {
							// 회원탈퇴 실패
							client.printMemberDeleteFalse();
							continue;
						}
						// ->
						// 로그인이 되어있는 회원을
						// 전체회원목록에서 제거
						
						// 회원탈퇴 성공
						client.printMemberDeleteTrue();
						client.printClientEnd02();
						break;
					}
					else if(action==4) { // 상품목록출력
						/*
							ArrayList<ProductVO> pdatas = pDAO.selectAll(null);
							client.printProductList(pdatas);
						 */
						client.printProductList(pDAO.selectAll(null));
					}
					else if(action==5) { // 상품목록검색_이름으로 검색
						String name = client.getSearchContent();
						ProductVO pVO = new ProductVO(0, name, 0, 0);
						ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
						client.printProductList(pdatas);
					}
					else if(action==6) {
						int num = client.getSearchPriceContent();
						String name = "";
						int price = 0;
						if (num == 1) {
							ProductVO pVO = client.getSearchPriceContent1();								
							ProductVO pdata = pDAO.selectOne(pVO);
							client.printProduct(pdata);
						} else if (num == 2) {
							ProductVO pVO = client.getSearchPriceContent2();
							ProductVO pdata = pDAO.selectOne(pVO);
							client.printProduct(pdata);
						} else if (num == 3) {
							ProductVO pVO = client.getSearchPriceContent3();
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						} else if (num == 4) {
							ProductVO pVO = client.getSearchPriceContent4();
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						} else if (num == 5) {
							ProductVO pVO = client.getSearchPriceContent5();
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						}
					}
				}
			}
			else if(action==3) { // 프로그램 종료
				client.printClientEnd01();
				break;
			}
		}
	}
}
