package com.project.cart_api.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.cart_api.dao.CartApiRepository;
import com.project.cart_api.entities.CartApi;
import org.springframework.stereotype.Service;



@Service
public class CartApiService {

	@Autowired
	private CartApiRepository cartApiRepository;
	

//	to get all cart
	public List<CartApi> getAllCarts(){
		List<CartApi> list=(List<CartApi>)this.cartApiRepository.findAll();
//		System.out.println("list"+list);
		return list;
	}
	

//	get single cart by id
	public CartApi getCartById(int id) {
		
		CartApi cart=null;
		try {
			cart=this.cartApiRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	

//	get single cart by id
//	public CartApi getCartById(int id) {
//		
//		
//		  CartApi cartOfId = cartApiRepository.findById(id);  
//		  cartOfId.getClass();
//		
//		return cart;
//	}
	
	
	

//	adding the Cart
	public CartApi addCart( CartApi c) {
		CartApi result=cartApiRepository.save(c);
//		System.out.println("result"+result);
		return result;
		
	}
	
//	delete the Cart
	public void deleteCart(int cid) {
		cartApiRepository.deleteById(cid);
	}
	
//	update the Cart
	public void updateCart(CartApi cart , int cartId) {
		cart.setId(cartId);
		cartApiRepository.save(cart);
	}
	
	
	
	
	
}
