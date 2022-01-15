package com.semi.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.AccountDAO;
import com.semi.review.ReviewDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.loginCheck(request);
		if(request.getParameter("postMain").equals("����")) {
			ReviewDAO.getAllReview(request);
			//ReviewSearch.search(request);
			request.setAttribute("contentPage", "review/review.jsp");
			
		}else if(request.getParameter("postMain").equals("���ϸ�")) {
			request.setAttribute("contentPage", "daily/daily.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//����Ʈ�� �Խ��� �޾Ƽ� ��Ʈ����Ʈ �����ϴ� ��
		//����Ʈ�� ���� �޾Ƽ� ��Ʈ����Ʈ �����ϴ� ��
		//��ü ��ȸ
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
