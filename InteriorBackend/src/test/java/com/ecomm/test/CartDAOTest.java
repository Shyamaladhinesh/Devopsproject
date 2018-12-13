package com.ecomm.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;

public class CartDAOTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void execute()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
		
	}
	@Test
	public void addcartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(5);
		cart.setProductname("cutain");
		cart.setQuantity(4);
		cart.setUser("dhinesh");
		cart.setPrice(200);
		cart.setStock(34);
		
		assertTrue("problem in adding item to cart",cartDAO.addToCart(cart));
	}
	
}
