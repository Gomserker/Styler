package com.semi.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.login.Account;
import com.semi.main.DBManager;



public class GameDAO {
	
	public static int coin() {
		Random rand = new Random();
		int num = (rand.nextInt(3)+1)*10;
		System.out.println("출석포인트" + num);
		
		return num;
		
	}

	public static void game(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// 포맷 적용
		String formatedNow = now.format(formatter);



		
		String sql = "update users set u_checkPoint=?, u_checkDate=? where u_id=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("checkPoint")) + coin());
			pstmt.setString(2, formatedNow);
			pstmt.setString(3, request.getParameter("id"));
			
			
			if (pstmt.executeUpdate() == 1) {
				String sql2 = "select * from users where u_id = ?";
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					String dbPW = rs.getString("u_pw");

					if (pw.equals(dbPW)) {

						Account a = new Account();
						a.setId(rs.getString("u_id"));
						a.setPw(rs.getString("u_pw"));
						a.setName(rs.getString("u_name"));
						a.setNickname(rs.getString("u_nickname"));
						a.setEmail(rs.getString("u_email"));
						a.setGender(rs.getString("u_gender"));
						a.setStyle(rs.getString("u_style"));
						a.setProfileImg(rs.getString("u_profileimg"));
						a.setTypeOfManger(rs.getString("u_typeOfManager"));
						a.setCheckPoint(rs.getString("u_checkpoint"));
						a.setCheckDate(rs.getString("u_checkDate"));

						HttpSession hs = request.getSession();
						hs.setAttribute("accountInfo", a);
						hs.setMaxInactiveInterval(1800);

						System.out.println("수정성공");
					}
				}

			} else {
				System.out.println("출석실패");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB문제");

		} finally {
			DBManager.close(con, pstmt, rs);
		}

		
	}

}
