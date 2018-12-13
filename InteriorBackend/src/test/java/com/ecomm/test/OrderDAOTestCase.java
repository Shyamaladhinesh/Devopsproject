package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;


public class OrderDAOTestCase
{

	static OrderDAO orderDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				
	    context.scan("com.ecomm");
		context.refresh();
		
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}

	@Test
	public void paymentProcessTest() 
	{
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername("shyam");
		orderDetail.setOrderDate(new Date());
		orderDetail.setPmode("cc");
		orderDetail.setTotalShoppingAmount(10000);
		
		assertTrue("problem in entering payment:",orderDAO.paymentProcess(orderDetail));
		
	}
	
	@Ignore
	@Test
	public void updateCartTest()
	{
		assertTrue("problem in updating status",orderDAO.updateCartItemStatus("shyam"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
