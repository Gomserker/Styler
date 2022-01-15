package com.semi.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.semi.free.Post;
import com.semi.main.DBManager;

public class ReviewSearch {

	public static void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		String sql = "select * from post_review where p_title like '%'||?||'%' order by p_date desc" ;
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("searchMain"));
			
			rs = pstmt.executeQuery();
			
			ArrayList<Post> posts = new ArrayList<Post>();
			Post p = null;
			while (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_comment(rs.getString("p_comment"));
				p.setP_img(rs.getString("p_img"));
				p.setP_user(rs.getString("p_user"));
				p.setP_date(rs.getDate("p_date"));
				
				posts.add(p);
			}
			
			request.setAttribute("posts", posts);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	
	
}
