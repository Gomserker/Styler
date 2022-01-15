package com.semi.announce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.free.FreeDAO;
import com.semi.login.AccountDAO;

@WebServlet("/AnnounceSearchController")
public class AnnounceSearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 셀렉트로 받아온 파라미터로 조회하는 모델(출력까지)

				// 검색
				int page = 0;

				if (request.getParameter("pageNum") == null) {
					page = 1;
				} else {
					page = Integer.parseInt(request.getParameter("pageNum"));
				}
				AccountDAO.loginCheck(request);
//				FreeDAO.getFreedao().doSearch(page, request);
				AnnounceDAO.getAnouncedao().doSearch(page, request);
//				FreeDAO.getFreedao().searchPaging(request);
				AnnounceDAO.getAnouncedao().searchPaging(request);

				request.setAttribute("contentPage", "announce/announce.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
