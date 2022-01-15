package com.semi.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignOut")
public class SignOut extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//È¸¿øÅ»Åð ÆäÀÌÁö·Î ÀÌµ¿ÇÏ´Â getÀÔ´Ï´Ù.
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("login/signOut.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//È¸¿øÅ»Åð¸ðµ¨
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "home/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
