package com.semi.daily;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;
import com.semi.review.LikeDAO;
import com.semi.review.ReviewDAO;

@WebServlet("/DailyController")
public class DailyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
		DailyDAO.getAllDaily(request);
		DailyDAO.getUserPic(request);
		DailyDAO.getAllCommentCount(request);
		DailyLikeDAO.getAllLikeCount(request);
		request.setAttribute("contentPage", "daily/daily.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}