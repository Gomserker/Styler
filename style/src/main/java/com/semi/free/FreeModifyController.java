package com.semi.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/FreeModifyController")
public class FreeModifyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FreeDAO.getFreedao().getFreeDetail(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "free/freeModify.jsp");

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 업데이트
		FreeDAO.getFreedao().upadateFreeDetail(request);

		// 조회
		FreeDAO.getFreedao().paging(request);
		FreeDAO.getFreedao().getNoticeList(1,request);
		request.setAttribute("loginPage", "login/login.jsp");
		request.setAttribute("contentPage", "free/free.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
