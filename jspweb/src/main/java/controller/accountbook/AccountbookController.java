package controller.accountbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;

import model.dao.AccountbookDao;
import model.dto.AccountbookDto;

/**
 * Servlet implementation class AccountbookController
 */
@WebServlet("/AccountbookController")
public class AccountbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountbookController() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AccountbookDto> result = AccountbookDao.getInstance().aread();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int amoney = Integer.parseInt(request.getParameter("amoney")); 
		String aday = request.getParameter("aday");
		String acontent = request.getParameter("acontent");
	
		boolean result = AccountbookDao.getInstance().awrite(amoney, acontent, aday);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		String acontent = request.getParameter("acontent");
		
		boolean result = AccountbookDao.getInstance().aupdate(ano, acontent);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		boolean result = AccountbookDao.getInstance().adelete(ano);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
	}

}
