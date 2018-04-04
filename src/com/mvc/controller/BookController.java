package com.mvc.controller;

import java.util.ArrayList;

import com.mvc.model.dao.BookDao;
import com.mvc.model.vo.Book;
import com.mvc.view.BookMenu;

public class BookController {
	private Book b;
	private int bid;
	private ArrayList<Book> list;
	private int result;
	
	public BookController() {
		// TODO Auto-generated constructor stub
	}

	public void insertBook() {
		b=new BookMenu().inputBook();
		result=new BookDao().inertBook(b);
		
		if(result>0){
			new BookMenu().displaycheck("성공");
		}
		else{
			new BookMenu().displaycheck("실패");
		}
		
	}

	public void updateBook(){
		b=new BookMenu().updateBook();
		result=new BookDao().updateBook(b);
		
		if(result>0){
			new BookMenu().displaycheck("성공");
		}
		else{
			new BookMenu().displaycheck("실패");
		}
	}

	public void deleteBook() {
		bid=new BookMenu().inputBookId();
		result=new BookDao().deleteBook(bid);
		
		if(result>0){
			new BookMenu().displaycheck("성공");
		}
		else{
			new BookMenu().displaycheck("실패");
		}
		
	}

	public void searchBook() {
		
		bid=new BookMenu().inputBookId();
		b=new BookDao().selectBook(bid);
		
		if(b!=null){
			new BookMenu().displayBook(b);
		}
		else{
			new BookMenu().displaycheck("실패");
		}
	}

	public void searchBookTitle() {
		String btitle=new BookMenu().inputBookTitle();
		list=new BookDao().searchBookTitle(btitle);
		
		if(list.size()>0){
			new BookMenu().displayBooks(list);
		}
		else{
			new BookMenu().displaycheck("실패");
		}
	}

	public void selectAll() {
		list=new BookDao().selectAllBooks();
		if(list.size()>0){
			new BookMenu().displayBooks(list);
		}
		else{
			new BookMenu().displaycheck("실패");
		}
	}
}
