package com.semi.announce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.free.Comment;
import com.semi.free.Post;
import com.semi.main.DBManager;

public class AnnounceDAO {

	// �̱��� ��ü ����ϱ�

	private ArrayList<Post> posts;
	private ArrayList<Integer> page_;

	private static final AnnounceDAO ANOUNCEDAO = new AnnounceDAO();

	public AnnounceDAO() {
	}

	public static AnnounceDAO getAnouncedao() {
		return ANOUNCEDAO;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public ArrayList<Integer> getPage_() {
		return page_;
	}

	public void setPage_(ArrayList<Integer> page_) {
		this.page_ = page_;
	}

	public void getFreeDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from postA where p_no =?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			Post p = null;
			if (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
				p.setP_view_count(rs.getInt("p_view_count"));

			}
			request.setAttribute("p", p);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getNextFreeDetail(HttpServletRequest request) {
		// ������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from postA where p_date >(select p_date from post where p_no =?)and rownum = 1";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			Post p = null;
			if (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
			}
			request.setAttribute("nextP", p);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getPrevFreeDetail(HttpServletRequest request) {
		// ������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select * from postA order by p_date desc) "
				+ "	where p_date <(select p_date from postA where p_no =?) and rownum =1";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			Post p = null;
			if (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
			}
			request.setAttribute("prevP", p);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void writeFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into postA values(post_seq.nextval, ?, ?, ?, sysdate, '�ڸ�Ʈt', ?, '0')";

		try {
			String saveDirectory = request.getSession().getServletContext().getRealPath("announce/img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			System.out.println(mr.getParameter("title"));
			System.out.println(mr.getParameter("text"));
			System.out.println(mr.getFilesystemName("img"));
			System.out.println(mr.getParameter("user"));

			pstmt.setString(1, mr.getParameter("title"));
			pstmt.setString(2, mr.getParameter("text"));
			pstmt.setString(3, mr.getFilesystemName("img"));
			pstmt.setString(4, mr.getParameter("user"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��ϼ���");
			} else {
				System.out.println("��Ͻ���");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void getNoticeList(int page, HttpServletRequest request) {
		// ?~? �Խñ�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from ( select rownum num, P.* from (select * from postA order by p_date desc) P)"
				+ " where num between ? and ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1 + (page - 1) * 10);
			pstmt.setInt(2, page * 10);
			rs = pstmt.executeQuery();

			posts = new ArrayList<Post>();
			Post p = null;
			while (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
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

	public void doSearch(int page, HttpServletRequest request) {
		// ?~? �Խñ�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String searchType = request.getParameter("selected");

		String sql = "select * from ( select rownum num, P.* from (select * from postA where " + searchType
				+ " like '%'||?||'%' order by p_date desc) P)" + " where num between ? and ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("searchText"));
			pstmt.setInt(2, 1 + (page - 1) * 10);
			pstmt.setInt(3, page * 10);
			rs = pstmt.executeQuery();

			posts = new ArrayList<Post>();

			Post p = null;
			while (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_user(rs.getString("p_user"));
				p.setP_date(rs.getDate("p_date"));

				posts.add(p);
			}

			request.setAttribute("posts", posts);
			//request.setAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void paging(HttpServletRequest request) {

		// ��������ȣó��
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
		int pagePerList = 10;

		// ��ü�Խù� ����, ����������
		int totalContent = 0;
		int totalPage = 0;
		
		//������ �ѱ������ �Ķ���Ͱ� ����
		int pageNum = 0;
		if (request.getParameter("pageNum")==null) {
			 pageNum = 1;
		}
		else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		System.out.println(pageNum);
		
		//����¡ ��� ����
		int currentBlock = 0;
		int pageBlockLength = 2;
		int startPage = 0;
		int endPage = 0;
		
		
		
		// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����

		String sql = "select count(*) from postA";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				totalContent += rs.getInt(1);

			}

			// �������� ���
			totalPage = totalContent / pagePerList;
			if (totalContent % pagePerList > 0) {
				totalPage++;
			}
			
			// ������ ó���� ���� �����ϴ� �κ�
			 currentBlock = pageNum % pageBlockLength == 0 ? pageNum / pageBlockLength : (pageNum / pageBlockLength) + 1;
			 startPage = (currentBlock - 1) * pageBlockLength + 1;
			 endPage = startPage + pageBlockLength - 1;
			// ������ ������ �������� �� ���������� �Ѿ�� �� �������� ������ ������ ���ڷ� ����
			if (endPage > totalPage) {
			    endPage = totalPage;
			}
			System.out.println(currentBlock);
			System.out.println("--------");
			System.out.println(startPage);
			System.out.println(endPage);

			// ����¡ ����Ʈ ���

			page_ = new ArrayList<Integer>();

			
			for (int i = startPage; i < endPage+1 ; i++) {
				page_.add(i);
			}
			System.out.println(page_);

			request.setAttribute("startEnd", page_);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("totalPage", totalPage);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void searchPaging(HttpServletRequest request) {

		// ��������ȣó��
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
		int pagePerList = 10;

		// ��ü�Խù� ����, ����������
		int totalContent = 0;
		int totalPage = 0;

		// ����������
		int startPage = 1;

		// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
		String searchType = request.getParameter("selected");
		String searchText = request.getParameter("searchText");
		String sql = "select count(*) from postA where " + searchType + " like '%'||?||'%' order by p_date desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchText);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				totalContent += rs.getInt(1);

			}

			// �������� ���
			startPage = 1;
			totalPage = totalContent / pagePerList;
			if (totalContent % pagePerList > 0) {
				totalPage++;
			}

			// ����¡ ����Ʈ ���

			page_ = new ArrayList<Integer>();

			for (int i = startPage; i <= totalPage; i++) {
				int j = i;
				page_.add(j);

			}

			System.out.println("----------------");
			System.out.println(page_);
			System.out.println(searchText);

			request.setAttribute("startEnd", page_);
			request.setAttribute("selected", searchType);
			request.setAttribute("searchText", searchText);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void upadateFreeDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		// ��¥ date������
		// r_date=sysdate�߰�
		String sql = "update postA set p_title=?, p_text=?, p_img=? where p_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String saveDirectory = request.getSession().getServletContext().getRealPath("announce/img");
			System.out.println(saveDirectory);

			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			System.out.println(mr.getParameter("title"));
			System.out.println(mr.getParameter("text"));
			System.out.println(mr.getFilesystemName("img"));
			System.out.println(mr.getParameter("no"));

			pstmt.setString(1, mr.getParameter("title"));
			pstmt.setString(2, mr.getParameter("text"));
			pstmt.setString(3, mr.getFilesystemName("img"));
			pstmt.setString(4, mr.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��������");
			} else {
				System.out.println("��������");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void deleteFreeDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		// ��¥ date������
		// r_date=sysdate�߰�
		String sql = "delete postA where p_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void writeComment(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into comments_postA values(comments_seq.nextval, ?, sysdate, ?, ?)";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("c_text"));
			pstmt.setString(2, request.getParameter("c_user"));
			pstmt.setString(3, request.getParameter("c_post"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��ϼ���");
			} else {
				System.out.println("��Ͻ���");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void getComment(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// String no = null;
		// no = request.getParameter("no");

		String sql = "select * from comments_postA where c_post = ? order by c_date desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			ArrayList<Comment> comments = new ArrayList<>();
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

			/*
			 * for (Comment test : comments) {
			 * 
			 * System.out.println(test.getC_text()); System.out.println(test.getC_users());
			 * System.out.println(test.getC_no()); System.out.println(test.getC_post());
			 * 
			 * 
			 * }
			 */

			request.setAttribute("comments", comments);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void countComment(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from comments_postA where c_post = ?";

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

	public void countView(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update postA set p_view_count = p_view_count + 1  where p_no=?";

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

	public void modifyComment(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		String sql = "update comments_postA set c_text = ? where c_no = ?";
		

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
	
public void deleteComment(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		// ��¥ date������
		// r_date=sysdate�߰�
		String sql = "delete comments_postA where c_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("cno"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��ۻ�������");
			} else {
				System.out.println("��ۻ�������");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	


}
