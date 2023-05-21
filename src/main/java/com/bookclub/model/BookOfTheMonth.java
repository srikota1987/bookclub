package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class BookOfTheMonth {
	
	@Id
	private String id;
	private Integer month;
	@NotNull
	@NotEmpty(message = "ISBN is a required field")
	private String isbn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		
		return "BookOfTheMonth{isbn=" + this.isbn +  ",month=" + this.month + ",id=" + this.id +"}";
		
	}

}
