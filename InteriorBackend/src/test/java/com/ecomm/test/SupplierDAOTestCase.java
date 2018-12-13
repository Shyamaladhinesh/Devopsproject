package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;

public class SupplierDAOTestCase {

	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
	}
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("dhinu");
		supplier.setSupplierAddr("delhi");
	    assertTrue("problem in adding the supplier",supplierDAO.add(supplier));
	
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
    Supplier supplier=supplierDAO.getSupplier(38);
	supplier.setSupplierName("dhinukumar");
	supplier.setSupplierAddr("hyderabad");
	assertTrue("problem in updating the supplier",supplierDAO.update(supplier));
	
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
	Supplier supplier=supplierDAO.getSupplier(39);
	assertTrue("problem in deleting the supplier",supplierDAO.delete(supplier));
	
	}
	
	@Test
	public void  listSuppliersTest() 
	{
				
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertTrue("problem in listing suppliers",listSuppliers.size()>0);
		for(Supplier supplier:listSuppliers)
		{
			System.out.println("supplier id:"+supplier.getSupplierId());
			System.out.println("supplier name:"+supplier.getSupplierName());
			System.out.println("supplier Addr:"+supplier.getSupplierAddr());
			
			
			
		}
	}

	
	
	}


