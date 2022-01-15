package com.semi.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;


@WebServlet("/WritePost")
public class WritePost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//����ȸ
		ReviewDAO.getAllReview(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "review/reviewWrite.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���Է�
		//����ȸ
		
		ReviewDAO.writeReview(request);
		ReviewDAO.getAllReview(request);
		ReviewDAO.getUserPic(request);
		ReviewDAO.getAllCommentCount(request);
		LikeDAO.getAllLikeCount(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
