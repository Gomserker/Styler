package com.semi.announce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;

@WebServlet("/AnnounceController")
public class AnnounceController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 0;
		if (request.getParameter("pageNum") == null) {
			page = 1;

		} else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}

		AccountDAO.loginCheck(request);
//		FreeDAO.getFreedao().paging(request);
		AnnounceDAO.getAnouncedao().paging(request);
//		FreeDAO.getFreedao().getNoticeList(page, request);
		AnnounceDAO.getAnouncedao().getNoticeList(page, request);
		request.setAttribute("contentPage", "announce/announce.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
