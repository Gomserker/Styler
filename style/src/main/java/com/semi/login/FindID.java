package com.semi.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.detailSearch.DetailDAO;

@WebServlet("/FindID")
public class FindID extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "login/findID.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDAO.loginCheck(request);
		AccountDAO.findID(request);
		request.setAttribute("contentPage", "login/findIDResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
