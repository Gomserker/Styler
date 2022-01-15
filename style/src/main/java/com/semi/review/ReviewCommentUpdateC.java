package com.semi.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;


@WebServlet("/ReviewCommentUpdateC")
public class ReviewCommentUpdateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewCommentDAO.updateComment(request);
		
		ReviewDAO.getReviewDetail(request);
		ReviewCommentDAO.getComment(request);
		ReviewCommentDAO.countComment(request);
		
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "review/reviewDetail.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
