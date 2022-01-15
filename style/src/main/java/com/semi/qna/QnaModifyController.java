package com.semi.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/QnaModifyController")
public class QnaModifyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		FreeDAO.getFreedao().getFreeDetail(request);
		QnaDAO.getQnadao().getFreeDetail(request);
		AccountDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "qna/qnaModify.jsp");

		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업데이트
//		FreeDAO.getFreedao().upadateFreeDetail(request);
		QnaDAO.getQnadao().upadateFreeDetail(request);

		// 조회
//		FreeDAO.getFreedao().paging(request);
		QnaDAO.getQnadao().paging(request);
//		FreeDAO.getFreedao().getNoticeList(1,request);
		QnaDAO.getQnadao().getNoticeList(1, request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "qna/qna.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
