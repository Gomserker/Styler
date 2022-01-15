package com.semi.detailSearch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.daily.DailyDAO;
import com.semi.daily.DailyLikeDAO;
import com.semi.login.AccountDAO;
import com.semi.review.LikeDAO;
import com.semi.review.ReviewDAO;

@WebServlet("/DateSearch")
public class DateSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		
		AccountDAO.loginCheck(request);
		DetailDAO.getOrderDate_Review(request);
		ReviewDAO.getUserPic(request);
		ReviewDAO.getAllCommentCount(request);
		LikeDAO.getAllLikeCount(request);
		
		
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
