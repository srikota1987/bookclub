package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {
	
	private List<Book> books;

	public MemBookDao() {
		books = new ArrayList<Book>();
		books.add(new Book("643-7642-8376", "Alice's Adventures in Wonderland", "Alice's Adventures in Wonderland by Lewis Carroll", 200, Arrays.asList("Lewis Carroll")));
		books.add(new Book("567465-56473-74", "Gulliver's Travels", "Gulliver's Travels by Jonathan Swift", 392, Arrays.asList("Jonathan Swift")));
		books.add(new Book("97587-7587-347", "The Hobbit, or, There and Back Again", "The Hobbit, or, There and Back Again by J.R.R. Tolkien", 208, Arrays.asList("J.R.R. Tolkien")));
		books.add(new Book("6543-89769-7893", "The Secret Garden", "The Secret Garden by Frances Hodgson Burnett", 189, Arrays.asList("Frances Hodgson Burnett")));
		books.add(new Book("324-4778-99443", "Harry Potter and the Sorcerer's Stone", "Harry Potter and the Sorcerer's Stone by J.K. Rowling", 364, Arrays.asList("J.K. Rowling")));
		
	}

	@Override
	public List<Book> list() {
		return this.books;
	}

	@Override
	public Book find(String key) {
		for(Book book : books) {
			if(book.getIsbn().equals(key)) {
				return book;
			}
		}
		return new Book();
	}
	
	

}
