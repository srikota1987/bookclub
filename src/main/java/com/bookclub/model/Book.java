package com.bookclub.model;

import java.util.List;

public class Book {
	
	
	private String isbn;
	private String title;
	private String description;
	private String infoUrl;
	private String id;
	public String getInfoUrl() {
		return infoUrl;
	}


	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}


	private int numOfPages; 

	
	
	public Book() {
	
	}


	public Book(String isbn, String title, String description, int numOfPages) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.numOfPages = numOfPages;

	}
	
	public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.infoUrl = infoUrl;
		this.numOfPages = numOfPages;

	}
	
	public Book(String isbn, String title, String description) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;

	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getNumOfPages() {
		return numOfPages;
	}


	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	
	@Override
	public String toString() {
		
		return "Book{isbn=" + this.isbn +  ",title=" + this.title + ",description=" + this.description +",numOfPages=" + this.numOfPages + "}";
		
	}
	
	
	
	

}
