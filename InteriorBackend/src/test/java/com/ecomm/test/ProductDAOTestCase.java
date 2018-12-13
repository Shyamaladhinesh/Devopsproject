package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOTestCase 
{

	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		
	}
	
	@Test
	public void addProductTestCase()
		{
			Product product=new Product();
			product.setProductName(" window mirror  gate");
			product.setProductDesc("exact fitting size");
			product.setPrice(1000);
			product.setStock(16);
			product.setSupplierId(101);
			product.setCategoryId(1);
		    assertTrue("problem in adding the product",productDAO.addProduct(product));
		
		}
	@Ignore
	@Test
	public void  listCategoriesTestCase() 
	{
				
		List<Product> listProduct=productDAO.listProducts();
		assertTrue("problem in listing categories",listProduct.size()>0);
		for(Product product:listProduct)
		{
			System.out.println(product.getProductId()+"::");
			System.out.println(product.getProductName()+"::");
			System.out.println(product.getProductDesc()+"::");
			System.out.println(product.getStock()+"::");
			System.out.println(product.getPrice()+"::");
			
			
			
			
		}
	}



	
	}

