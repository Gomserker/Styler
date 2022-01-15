package com.semi.detailSearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.semi.daily.Daily;
import com.semi.main.DBManager;
import com.semi.review.Review;

public class DetailDAO {

	public static void getAllReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_review where p_text like '%'||?||'%'"
				+ " or p_title like '%'||?||'%' order by p_date desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			
			
			pstmt.setString(1, title);
			pstmt.setString(2, title);
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				reviews.add(r);

			}

			request.setAttribute("reviews", reviews);
			System.out.println("리뷰  검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰  검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getAllDaily(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_daily where p_text like '%'||?||'%'"
				+ " or p_title like '%'||?||'%' order by p_date desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			
			
			pstmt.setString(1, title);
			pstmt.setString(2, title);
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				reviews.add(r);

			}

			request.setAttribute("daily", reviews);
			System.out.println("데일리 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데일리 검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getOrderView_Review(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_review order by p_view_count desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				r.setDate(rs.getDate("p_date"));
				reviews.add(r);

			}

			request.setAttribute("reviews", reviews);
			System.out.println("리뷰  검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰  검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void getOrderView_Daily(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_daily order by p_view_count desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				r.setDate(rs.getDate("p_date"));
				reviews.add(r);

			}

			request.setAttribute("daily", reviews);
			System.out.println("데일리 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데일리 검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getOrderDate_Review(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_review order by p_date desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				reviews.add(r);

			}

			request.setAttribute("reviews", reviews);
			System.out.println("리뷰  검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰  검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void getOrderDate_Daily(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_daily order by p_date desc";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				r.setDate(rs.getDate("p_date"));
				reviews.add(r);

			}

			request.setAttribute("daily", reviews);
			System.out.println("데일리 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데일리 검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void getOrderRandom_Review(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_review order by DBMS_RANDOM.RANDOM";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				r.setDate(rs.getDate("p_date"));
				reviews.add(r);

			}

			request.setAttribute("reviews", reviews);
			System.out.println("리뷰  검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리뷰  검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void getOrderRandom_Daily(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from post_daily order by DBMS_RANDOM.RANDOM";

		try {
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			
			
		
			rs = pstmt.executeQuery();

			ArrayList<Review> reviews = new ArrayList<Review>();
			Review r = null;

			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getString("p_no"));
				r.setTitle(rs.getString("p_title"));
				r.setText(rs.getString("p_text"));
				r.setGood(rs.getString("p_good"));
				r.setTop(rs.getString("p_top"));
				r.setPants(rs.getString("p_pants"));
				r.setShoes(rs.getString("p_shoes"));
				r.setAccessary(rs.getString("p_accessary"));
				r.setHashtag(rs.getString("p_hashtag"));
				r.setImg(rs.getString("p_img"));
				r.setItem(rs.getString("p_item"));
				r.setComment(rs.getString("p_comment"));
				r.setUser(rs.getString("p_user"));
				r.setDate(rs.getDate("p_date"));
				reviews.add(r);

			}

			request.setAttribute("daily", reviews);
			System.out.println("데일리 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데일리 검색 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}
