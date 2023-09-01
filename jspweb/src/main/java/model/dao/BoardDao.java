package model.dao;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return boardDao; }
	
	// 1. 글쓰기 
	public boolean bwrite(BoardDto boardDto) {
		
		String sql = "insert into board(btitle,bcontent,bfile, mno, bcno) values(?,?,?,?,?)";
		try {
			
		}catch(Exception e) {
			System.out.println("bwrite 오류 : " + e);
		}
		return false;
	}
	
	// 2. 모든 글 출력 
	
	// 3. 개별 글 출력 
	
	// 4. 게시물 수정 
	
	// 5. 게시물 삭제 
	
	// 6. 조회수 증가 
}
