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


@WebServlet("/WriteDaily")
public class WriteDaily extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		DailyDAO.getAllDaily(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "daily/dailyWrite.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		DailyDAO.writeDaily(request);
		DailyDAO.getAllDaily(request);
		DailyDAO.getAllCommentCount(request);
		LikeDAO.getAllLikeCount(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "daily/daily.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}