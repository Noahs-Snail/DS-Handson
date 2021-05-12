package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;



@Service
public class CartService {
	
	@Autowired
	private CartDao dao;

	public void addCartItem(String userId, long menuItemId) {
		// TODO Auto-generated method stub
		dao.addCartItem(userId, menuItemId);
		
	}

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		return dao.getAllCartItems(userId);
	}

	public void removeCartItem(String userId, int menuItemId) {
		// TODO Auto-generated method stub
		dao.removeCartItem(userId, menuItemId);
		
	}

}
