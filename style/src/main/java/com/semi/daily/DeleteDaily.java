package com.semi.daily;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/DeleteDaily")
public class DeleteDaily extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
		//delete
		//view all
		
		DailyDAO.deleteDaily(request);
		DailyDAO.getAllDaily(request);
		
		//review.jsp濡� �룎�븘媛�寃� 蹂�寃�
		request.setAttribute("contentPage", "daily/daily.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
