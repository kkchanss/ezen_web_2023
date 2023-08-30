package controller.hrm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HrmController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HrmDto> result = HrmDao.getInstance().hrmSelect();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getServletContext().getRealPath("/hrm/img");
		
		MultipartRequest m = new MultipartRequest(
				request, 
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		String hname = m.getParameter("hname"); System.out.println("hname : " + hname);
		String himg = m.getFilesystemName("himg"); 
		String hphone = m.getParameter("hphone");
		String hposition = m.getParameter("hposition");
		
		boolean result = HrmDao.getInstance().hrmWrite(hname, himg, hphone, hposition);
	
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
