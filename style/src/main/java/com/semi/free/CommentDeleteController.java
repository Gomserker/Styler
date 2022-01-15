package com.semi.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/CommentDeleteController")
public class CommentDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeDAO.getFreedao().deleteComment(request);
		FreeDAO.getFreedao().countView(request);
		FreeDAO.getFreedao().getFreeDetail(request);
		FreeDAO.getFreedao().getComment(request);
		FreeDAO.getFreedao().countComment(request);
		FreeDAO.getFreedao().getNextFreeDetail(request);
		FreeDAO.getFreedao().getPrevFreeDetail(request);
		
		AccountDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "free/freeDetail.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
