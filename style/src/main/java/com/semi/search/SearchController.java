package com.semi.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;
import com.semi.review.ReviewDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.loginCheck(request);
		if(request.getParameter("postMain").equals("리뷰")) {
			ReviewDAO.getAllReview(request);
			//ReviewSearch.search(request);
			request.setAttribute("contentPage", "review/review.jsp");
			
		}else if(request.getParameter("postMain").equals("데일리")) {
			request.setAttribute("contentPage", "daily/daily.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//셀렉트된 게시판 받아서 어트리뷰트 설정하는 모델
		//셀렉트된 색상 받아서 어트리뷰트 설정하는 모델
		//전체 조회
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
