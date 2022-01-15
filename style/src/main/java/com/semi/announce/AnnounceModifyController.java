package com.semi.announce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;

@WebServlet("/AnnounceModifyController")
public class AnnounceModifyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		FreeDAO.getFreedao().getFreeDetail(request);
		AnnounceDAO.getAnouncedao().getFreeDetail(request);
		AccountDAO.loginCheck(request);
		request.getParameter("title");
		request.setAttribute("contentPage", "announce/announceModify.jsp");

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 업데이트
//		FreeDAO.getFreedao().upadateFreeDetail(request);
		AnnounceDAO.getAnouncedao().upadateFreeDetail(request);

		// 조회
//		FreeDAO.getFreedao().paging(request);
		AnnounceDAO.getAnouncedao().paging(request);
//		FreeDAO.getFreedao().getNoticeList(1,request);
		AnnounceDAO.getAnouncedao().getNoticeList(1, request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "announce/announce.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
