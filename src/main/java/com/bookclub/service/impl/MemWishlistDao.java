package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {
	
	private List<WishlistItem> wishlist;

	public MemWishlistDao() {
		wishlist = new ArrayList<WishlistItem>();
		wishlist.add(new WishlistItem("643-7642-8376", "Alice's Adventures in Wonderland"));
		wishlist.add(new WishlistItem("567465-56473-74", "Gulliver's Travels"));
		wishlist.add(new WishlistItem("597587-7587-347", "The Hobbit, or, There and Back Again"));
	}

	
	@Override
	public List<WishlistItem> list() {
		
		return wishlist;
	}

	@Override
	public WishlistItem find(String key) {
		for(WishlistItem wishlistItem : wishlist) {
			if(wishlistItem.getIsbn().equals(key)) {
				return wishlistItem;
			}
		}
		return new WishlistItem();
	}

}
