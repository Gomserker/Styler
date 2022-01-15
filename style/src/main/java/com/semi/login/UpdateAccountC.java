package com.semi.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/UpdateAccountC")
public class UpdateAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/updateInfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        AccountDAO.update(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/info.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
