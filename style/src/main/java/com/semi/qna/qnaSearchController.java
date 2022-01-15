package com.semi.qna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/qnaSearchController")
public class qnaSearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 셀렉트로 받아온 파라미터로 조회하는 모델(출력까지)

		// 검색
		int page = 0;

		if (request.getParameter("pageNum") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}
		AccountDAO.loginCheck(request);
//		FreeDAO.getFreedao().doSearch(page, request);
		QnaDAO.getQnadao().doSearch(page, request);
//		FreeDAO.getFreedao().searchPaging(request);
		QnaDAO.getQnadao().searchPaging(request);

		request.setAttribute("contentPage", "qna/qna.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
