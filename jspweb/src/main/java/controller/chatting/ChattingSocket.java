package controller.chatting;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
	1. 서버 소켓 만들기
		1. 클래스 선언
		2. 클래스 위에 @ServerEndpoint("서버소켓의URL정의") : 클라리언트소켓들이 접속하는 위치
 		3. 서버 웹소켓의 필수 메소드
 			@OnOpen : 클라이언트소켓이 서버소켓에 연결이 접속했을때.
 			@OnClose : 클라이언트소켓이 서버소켓과 연결이 닫혔을때.
 			@OnMessage : 클라이언트소켓이 메시지를 보냈을때.
 			@OnError : 클라이언트소켓이 서버소켓과 연결에 에러 발생했을때.
 */

@ServerEndpoint("/ChattingSocket")
public class ChattingSocket {

	static ArrayList<Session> 접속명단 = new ArrayList<>();
	
	// 1. // 클라이언트가 서버소켓에 접속했을때 매핑/연결
	@OnOpen 
	public void onOpen(Session session) {
		System.out.println("클라이언트 소켓 접속 : " + session);
		System.out.println(session.getId());
		System.out.println(session.getRequestURI());
		
		접속명단.add(session);
		System.out.println("접속명단 : " + 접속명단);
	}
	
	@OnClose
	public void onClose(Session session) {
		접속명단.remove(session);
	}
	
	@OnMessage
	public void OnMessage(Session session, String msg) {
		System.out.println(msg);
		
		for(int i = 0 ; i < 접속명단.size(); i++) { Session s = 접속명단.get(i);}
		for(Session s : 접속명단) {}
		접속명단.forEach(s -> {
			try {
				s.getBasicRemote().sendText(msg);
				// s : 접속명단에 있는 클라리언트소켓 중 하나
					// .getBasicRemote() : 메세지 전송을 메소드 제공
						// .sendText : 메세지를 String타입으로 전송
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}
}
