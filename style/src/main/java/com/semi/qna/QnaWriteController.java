package com.semi.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/QnaWriteController")
public class QnaWriteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "qna/qnaWrite.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삽입
		
//		FreeDAO.getFreedao().writeFree(request);
		QnaDAO.getQnadao().writeFree(request);
//		//페이징
//		FreeDAO.getFreedao().paging(request);
		QnaDAO.getQnadao().paging(request);
//		//전부나타내기
//		FreeDAO.getFreedao().getNoticeList(1,request);
		QnaDAO.getQnadao().getNoticeList(1, request);
		
		
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "qna/qna.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
