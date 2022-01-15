package com.semi.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.semi.free.Comment;
import com.semi.main.DBManager;

public class ReviewCommentDAO {

	public static void writeComment(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			String sql = "insert into comments_post_review values(comments_seq.nextval, ?, sysdate, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			String text = request.getParameter("text");
			String user = request.getParameter("user");
			String post = request.getParameter("post");
			
			pstmt.setString(1, text);
			pstmt.setString(2, user);
			pstmt.setString(3, post);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("write complete");
			} else {
				System.out.println("write failed");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db error");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void getComment(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from comments_post_review where c_post = ? order by c_date desc";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			
			ArrayList<Comment> comments = new ArrayList<Comment>();
			Comment c = null;
			while (rs.next()) {
				
				c = new Comment();
				c.setC_no(rs.getString("c_no"));
				c.setC_text(rs.getString("c_text"));
				c.setC_users(rs.getString("c_users"));
				c.setC_post(rs.getString("c_post"));
				c.setC_date(rs.getDate("c_date"));
				
				comments.add(c);
			}
				
			request.setAttribute("comments", comments);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void countView(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update review_post set p_view_count = p_view_count + 1  where p_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��ȸ�� +1");

			} else {
				System.out.println("������Ʈ����");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}
	
	public static void countComment(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from comments_post_review where c_post = ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			int totalComment = 0;

			if (rs.next()) {

				totalComment = rs.getInt(1);

			}

			request.setAttribute("totalComment", totalComment);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void updateComment(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update comments_post_review set c_text = ? where c_no = ?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("c_text"));
			pstmt.setString(2, request.getParameter("c_no"));
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void deleteComment(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete comments_post_review where c_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("cno"));
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("comment deleted");
			} else {
				System.out.println("comment delete failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db error");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	

	
	
}
