package controller.visitlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.VisitDto;

/**
 * Servlet implementation class VisitLogController
 */
@WebServlet("/VisitLogController") // 해당 서블릿(자바)/컨트롤러 클래스를 호출하는 HTTP 매핑주소
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitLogController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX의 DATA속성에 있는 객체 정보(속성명이름)을 호출하기 
		String vwriter = request.getParameter("vwriter"); System.out.println(vwriter);
		String vpwd = request.getParameter("vpwd"); System.out.println(vpwd);
		String vcontent = request.getParameter("vcontent"); System.out.println(vcontent);
		// 2. 객체화
		VisitDto visitLogDto = new VisitDto(vwriter, vpwd, vcontent);
		// 3. DAO 객체 전달 후 결과 응답받고
		
		// 4. 결과물 AJAX에게 응답한다.
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
