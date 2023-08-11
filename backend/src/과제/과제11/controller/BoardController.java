package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

public class BoardController {

	// 0. 싱글톤
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController;}
	private BoardController() {}
	
	// 9. boardWrite() : 게시물쓰기 페이지
	public boolean boardWriteLogic(String title, String content) {
		
		// 1. 유효성 검사
		if(title.length() == 0 || title.length() > 50) { return false;}
		// 2. Dto [ 입력받은 제목, 입력받은 내용, 로그인된 회원정보 ] 
		BoardDto dto = new BoardDto(title, content, MemberController.getInstance().getLoginSession());
		// 3. DAO에게 전달후 결과 받기
		boolean result =BoardDao.getInstance().boardWriteSQL(dto);
		return result;
	} 
	// 10. boardPrint : 모든 게시물 출력
	public ArrayList<BoardDto> boardPrintLogic() {
		ArrayList<BoardDto> list = BoardDao.getInstance().boardPrintSQL();
		return list;
	}
	// 11. boardView : 개별 게시물 출력
	public BoardDto boardViewLogic(int bno) {
		return BoardDao.getInstance().boardViewSQL(bno);
	}
	// 12. boardUpdate : 게시물 수정
	public boolean boardUpdateLogic(int bno, String title, String content) {
		return BoardDao.getInstance().boardUpdateSQL(bno, title, content);
	}
	// 13. boardDelete : 게시물 삭제
	public boolean boardDeleteLogic(int bno) {
		return BoardDao.getInstance().boardDeleteSQL(bno);
	}
}

/*
	테이블
		레코드/행/가로 -> DTO 1개
		레코드/행/가로 -> DTO 1개	여러개 DTO 하나의 객체로 담기 -> 리스트 혹은 배열
		레코드/행/가로 -> DTO 1개
	
	예)
		로그인한 회원정보 1개 조회 = DTO;
*/