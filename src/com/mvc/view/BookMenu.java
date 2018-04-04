package com.mvc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.mvc.controller.BookController;
import com.mvc.model.vo.Book;

public class BookMenu {
	private Scanner sc;
	
	public BookMenu() {
		sc=new Scanner(System.in);
	}
	public void displayMenu(){
		
		do {
			
			System.out.println("1. 도서추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회 ");
			System.out.println("6. 도서 목록 전체조회");
			System.out.println("9. 끝내기");
			
			System.out.println("번호선택:");
			int choice=sc.nextInt();
			
			switch (choice) {
			
			case 1:
				new BookController().insertBook();
				break;
			case 2:
				new BookController().updateBook();
				break;
			case 3:
				new BookController().deleteBook();
				break;
			case 4:
				new BookController().searchBook();
				break;
			case 5:
				new BookController().searchBookTitle();
				break;
			case 6:
				new BookController().selectAll();
				break;
			case 9:
				System.out.println("종료");
				return;
				
			default:
				System.out.println("다시입력");
				break;
			}
		} while (true);
	}

	public Book inputBook() {
		Book book=new Book();
		
		System.out.print("제목: ");
		book.setTitle(sc.nextLine());
		System.out.print("출판사: ");
		book.setAuthor(sc.nextLine());
		System.out.print("저자: ");
		book.setPublisher(sc.nextLine());
		System.out.println("출판일: ");
		book.setPublish_date(Date.valueOf(sc.nextLine()));
		System.out.print("가격: ");
		book.setPrice(sc.nextInt());
		return book;
	}

	public Book updateBook() {
		Book book=new Book();
		book.setBook_id(this.inputBookId());
		sc.nextLine();
		System.out.print("출판사: ");
		book.setAuthor(sc.nextLine());
		System.out.print("가격: ");
		book.setPrice(sc.nextInt());

		return book;
	}

	public int inputBookId() {
		System.out.println("아이디:");
		int id=sc.nextInt();
		return id;
	}

	public String inputBookTitle() {
		System.out.println("제목:");
		String title=sc.nextLine();
		return title;
	}

	public void displayBooks(List<Book> list) {
		System.out.println("아이디\t제목\t\t출판사\t저자 \t출판날짜\t\t가격");
		for(Book b:list){
			System.out.println(b.toString());
		}
	}

	public void displayBook(Book b) {
		System.out.println("아이디\t제목\t\t출판사\t저자 \t출판날짜\t\t가격");
		System.out.println(b.toString());

	}

	public void displaycheck(String message) {
		System.out.println(message);
	}
	
}
