package com.semi.announce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;

@WebServlet("/AnnounceWriteController")
public class AnnounceWriteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO.loginCheck(request);

		request.setAttribute("contentPage", "announce/announceWrite.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 삽입

//				FreeDAO.getFreedao().writeFree(request);
		AnnounceDAO.getAnouncedao().writeFree(request);
//				//페이징
//				FreeDAO.getFreedao().paging(request);
		AnnounceDAO.getAnouncedao().paging(request);
//				//전부나타내기
//				FreeDAO.getFreedao().getNoticeList(1,request);
		AnnounceDAO.getAnouncedao().getNoticeList(1, request);

		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "announce/announce.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
