package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthSendEmailController
 */
@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public AuthSendEmailController() {
        super();

    }
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 1. 요청하기
      String memail = request.getParameter("memail");
      
      // 2. 인증번호 생성 [ 난수 6자리 ]
      String auth = "";   // 인증번호를 저장할 문자열
      for(int i=0; i<6; i++) {
         
         Random random = new Random();
         auth += random.nextInt(10);   // random.nextInt()   : int 타입 범위 내 난수생성
         // random.nextInt( 끝수 ) : 0~(끝수미만) 범위 내 난수생성
      }
      
      // 3. 인증번호를 해당 이메일에게 전송 [ SMTP : 간이 우편전송 프로토콜 ]
         // * HTTP 웹 통신규약
         // * SMTP 우편전송 통신규약
      // 하단 주석 참고
      
      
      
      
      // 4. 인증번호 반환
      response.getWriter().print( auth );
      
   }



   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }


   protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

}
/*
   - 자바에서 이메일 전송 보내기
      1. 이메일을 전송할 도메인 필요 [ 네이버, 다음, 구글 등 ]
         [ 강의 : 네이버(git : 패스워드 감추거나 private 저장소), 2차 비밀번호 불가능 ]
         - 네이버 로그인
         - 좌측 환경설정 -> 상단 카테고리 POP3/IMAP 설정
         [IMAP/SMTP 사용]
*/




