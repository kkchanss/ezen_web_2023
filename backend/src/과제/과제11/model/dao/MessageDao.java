package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.MessageDto;

public class MessageDao extends Dao{
	// 싱글톤
	private static MessageDao messageDao = new MessageDao();
	public static MessageDao getInstance() { return messageDao; }
	private MessageDao() {}
	
	// 쪽지 보내기 페이지
	public boolean messageSendSQL(int sender, int taker, String content) {
		
		String sql = "insert into message(sender, taker, mscontent) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sender);
			ps.setInt(2, taker);
			ps.setString(3, content);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 쪽지 확인 페이지
	public ArrayList<MessageDto> messageCheckSQL(int mno) {
		
		ArrayList<MessageDto> dtoList = new ArrayList<>();
		
		String sql = "select ms.*, m.mid from member m natural join message ms where ms.sender = m.mno and ms.taker = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			while(rs.next()) {
				int msno = rs.getInt(1);
				int sender = rs.getInt(2);
				int taker = rs.getInt(3);
				String mscontent = rs.getString(4);
				String msdatetime = rs.getString(5);			
				
				String senderid = rs.getString(6);
				MessageDto dto = new MessageDto(msno, sender, taker, mscontent,senderid, msdatetime);
				dtoList.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return dtoList;
	}
	
	// 쪽지 답장 보내기 페이지
	public boolean messageReplySQL(int msno, int sender, String mscontent) {
		
		int taker = messageTakerFindSQL(msno);
		String sql = "insert into message(sender, taker, mscontent) values(?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sender);
			ps.setInt(2, taker);
			ps.setString(3, mscontent);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 쪽지 발신인 찾기 
	public int messageTakerFindSQL(int msno) {
		String sql = "select sender from message where msno = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msno);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}
}
