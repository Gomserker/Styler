package com.semi.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.announce.AnnounceDAO;
import com.semi.login.AccountDAO;

@WebServlet("/QnaController")
public class QnaController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		if (request.getParameter("pageNum") == null) {
			page = 1;

		} else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}

		AccountDAO.loginCheck(request);
//		FreeDAO.getFreedao().paging(request);
		QnaDAO.getQnadao().paging(request);
//		FreeDAO.getFreedao().getNoticeList(page, request);
		QnaDAO.getQnadao().getNoticeList(page, request);
		request.setAttribute("contentPage", "qna/qna.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
