package model.dao;

import java.util.ArrayList;

public class VisitDao extends Dao{

	private static VisitDao visitDao = new VisitDao();
	public static VisitDao getInstance() { return visitDao; }  
	private VisitDao() {}
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 DTO, 리턴 : 성공/실패(boolean)=true/false ] 
	public boolean vwrite() { 
		
		return false; 
	}
	// 2. 호출 [ 인수 : x, 리턴 : 여러개(ArrayList)의 방문록 DTO ]
	public ArrayList<VisitDao> vread() {
		
		return null;
	}
	// 3. 수정 [ 인수 : 수정할 방문록 번호, 수정할 내용, 리턴 : 성공/실패(boolean)=true/false ]
	public boolean vupdate(int vno, String vcontent) {
		
		return false;
	}
	// 4. 삭제 [ 인수 : 삭제할 방문록 번호, 리턴 : 성공/실패(boolean)=true/false ]
	public boolean vdelete(int vno) {
		
		return false;
	}
}

