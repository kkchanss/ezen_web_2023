package 과제.과제11.model.dao;

import java.sql.SQLException;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {
	private static MemberDao mainDao = new MemberDao();
	public static MemberDao getInstance() {return mainDao;}
	private MemberDao() {}
	
	// 2. 회원가입SQL
	public boolean signupSQL(MemberDto dto) {
		// 회원가입 필요한 sql를 문자열에 작성(여기는 sql공간아니라서)해서 저장
			// 테이블에 레코드 삽입 : insert into 테이블명(필드명,필드명,필드명) values(값,값,값);
		String sql = "insert into member(mid, mpw, mname, mphone) values(?,?,?,?)";
		
		// 2. 위에서 작성한 sql를 db 연동 객체에 대입 [ conn.prepareStatement(sql) ]
		// 3. 대입된 sql 조작하기 위해 반환된 PreparedStatement를 ps 대입
		try {
			ps = conn.prepareStatement(sql); 
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} // prepareStatement(조작할 sql문자열)
		// conn 필드는 Dao 부모클래스에 물려받음
		return false;
	}
	// 3. 로그인SQL
	public boolean loginSQL(String id, String pw) {
		
		// 1단계 : SQL 작성한다.
		String sql = "select * from member where mid = ? and mpw = ?";
		
		try {
			// 2단계 : sql 조작할 수 있는 객체 필요함으로 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3단계 : sql 조작 [ sql안에 있는 매개변수[?]에 값 대입 ]
			ps.setString(1, id);
			ps.setString(2, pw);
			// 4단계 : sql 실행
				// [ insert/update/delete : ps.executeUpdate(); / select : ps.executeQuery(); ]
			rs = ps.executeQuery();
			// 5단계 : SQL 실행 결과 조작 [ rs.next() : 결과중에서 다음 레코드객체 호출 ]
				// 만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1 -> 레코드2 -> 레코드3 ]
				//
			if(rs.next()) { // 로그인sql 결과 레코드는 1개 또는 0개이므로 if 사용해서 .next() 한번 호출
				return true; // 로그인 성공
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false; // 로그인 실패
	}
}
