package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.vo.Book;
import com.mvc.util.DBConnect;
import com.mvc.util.DBQuery;

public class BookDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ArrayList<Book> list;

	public BookDao() {
		// TODO Auto-generated constructor stub
	}

	public int inertBook(Book b) {
		int result = 0;
		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("inertBook"));
			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getAuthor());
			psmt.setString(3, b.getPublisher());
			psmt.setDate(4, b.getPublish_date());
			psmt.setInt(5, b.getPrice());
			result = psmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

			DBConnect.disConnect(psmt, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int updateBook(Book b) {
		int result = 0;
		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("updateBook"));
			psmt.setString(1, b.getAuthor());
			psmt.setInt(2, b.getPrice());
			psmt.setInt(3, b.getBook_id());
			result = psmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			DBConnect.disConnect(psmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteBook(int bid) {
		int result = 0;
		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("deleteBook"));
			psmt.setInt(1, bid);
			result = psmt.executeUpdate();
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			DBConnect.disConnect(psmt, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Book> selectAllBooks() {
		list = new ArrayList<Book>();
		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("selectAllBooks"));
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBook_id(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublish_date(rs.getDate("publish_date"));
				b.setPrice(rs.getInt("price"));
				list.add(b);
			}
			DBConnect.disConnect(rs, psmt, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Book> searchBookTitle(String bookTitle) {
		list = null;

		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("searchBookTitle"));
			psmt.setString(1, bookTitle);
			int result = psmt.executeUpdate();
			ResultSet rs = null;
			if (result > 0) {
				Book b = new Book();
				list = new ArrayList<Book>();
				rs = psmt.executeQuery();
				rs.next();
				b = new Book();
				b.setBook_id(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublish_date(rs.getDate("publish_date"));
				b.setPrice(rs.getInt("price"));
				list.add(b);
			}
			DBConnect.disConnect(rs, psmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book selectBook(int bookId) {
		Book b = null;
		try {
			conn = DBConnect.getConnect();
			psmt = conn.prepareStatement(DBQuery.getQuery().getProperty("selectBook"));
			psmt.setInt(1, bookId);
			int result = psmt.executeUpdate();
			ResultSet rs = null;
			if (result > 0) {
				rs = psmt.executeQuery();
				rs.next();
				b = new Book();
				b.setBook_id(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublish_date(rs.getDate("publish_date"));
				b.setPrice(rs.getInt("price"));
			}
			DBConnect.disConnect(rs, psmt, conn);	//정적클래스로
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
}
