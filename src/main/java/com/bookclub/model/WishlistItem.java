package com.bookclub.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class WishlistItem {
	
	@NotNull
	@NotEmpty(message = "ISBN is a required field")
	private String isbn;
	@NotNull
	@NotEmpty(message = "Title is a required field")
	private String title;
	
	private String username;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Id
	private String id;
	
	public WishlistItem() {
		
	}


	public WishlistItem(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
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
	
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		
		return "WishlistItem{isbn=" + this.isbn +  ",title=" + this.title + ",id=" + this.id +"}";
		
	}

}
