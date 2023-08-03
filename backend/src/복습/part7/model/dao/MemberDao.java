package 복습.part7.model.dao;

import 복습.part7.model.dto.MemberDto;
import 복습.part7.view.MainPage;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() { return memberDao; }
	private MemberDao() {}
	
	public MemberDto[] memberDtoList = new MemberDto[100];
}
