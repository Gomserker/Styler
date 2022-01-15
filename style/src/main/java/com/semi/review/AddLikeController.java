package com.semi.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;

/**
 * Servlet implementation class likeController
 */
@WebServlet("/AddLikeController")
public class AddLikeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LikeDAO.addLike(request);
		ReviewDAO.getReviewDetail(request);
		ReviewCommentDAO.getComment(request);
		ReviewCommentDAO.countComment(request);
		LikeDAO.countLike(request);
		LikeDAO.checkLike(request);
		AccountDAO.loginCheck(request);
		ReviewDAO.getViewCount(request);
		request.setAttribute("contentPage", "review/reviewDetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
