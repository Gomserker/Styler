package com.semi.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.semi.main.DBManager;

public class LikeDAO {

public static void addLike(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			String sql = "insert into likebox values(likebox_seq.nextval, '1', sysdate, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			String user = request.getParameter("mynick");
			String post = request.getParameter("no");
			
			pstmt.setString(1, user);
			pstmt.setString(2, post);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("좋아요 성공");
			} else {
				System.out.println("좋아요 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db error");
		} finally {
			DBManager.close(con, pstmt, null);
		}
}
		
		public static void countLike(HttpServletRequest request) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select count(*) from likebox where l_post = ?";

			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("no"));
				rs = pstmt.executeQuery();
				int totalLike = 0;

				if (rs.next()) {

					totalLike = rs.getInt(1);

				}

				request.setAttribute("totalLike", totalLike);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}

		
}

		public static void checkLike(HttpServletRequest request) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String mynick = null;
			if(request.getParameter("mynick") == null) {
				mynick="guest";
			}
			else {
				mynick = request.getParameter("mynick");
			}
			String sql = "select l_checkstatus, l_users from likebox where l_post = ?" ;

			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("no"));
				rs = pstmt.executeQuery();
				
				
				
				ArrayList<CheckLike> cl = new ArrayList<>();
				
				CheckLike c = null;
				while(rs.next()) {
					c = new CheckLike();
					c.setLuser(rs.getString("l_users"));
					c.setLcheckStatus(rs.getString("l_checkstatus"));
					cl.add(c);
				}
				
				System.out.println("---");
				System.out.println(mynick);
				System.out.println("---");
				
				
				for (CheckLike i : cl) {
					
					
					if (mynick.equals(i.getLuser()) ) {
						request.setAttribute("likecheck", "alreadyliked");
						System.out.println("좋아요한적있음");
						break;
						
					}
					else {
						request.setAttribute("likecheck", "neverliked");
						System.out.println("좋아요한적없음");
						
					}
				}
				
				


			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}
		}

		public static void deleteLike(HttpServletRequest request) {

			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String username = request.getParameter("mynick");
			
			String sql = "delete likebox where l_post=? and l_users='"+username+"'";

			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("no"));

				if (pstmt.executeUpdate() == 1) {
					System.out.println("좋아요취소성공");
				} else {
					System.out.println("좋아요취소실패");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("DB문제");

			} finally {
				DBManager.close(con, pstmt, null);
			}
		}
		
public static void getAllLikeCount(HttpServletRequest request) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DBManager.connect();
				
				String sql = "SELECT l_post , count(*) nol FROM likebox group by l_post";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				ArrayList<AllLikeCount> alcs = new ArrayList<>();
				
				AllLikeCount alc = null;
				while(rs.next()) {
					alc = new AllLikeCount();
					alc.setPostNo(rs.getString("l_post"));
					alc.setNumberOfLike(rs.getString("nol"));
					alcs.add(alc);
				}
				
				request.setAttribute("alcs", alcs);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}
}
}
	
