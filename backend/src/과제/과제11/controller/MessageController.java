package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.MessageDao;
import 과제.과제11.model.dto.MessageDto;

public class MessageController {
	// 싱글톤
	private static MessageController messageController = new MessageController();
	public static MessageController getInstance() { return messageController; }
	private MessageController() {}
	
	// messageSendLogic() : 쪽지 보내기 페이지
	public boolean messageSendLogic(int mno, String content) {
		return MessageDao.getInstance().messageSendSQL(MemberController.getInstance().getLoginSession(), mno,content);
	}
	
	// messageCheckLogic() : 쪽지 확인 페이지
	public ArrayList<MessageDto> messageCheckLogic() {
		
		return MessageDao.getInstance().messageCheckSQL(MemberController.getInstance().getLoginSession());
	}
	
	// messageReplyLogic() : 쪽지 답장 보내기 페이지
	public boolean messageReplyLogic(int msno, String mscontent) {
		return MessageDao.getInstance().messageReplySQL(msno, MemberController.getInstance().getLoginSession(), mscontent);
	}
}
