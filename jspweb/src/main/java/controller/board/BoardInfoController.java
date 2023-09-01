package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();

    }
    
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      // 0. 첨부파일 업로드
      MultipartRequest multi = new MultipartRequest(
            request,
            request.getServletContext().getRealPath("/board/upload"),
            1024*1024*1024,
            "UTF-8",
            new DefaultFileRenamePolicy()
         );
         // * 업로드 서버경로 확인
         //   System.out.println( request.getServletContext().getRealPath("/board/upload") );
      
      // 1. (입력받은 매개변수) 요청
      String btitle = multi.getParameter("btitle");
      String bcontent = multi.getParameter("bcontent");
      String bfile = multi.getFilesystemName("bfile");
         // 작성자는 html상 입력하는 것이 아니라 이미 로그인 중이기에 세션에 로그인 회원 정보가 있음
         // --> 세션에서 회원정보 불러오기
      int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
      int bcno = Integer.parseInt(multi.getParameter("bcno"));
      
      
      // 2. 유효성검사/객체화
      BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno);
      
      
      // 3. Dao 처리
      
      // 4. (Dao 결과) 응답
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
   }

}