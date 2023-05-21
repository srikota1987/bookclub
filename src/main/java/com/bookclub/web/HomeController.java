package com.bookclub.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHome(Model model) {
		RestBookDao bookDao = new RestBookDao();
		
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int calMonth = cal.get(Calendar.MONTH) +1;
		

		List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));
		
		StringBuilder isbnBuilder = new StringBuilder();
		isbnBuilder.append("ISBN:");
		
		for(BookOfTheMonth monthlyBook : monthlyBooks) {
			isbnBuilder.append(monthlyBook.getIsbn()).append(",");
		}
		
		String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() -1);
		
		List<Book> books = bookDao.list(isbnString);
		for(Book book: books) {
			System.out.println(book.toString());
		}
		model.addAttribute("books", books);
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/about")
	public String showAboutUs(Model model) {
		return "about";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/contact")
	public String showContactUs(Model model) {
		return "contact";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String getMonthlyBook(@PathVariable String id, Model model) {
		
		String isbn = id;
		System.out.println(isbn);
		
		RestBookDao bookDao = new RestBookDao();
		Book book = bookDao.find(isbn);
		
		System.out.println(book.toString());
		
		model.addAttribute("book", book);
		
		return "monthly-books/view";
		
	}
	
	@Autowired
	private void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
		this.bookOfTheMonthDao = bookOfTheMonthDao;
			
	}

}
