package controller;

import java.util.ArrayList;

import model.StudentDAO;
import model.StudentVO;
import view.StudentView;

public class StudentCtrl {
	private StudentView view;
	private StudentDAO dao; // model
	public StudentCtrl(){
		this.view=new StudentView();
		this.dao=new StudentDAO();
	}
	
	public void startApp() {
		while(true) {
			
			// 사용자한테 메뉴보여줘!
			view.printMenu();
			// 사용자가 뭐 할지 입력받아봐
			int menuNum=view.getMenuNum();
			
			if(menuNum==1) {
				// 목록출력해
				ArrayList<StudentVO> datas=dao.selectAll();
				view.printStudentList(datas);
			}
			else if(menuNum==2) {
				// 1명출력해
				int num=view.getStudentNum();
				StudentVO data=dao.selectOne(num);
				view.printStudent(data);
			}
			else if(menuNum==3) {
				// 변경해
				int num=view.getStudentNum();
				int score=view.getStudentScore();
				dao.update(num, score);
				view.printInfo();
			}
			else if(menuNum==4) {
				// 추가해
				view.printInfo_C_Start();
				String name=view.getStudentName();
				int score=view.getStudentScore();
				dao.insert(name, score);
				view.printInfo_C_End();
			}
			else if(menuNum==5) {
				// 제거해
				view.printInfo_D_Start();
				int num=view.getStudentNum();
				if (dao.delete(num)) {
					view.printInfo_D_End();
				} else {
					view.printFalse();
				}
				// CRUD(비즈니스 메서드,핵심 로직)이 성공했는지,실패했는지를 알아야함!!!!!
			}
			else if(menuNum==6) {
				view.printEnd();
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
