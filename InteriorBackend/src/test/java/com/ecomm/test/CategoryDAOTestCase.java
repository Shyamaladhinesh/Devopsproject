package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTestCase
{
static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}

	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName(" oppo");
		category.setCategoryDesc("good performance");
	    assertTrue("problem in adding the category",categoryDAO.add(category));
	
	}
@Ignore
	@Test
	public void updateCategoryTest()
	{
    Category category=categoryDAO.getCategory(2);
	category.setCategoryName("no");
	category.setCategoryDesc("yes");
	assertTrue("problem in updating the category",categoryDAO.update(category));
	
	}
@Ignore
	@Test
	public void deleteCategoryTest()
	{
	Category category=categoryDAO.getCategory(2);
	assertTrue("problem in deleting the category",categoryDAO.delete(category));
	
	}
@Ignore
	@Test
	public void  listCategoriesTest() 
	{
				
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("problem in listing categories",listCategories.size()>0);
		for(Category category:listCategories)
		{
			System.out.println("category id:"+category.getCategoryId());
			System.out.println("category name:"+category.getCategoryName());
			System.out.println("category Desc:"+category.getCategoryDesc());
			
			
			
		}
	}

}
