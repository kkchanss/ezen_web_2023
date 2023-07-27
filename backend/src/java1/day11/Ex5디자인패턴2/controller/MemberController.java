package java1.day11.Ex5디자인패턴2.controller;

import java1.day11.Ex5디자인패턴2.model.dao.MemberDao;
import java1.day11.Ex5디자인패턴2.model.dto.MemberDto;

public class MemberController { // 기능처리(로직) 담당하는 클래스 // controller -> java
	
	// 1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	// 2. 외부로부터 싱글톤 호출할 수 있도록 get
	public static MemberController getInstanse() {
		return memberController;
	}
	// 3. 외부에서 객체 생성 차단
	private MemberController() {}
	
	public boolean signupLogic(String id, String pw, String name, String phone, int age) {
		MemberDto m = new MemberDto(id,pw,name,phone,age);
		for(int i = 0; i < MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i]==null) {
				MemberDao.memberList[i] = m; return true;
			}
		}
		return false;
	}

	void loginLogic() {}
	void findIdLogic() {}
	void findPwLogic() {}
}
