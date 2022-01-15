package com.semi.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.review.LikeDAO;
import com.semi.review.ReviewDAO;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			AccountDAO.logOut(request);
			AccountDAO.loginCheck(request);
			
			request.setAttribute("contentPage", "home/home.jsp");
			request.getRequestDispatcher("login/signInNext.jsp").forward(request, response);
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.login(request);
		AccountDAO.loginCheck(request);
		ReviewDAO.getAllReview(request);
		ReviewDAO.getUserPic(request);
		ReviewDAO.getAllCommentCount(request);
		LikeDAO.getAllLikeCount(request);
		
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
