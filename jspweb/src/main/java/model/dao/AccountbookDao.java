package model.dao;

import java.util.ArrayList;

import model.dto.AccountbookDto;


public class AccountbookDao extends Dao {
	
	private static AccountbookDao accountDao = new AccountbookDao();
	public static AccountbookDao getInstance() { return accountDao; }  
	private AccountbookDao() {}
	
	// 쓰기 
	public boolean awrite(int money, String content, String date) {
		
		String sql = "insert into accountbook(amoney, acontent, aday) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, content);
			ps.setString(3, date);
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		}catch(Exception e) {
			System.out.println("awrite오류 : " + e);
		}
		
		return false;
	}
	
	// 읽기 
	public ArrayList<AccountbookDto> aread() {
		
		String sql = "select * from accountbook order by aday desc";
		ArrayList<AccountbookDto> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				AccountbookDto accountDto = new AccountbookDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				
				list.add(accountDto);
			}
			
			return list;
		}catch(Exception e) {
			System.out.println("awrite 오류 발생 : " + e);
		}
		return null;
	}
	
	// 수정
	public boolean aupdate(int ano, String acontent) {
		
		String sql = "update accountbook set acontent = ? where ano = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, acontent);
			ps.setInt(2, ano);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println("aupdate오류 : " + e);
		}
		
		return false;
	}
	
	// 삭제
   public boolean adelete(int ano) {
	      try {
	         String sql  = "delete from accountbook where ano = ?";
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, ano);
	         int res = ps.executeUpdate();
	         
	         if(res == 1)
	         {
	            return true;
	         }
	      } catch (Exception e) {
	         System.out.println("adelete오류"+e);
	      }
	      return false;
	  }
}
