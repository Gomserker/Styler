package com.semi.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.announce.AnnounceDAO;
import com.semi.login.AccountDAO;

@WebServlet("/QnaCommentDeleteController")
public class QnaCommentDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		FreeDAO.getFreedao().deleteComment(request);
		QnaDAO.getQnadao().deleteComment(request);
//		FreeDAO.getFreedao().countView(request);
		QnaDAO.getQnadao().countView(request);
//		FreeDAO.getFreedao().getFreeDetail(request);
		QnaDAO.getQnadao().getFreeDetail(request);
//		FreeDAO.getFreedao().getComment(request);
		QnaDAO.getQnadao().getComment(request);
//		FreeDAO.getFreedao().countComment(request);
		QnaDAO.getQnadao().countComment(request);
//		FreeDAO.getFreedao().getNextFreeDetail(request);
		QnaDAO.getQnadao().getNextFreeDetail(request);
//		FreeDAO.getFreedao().getPrevFreeDetail(request);
		QnaDAO.getQnadao().getPrevFreeDetail(request);
		AccountDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "qna/qnaDetail.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
