package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;
import model.dto.VisitDto;

public class MemberDao extends Dao{

	private static MemberDao visitDao = new MemberDao();
	public static MemberDao getInstance() { return visitDao; }  
	private MemberDao() {}
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
	
		String sql="insert into member(mid,mpwd,memail,mimg) values(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println("signup 오류 : " + e);
		}
		
		return false;
	}
	// 2. 로그인
	
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기
	
	// 5. 내정보 호출
	
	// 6. 아이디/이메일 중복 검사 
	public boolean findIdOrEmail(String type, String data ) {
		String sql = "select * from member where " + type + " = ?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if(rs.next()) return true;
			
		}catch(Exception e) {
			System.out.println("findIdOrEmail 에러" + e);
		}
		
		return false;
	}
}

