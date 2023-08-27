package controller;

import java.util.ArrayList;

import model.Crawling;
import model.MovieDAO;
import model.MovieVO;
import view.View;

public class Controller {
	private MovieDAO mDAO;
	private View view;
	
	public Controller() {
		mDAO = new MovieDAO();
		view = new View();
	}
	
	public void startApp() {

//		// 사용자에게 크롤링한다는 사실 보여주고
//		view.printMenu();
//		
//		// 크롤링하고
//		ArrayList<MovieVO> mdatas = Crawling.sample();
//		// Q. 배열리스트를 받아오는데,
//		// insert()를 그럼 1번하나요?
//		// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
//		for (int i = 0; i < mdatas.size(); i++) {
//			MovieVO mdata = mdatas.get(i);
//			boolean flag = mDAO.insert(mdata);
//			if (!flag) {
//				// 실패하면 -실패
//				view.printFalse();
//				return;
//			}
//		}
//		
//		// 성공하면 -성공
//		view.printTrue();
		
		MovieVO mVO1 = new MovieVO(0, "", null);
		ArrayList<MovieVO> mdatas2 = mDAO.selectAll(mVO1);
		view.printMovieList(mdatas2);
		
		ArrayList<MovieVO> mdatas = null;
		MovieVO mVO = null;
		MovieVO mdata = null;
		
		while (true) {
			int action = view.printUserMenu();
			if (action == 1) {
				action = view.printUserMenu1();
				if (action == 1) {
					int num = view.getMovieNum();
					mVO = new MovieVO(num, null, null);
					mdata = mDAO.selectOne(mVO);
					if (mdata != null) {
						view.printMovie(mdata);
					} else {
						view.printExistsFalse();
					}
				} else if (action == 2) {
					String name = view.getMovieName();
					mVO = new MovieVO(0, name, null);
					mdatas = mDAO.selectAll(mVO);
					
					if (mdatas != null) {
						view.printMovieList(mdatas);
					} else {
						view.printExistsFalse();
					}
				}
			}
			
			else if (action == 2) {
				int num = view.printUserMenu2();
				mVO = new MovieVO(num, null, null);
				mdata = mDAO.selectOne(mVO);
				
				if (mdata != null) {
					view.printMovie(mdata);
				} else {
					view.printExistsFalse();
					continue;
				}
				action = view.getCheckDelete();
				if (action == 1) {
					if (mDAO.delete(mVO)) {
						view.printDeleteTrue();
					} else {
						view.printDeleteFalse();
					}					
				} else if (action == 2) {
					view.printDeleteCancel();
				}
				
			}
			
			else if (action == 3) {
				int num = view.printUserMenu3();
				mVO = mDAO.selectOne(new MovieVO(num, null, null));
				
				if (mVO != null) {
					view.printMovie(mVO);					
				} else {
					view.printExistsFalse();
					continue;
				}
				
				action = view.getUpdateType();
				
				boolean flagUpdate = false;
				
				if (action == 1) {
					String name = view.getMovieName();
					flagUpdate = mDAO.update(new MovieVO(num, name, null));
				} else if (action == 2) {
					String odate = view.getMovieOdate();
					flagUpdate = mDAO.update(new MovieVO(num, null, odate));
				}
				
				if (flagUpdate) {
					view.printUpdateTrue();
				} else {
					view.printUpdateFalse();
				}
			}
			
			else if (action == 4) {
				mdatas = mDAO.selectAll(new MovieVO(0, "", null));
				view.printMovieList(mdatas);
			}
			
			else if (action == 5) {
				view.printExitProgram();
				break;
			}
		}
	}
}
