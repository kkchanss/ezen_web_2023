package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;

/**
 * Servlet implementation class VisitController
 */
@WebServlet("/VisitLogController")
public class VisitLogController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitLogController() {
        super();
        // TODO Auto-generated constructor stub
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	  ArrayList<VisitDto> result = VisitDao.getInstance().vread();
	  
	  ObjectMapper objectMapper = new ObjectMapper();
	  String jsonArray = objectMapper.writeValueAsString(result);
      //response.setContentType("text/html;charset=UTF-8");
	  response.setContentType("application/json;charset=UTF-8");
      response.getWriter().print( jsonArray );
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      //doGet(request, response);
      String vweiter = request.getParameter("vwriter");
      String v1 = request.getParameter("vpwd");
      String v2= request.getParameter("vcontent");
      response.setContentType("text/html;charset=UTF-8");
      response.getWriter().print( (VisitDao.getInstance().vwrite(new VisitDto(vweiter,v1,v2)) ?"성공":"실패" ));
      
      
   }

   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int vno = Integer.parseInt(request.getParameter("vno")); 
	   String vcontent = request.getParameter("vcontent");
	   String vpwd = request.getParameter("vpwd");
	   
	   boolean result = VisitDao.getInstance().vupdate(vno, vcontent, vpwd);
	   response.setContentType("text/html;charset=UTF-8");
	   response.getWriter().print(result);
	   
   }

   protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html;charset=UTF-8");
	      boolean result  = VisitDao.getInstance().vdelete(Integer.parseInt(request.getParameter("vno")), request.getParameter("vpwd"));
	     
   		  response.getWriter().print(result);
   }

   
}