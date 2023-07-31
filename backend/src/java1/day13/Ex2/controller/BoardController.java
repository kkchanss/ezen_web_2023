package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {

	// 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	// 글쓰기 처리 기능함수
	public boolean writeLogic(String writer, String content) {
		
		// 1. 매개변수로부터 전달 받은 content, writer를 하나의 객체로 선언
		BoardDto b = new BoardDto(content, writer);
		// 2. 객체를 배열에 저장 [ 빈공간을 찾아서 빈공간 저장 ]
		for(int i = 0 ; i < BoardDao.getInstance().boardDtoArray.length; i++) {
			if(BoardDao.getInstance().boardDtoArray[i] == null) {
				BoardDao.getInstance().boardDtoArray[i] = b;
				return true;
			}
		}
		// 2. 객체를 리스트에 저장
		BoardDao.getInstance().boardList.add(b);
		// 성공[true] 또는 실패[false]
		
			
		return false;
	}
	
	// 글출력 처리 기능함수
	public void printLogic() {
		
		for(int i = 0 ; i < BoardDao.getInstance().boardDtoArray.length; i++) {
			if(BoardDao.getInstance().boardDtoArray[i] == null) {
			}
		}
	}
	
	// 글수정 처리 기능함수
	public void updateLogic() {
		
	}
	
	// 글삭제 처리 기능함수
	public void deleteLogic() {
		
	}
	
	
}
