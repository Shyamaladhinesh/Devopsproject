package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;
import com.ecomm.model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
         
	     @Autowired
		 SessionFactory sessionFactory;
		 	
	public boolean addProduct(Product product) 
		 	{
		 			try
		 		{
 		sessionFactory.getCurrentSession().saveOrUpdate(product);
		 		return true;
		 		}
		 		catch(Exception e)
		 		{
		 			return false;
		 		}
		 	}
		
	

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try
 		{
 		sessionFactory.getCurrentSession().delete(product);
 		return true;
 		}
 		catch(Exception e)
 		{
 			return false;
 		}

		
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try
 		{
 		sessionFactory.getCurrentSession().update(product);
 		return true;
 		}
 		catch(Exception e)
 		{
 			return false;
 		}

	}

	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		return listProducts;
	
		
	}

	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
			return product;
	}



	

	
}
