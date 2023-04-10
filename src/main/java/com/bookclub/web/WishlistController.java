package com.bookclub.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemBookDao;
import com.bookclub.service.impl.MemWishlistDao;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	
	MemWishlistDao memWishlistDao = new MemWishlistDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showWishlist(Model model) {
		
		List<WishlistItem> wishlist = memWishlistDao.list();
		
		for(WishlistItem wishListItem: wishlist) {
			System.out.print(wishListItem.toString());
		}
		
		model.addAttribute("wishlist", wishlist);
		return "wishlist/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String wishlistForm(Model model) {
		
		
		model.addAttribute("wishlistItem", new WishlistItem());
		
		return "wishlist/new";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
		
		System.out.println(wishlistItem.toString());
		
		System.out.println(bindingResult.getAllErrors());
		
		if(bindingResult.hasErrors()) {
			return "wishlist/new";
		}
		
		memWishlistDao.list().add(wishlistItem);
		
		return "redirect:/wishlist";
	}

}
