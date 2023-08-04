package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController mainController = new MemberController();
	public static MemberController getInstance() {return mainController;}
	private MemberController() {}
	
	// 2. 회원가입 처리
	public boolean signupLogic(String id, String pw, String name, String phone) {
		
		// 유효성검사 했다치고
		// 1. 객체화 : 5개 매개변수들이 이동 할때마다 매개변수의 코드 길어짐
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
		
			// 1. 회원가입시 회원번호는 자동[auto_increment]이므로 필요 없음
		// 2. Dao 매개 전달
		boolean result = MemberDao.getInstance().signupSQL(dto);
		return result;
	}
	// 3. 로그인 처리
	public boolean loginLogic(String id, String pw) {
		
		boolean result = MemberDao.getInstance().loginSQL(id, pw);
		return result;
	}
}
