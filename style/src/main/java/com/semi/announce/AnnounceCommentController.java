package com.semi.announce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;

@WebServlet("/AnnounceCommentController")
public class AnnounceCommentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		FreeDAO.getFreedao().writeComment(request);
		AnnounceDAO.getAnouncedao().writeComment(request);
//		FreeDAO.getFreedao().getFreeDetail(request);
		AnnounceDAO.getAnouncedao().getFreeDetail(request);
//		FreeDAO.getFreedao().getComment(request);
		AnnounceDAO.getAnouncedao().getComment(request);
//		FreeDAO.getFreedao().countComment(request);
		AnnounceDAO.getAnouncedao().countComment(request);
//		FreeDAO.getFreedao().getNextFreeDetail(request);
		AnnounceDAO.getAnouncedao().getNextFreeDetail(request);
//		FreeDAO.getFreedao().getPrevFreeDetail(request);
		AnnounceDAO.getAnouncedao().getPrevFreeDetail(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "announce/announceDetail.jsp");

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
