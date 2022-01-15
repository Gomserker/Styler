package com.semi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB ���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �ؿ�

// �װ� AOP ���ڴ°� 

public class DBManager {
	
	// db�۾��ÿ��� ��¶�� ���� �ؾߵ� 
	public static Connection connect() throws SQLException, ClassNotFoundException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			return DriverManager.getConnection(url, "bg","bg");
	}
	
	// ������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
		}
	}
	
}
