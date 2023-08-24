package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao{

	private static VisitDao visitDao = new VisitDao();
	public static VisitDao getInstance() { return visitDao; }  
	private VisitDao() {}
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 DTO, 리턴 : 성공/실패(boolean)=true/false ] 
	public boolean vwrite(VisitDto visitDto) { 
		System.out.println("dao 도착");
		String sql = "insert into visitlog(vwriter, vpwd, vtext) values(?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getVwriter());
			ps.setString(2, visitDto.getVpwd());
			ps.setString(3, visitDto.getVcontent());
			int row = ps.executeUpdate();
			
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println("vwrite 오류 발생 : " + e);
		}
		
		return false; 
	}
	// 2. 호출 [ 인수 : x, 리턴 : 여러개(ArrayList)의 방문록 DTO ]
	public ArrayList<VisitDto> vread() {
		
		String sql = "select * from visitlog order by vdate desc";
		ArrayList<VisitDto> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				VisitDto visitDto = new VisitDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				list.add(visitDto);
			}
			
			return list;
		}catch(Exception e) {
			System.out.println("vwrite 오류 발생 : " + e);
		}
		
		return null;
	}
	// 3. 수정 [ 인수 : 수정할 방문록 번호, 수정할 내용, 리턴 : 성공/실패(boolean)=true/false ]
	public boolean vupdate(int vno, String vcontent, String vpwd) {
		
		String sql = "update visitlog set vtext = ? where vno = ? and vpwd = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vcontent);
			ps.setInt(2, vno);
			ps.setString(3, vpwd);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println("vupdate오류 : " + e);
		}
		
		return false;
	}
	// 4. 삭제 [ 인수 : 삭제할 방문록 번호, 리턴 : 성공/실패(boolean)=true/false ]
   public boolean vdelete(int vno,String vpwd) {
	      try {
	         String sql  = "delete from visitlog where vno = ? and vpwd = ?";
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, vno);
	         ps.setString(2, vpwd);
	         int res = ps.executeUpdate();
	         
	         if(res == 1)
	         {
	            return true;
	         }
	      } catch (Exception e) {
	         System.out.println("vdelete오류"+e);
	      }
	      return false;
	  }
}

