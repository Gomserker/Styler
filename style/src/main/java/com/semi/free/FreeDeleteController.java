package com.semi.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

/**
 * Servlet implementation class FreeDeleteController
 */
@WebServlet("/FreeDeleteController")
public class FreeDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ����
				FreeDAO.getFreedao().deleteFreeDetail(request);

				// ��ȸ
				FreeDAO.getFreedao().paging(request);
				FreeDAO.getFreedao().getNoticeList(1,request);
				AccountDAO.loginCheck(request);
				request.setAttribute("contentPage", "free/free.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
