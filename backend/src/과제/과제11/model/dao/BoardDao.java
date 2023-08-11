package 과제.과제11.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;

public class BoardDao extends Dao {
	
	// 0. 싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() { return boardDao;}
	private BoardDao() {}
	
	// 9. boardWrite() : 게시물쓰기 페이지
	public boolean boardWriteSQL(BoardDto dto) {
		
		
		try {
			String sql = "insert into board(btitle,bcontent,mno) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setInt(3,dto.getMno());
			int row = ps.executeUpdate();
			if(row == 1) return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	} 
	// 10. boardPrint : 모든 게시물 출력
	public ArrayList<BoardDto> boardPrintSQL() {
		ArrayList<BoardDto> list = new ArrayList<>(); // 여러개 BoardDto를 저장할 리스트 객체 선언
		try {	
			String sql = "select b.*, m.mid from member m natural join board b order by b.bdate desc"; // 1. 최신순 [ desc내림차순 ] 으로 모든 레코드 호출
			ps = conn.prepareStatement(sql);
			// 3. sql에 ?(매개변수) 없으므로 생략
			rs = ps.executeQuery();
			// 5. 여러개 레코드 조회 [ rs.next() : 다음 레코드 이동(존재하면true/존재하지않으면false) ]
			while(rs.next()) { 
				// [ 레코드 개수만큼 반복 ]
				// 레코드 1개마다 1개의 DTO 반환
				// 필드 호출 
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String date = rs.getString(4);
				int view = rs.getInt(5);
				int mno = rs.getInt(6);
				String mid = rs.getString(7);
				BoardDto dto = new BoardDto(no,title,content,date,view,mno, mid);
				list.add(dto);
			}
			
		}catch(Exception e) {
			
		}
		return list;
	}
	// 11. boardView : 개별 게시물 출력
	public BoardDto boardViewSQL(int bno) {
		String sql = "select b.*, m.mid from member m natural join board b where b.bno = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String date = rs.getString(4);
				int view = rs.getInt(5);
				int mno = rs.getInt(6);
				String id = rs.getString(7);
				boardViewCountSQL(bno, view);
				BoardDto result = new BoardDto(no, title, content, date, view, mno, id);
				return result;
			}
		}catch(Exception e) {
			
		}
		
		return null;
		
	}
	
	// 11-2 조회수 증가 함수
	public void boardViewCountSQL(int bno, int view) {
		String sql = "update board set bview = ? where bno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, view+1);
			ps.setInt(2, bno);
			int row = ps.executeUpdate();

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	// 12. boardUpdate : 게시물 수정
	public boolean boardUpdateSQL(int bno, String title, String content) {
		String sql = "update board set bcontent = ?, btitle = ?  where bno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, title);
			ps.setInt(3, bno);
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 13. boardDelete : 게시물 삭제
	public boolean boardDeleteSQL(int bno) {
		String sql = "delete from board where bno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row==1) return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
