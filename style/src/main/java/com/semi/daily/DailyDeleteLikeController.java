package com.semi.daily;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

@WebServlet("/DailyDeleteLikeController")
public class DailyDeleteLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DailyLikeDAO.deleteLike(request);
		DailyDAO.getDailyDetail(request);
		DailyCommentDAO.getComment(request);
		DailyCommentDAO.countComment(request);
		DailyLikeDAO.countLike(request);
		DailyLikeDAO.checkLike(request);
		AccountDAO.loginCheck(request);
		DailyDAO.getViewCount(request);
		request.setAttribute("contentPage", "daily/dailyDetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
