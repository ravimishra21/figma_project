
package com.project.cart_api.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cart_api.entities.CartApi;
import org.springframework.stereotype.Repository;

@Repository
public interface CartApiRepository extends JpaRepository<CartApi ,Integer> {

	public CartApi findById(int id);
	
}

