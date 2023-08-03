package 복습.part7.controller;

import 복습.part7.model.dao.MemberDao;
import 복습.part7.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberContorller = new MemberController();
	public static MemberController getInstance() { return memberContorller; }
	private MemberController() {}
	
	public boolean joinController(String id, String pw, String name, String phone, int age) {
		MemberDto m = new MemberDto(id, pw, name, phone, age);
		
		for(int i = 0; i < MemberDao.getInstance().memberDtoList.length; i++) {
			if(MemberDao.getInstance().memberDtoList[i] == null) {
				MemberDao.getInstance().memberDtoList[i] = m;
				return true;
			}
		}
		return false;
	}
	
	public boolean loginController(String id, String pw) {
		
		for(int i = 0; i < MemberDao.getInstance().memberDtoList.length; i++) {
			if(MemberDao.getInstance().memberDtoList[i] != null) {
				if(MemberDao.getInstance().memberDtoList[i].getId().equals(id) &&
						MemberDao.getInstance().memberDtoList[i].getPw().equals(pw) ) {
					return true;
				}
				
			}
		}
		return false;
	}
}
