package com.ecomm.test;


import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTestCase {

	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	@Ignore
	@Test
	public void registerUserTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setUsername("chithra");
		userDetail.setPassword("shyam");
		userDetail.setCustomerName("dhinesh");
		userDetail.setEnabled(true);
		userDetail.setAddress("chennai");
		userDetail.setMobileno("9940414133");
		userDetail.setEmailid("shyamala@gmail.com");
		userDetail.setRole("USER_ROLE");
		
		
		assertTrue("problem in registering  the user",userDAO.registerUser(userDetail));
		
	}
	
	@Test
	public void updateUserTestCase() 
	{
		UserDetail userDetail=userDAO.getUser("chithra");
		userDetail.setAddress("cgf");
		userDetail.setMobileno("9940413760");
		
		assertTrue("problem in updating the user",userDAO.updateUser(userDetail));
	}
	
}
