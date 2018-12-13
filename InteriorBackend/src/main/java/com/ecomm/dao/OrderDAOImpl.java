package com.ecomm.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ecomm.model.OrderDetail;
@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean paymentProcess(OrderDetail orderDetail)
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured in adding"+e);
			return false;
			
		}
				
		
	}

	@Override
	public boolean updateCartItemStatus(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("update cart set status='p' where username=:uname");
			query.setParameter("uname",username);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
                 return true;
			else
				return false;
				
		}
		catch(Exception e)
		{
			System.out.println("exception occur:"+e);
			return false;
			
		}
	
	}

	
	
}
