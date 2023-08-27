package ctrl;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.View;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private View view;
	private MemberVO member; // 현재 로그인한 회원의 정보를 저장할 변수
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		view=new View();
		member=null;
	}
	public void startApp() {
		while (true) {
			int action = view.printMenu();
			if (action == 1) {
				// V가 상품목록을 보여달라고함
				// M이 상품목록 가져옴
				// 가져왔다면, v에게 전달
				ProductVO pVO = new ProductVO();
				view.printList(pDAO.selectAll(pVO));
			}
			else if (action == 2) {
				// 실습(이름, 가격으로 검색하기)
				view.printList(pDAO.selectAll(view.printSearchMenu()));
			}
			else if (action == 3) {
				if (member == null) {
					System.out.println("	로그: 로그인 안함");
					continue;
				}
				// V가 어떤 상품을 구매헀는지 입력을받아옴
				int proNum = view.getNum();
				// 그럼 그 상품 구매가 가능한지 확인
				// 상품구매가능여부 확인
				// 1. 없는 상품인지
				// 2. 재고있는지
				ProductVO pdata = pDAO.selectOne(new ProductVO(proNum, null, 0, 0));
				if (pdata == null) {
					System.out.println("	로그: 해당상품없음"); 
					view.printFalse();
					continue;
				}
				if (pdata.getCnt() <= 0) {
					System.out.println("	로그: 상품재고없음"); 
					view.printFalse();
					continue;
				}
				// 구매가 가능하다면
				// 구매를 진행
				
				// 구매를하면 재고 --
				// 실패하면
				if (!pDAO.update(pdata)) {
					System.out.println("	로그: 상품구매실패"); 
					view.printFalse();
					continue;
				}
				member.setTmpPrice(pdata.getPrice());
				// 개발 편의성때문에 새로 만든 VO의 멤버변수를 활용한 로직
				// 사용자 total ++
				// 실패하면
				if(!mDAO.update(member)) {
					System.out.println("	로그: 멤버TOTAL추가실패"); 
					view.printFalse();
					continue;
				}
				// 성공하면
				view.printTrue();
			}
			else if (action == 4) {
				// V에서 회원가입할 정보를 입력
				// V가 입력한 정보를 C가 받아서
				// M에게 건네줌
				// M에게 결과를 반환받아서
				// 맞는 결과를 V와 연결
				if (!mDAO.insert(view.signin())) {
					view.printFalse();
					continue;
				}
				view.printTrue();
			}
			else if (action == 5) {
				// V에서 로그인을 시도
				// 로그인정보받아옴
				// 로그인정보 M한테 전달해서 확인
				// member에 로그인된 정보 저장
				member = mDAO.selectOne(view.signin());     
				// 없으면 로그인실패!
				if (member == null) {
					view.printFalse();
					continue;
				}
				view.printTrue();
				
			}
			else if (action == 6) {
				member = null;
			}
			else if (action == 7) {
				if (member == null) {
					System.out.println("	 로그: 로그인 안함"); 
					continue;
				}
				if (!member.getMpw().equals(view.getCurrentMpw(member))) {
					view.printFalseMpw();
					continue;
				}
				String cpw = view.getChangeMpw(member);
				MemberVO mVO = new MemberVO(member.getMid(), cpw);
				mVO.setTmpAction("비밀번호변경");
				if (!mDAO.update(mVO)) {
					view.printFalse();
					continue;
				}
				view.printTrue();
				member = null;
			}
			else if (action == 8) {
				// 회원이 탈퇴하겠다고함
				// 그럼 M한테 누가 탈퇴할지 알려줘
				
				if (member == null) {
					view.printFalse();
					continue;
				}
				if (!mDAO.delete(member)) {
					view.printFalse();
					continue;
				}
				member = null;
				view.printTrue();
			}
			else {
				break;
			}
		}
	}
}
