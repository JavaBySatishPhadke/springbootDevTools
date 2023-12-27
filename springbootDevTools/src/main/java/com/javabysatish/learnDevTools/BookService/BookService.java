package com.javabysatish.learnDevTools.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.javabysatish.learnDevTools.entities.Book;

@Component
public class BookService {

	private static ArrayList<Book> list = new ArrayList<>();

	
	static {

		list.add(new Book(11, "C programing", "K & R author"));
		list.add(new Book(12, "AWS programing", "AWS atuhtor"));
		list.add(new Book(13, "Java programing", "Gosling"));
		list.add(new Book(14, "C++ programing", "strapstrup"));
	}
	 

	/*
	 * Return the all books from downStream
	 */
	public List<Book> getAllbook() {

		return list;

	}

	

	public Book getBookById(int id) {
		Book book;
		book = list.stream().filter(p  -> p.getId() == id).findFirst().get();
		return book;
	}



	public Book addBook(Book book) {
		list.add(book);
		return book;
		
	}



	public void updateBook(Book book, int id) {
		

		list.stream().map(b -> {
			
			if(b.getId() == id) {
				
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());
		
		
	}



	public void deleteBook(int id) {
		
		list.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
		
	}

}
