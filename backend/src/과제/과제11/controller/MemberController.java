package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController mainController = new MemberController();
	public static MemberController getInstance() {return mainController;}
	private MemberController() {}
	
	private int loginSession = 0; // 0 : 로그인 안한상태, 1이상 : 로그인된 회원의 번호 
	public int getLoginSession() { return loginSession; }
	
	// 2. 회원가입 처리 [ 반환 : 1:성공 2:실패[db오류] 3:아이디중복실패 4:비밀번호중복실패
	public int signupLogic(String id, String pw, String name, String phone) {
	
		if(MemberDao.getInstance().infoCheck("mid", id)) {
			return 3;
		}
		if(MemberDao.getInstance().infoCheck("mpw", pw)) return 4;
		
		
		// 유효성검사 했다치고
		// 1. 객체화 : 5개 매개변수들이 이동 할때마다 매개변수의 코드 길어짐
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
		
			// 1. 회원가입시 회원번호는 자동[auto_increment]이므로 필요 없음
		// 2. Dao 매개 전달
		boolean result = MemberDao.getInstance().signupSQL(dto);
		
		if(result) return 1;
		else return 2;
	}

	// 3. 로그인 처리
	public boolean loginLogic(String id, String pw) {
		// 2. Dao에게 전달
		int result = MemberDao.getInstance().loginSQL(id, pw);
		// 로그인 성공했을때 기록 하기 [ - 로그인 이후 로그인된 정보로 활동 ]
		if(result>=1) { this.loginSession = result; return true;}
		else return false;
	}
	
	public void logOut() { this.loginSession = 0;}
	
	// 4. 아아디 찾기
	public String findByIdLogic(String name, String phone) {
		String result = MemberDao.getInstance().findByIdSQL(name,phone);
		return result;
	}
	
	// 5. 비밀번호 찾기
	public String findByPwLogic(String id, String phone) {
		String result = MemberDao.getInstance().findByPwSQL(id,phone);
		return result;
	}
	
	// 6. 로그인된 회원정보 
	public MemberDto infoLogic() {
		// 현재 로그인된 회원번호[loginSession]는 view에서 전달 받지않고 컨트롤 안에 저장 되어잇으므로
		// 현재 로그인된 회원번호 념겨주기
		return MemberDao.getInstance().infoSQL(this.loginSession);
	}
	
	// 7. 회원정보 수정
	public boolean infoUpdateLogic(String newPw) {
		
		boolean result = MemberDao.getInstance().infoUpdateSQL(newPw, this.loginSession);
		
		return result;
	}
	
	// 8. 회원탈퇴
	public boolean infoDeleteLogic() {
		boolean result = MemberDao.getInstance().infoDeleteSQL( this.loginSession);
		
		return result;
	}
}
