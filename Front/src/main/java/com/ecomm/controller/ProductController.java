package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class ProductController
{
	
@Autowired
ProductDAO productDAO;
@Autowired
CategoryDAO categoryDAO;
private String prodImage;

@RequestMapping(value="/prod")
public String showProduct(Model m)
{
	 List<Product> listProducts=productDAO.listProducts();
	 m.addAttribute("listproduct",listProducts);
	 
	 Product product=new Product();
	 m.addAttribute("prod",product);
	 
	 m.addAttribute("categorylist",this.getcatList(categoryDAO.listCategories()));
	 return "Product";
}


@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
public String insertProduct(@ModelAttribute("prod")Product product,@RequestParam("pimage")MultipartFile prodImage,Model m)
{
	 System.out.println("Product Name:"+product.getProductName());
	 System.out.println("Product Desc:"+product.getProductDesc());
	 System.out.println("CategoryID:"+product.getCategoryId());
	 
	 
	 productDAO.addProduct(product);
	 

		
		
			String path="D:\\new proj\\Front\\src\\main\\webapp\\resources\\images\\";
			
			path=path+String.valueOf(product.getProductId())+".jpg";
			
			File imageFile=new File(path);
			
			if(!prodImage.isEmpty())
			{
				try
				{
					byte[] buffer=prodImage.getBytes();
					FileOutputStream fos=new FileOutputStream(imageFile);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(buffer);
					bs.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
					m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
				}
			}
			else
			{
				System.out.println("error occured");
				m.addAttribute("Error","Error Occured during the Image Uploading");
			}
	 
	 Product product1=new Product();
	 m.addAttribute("prod",product1);
	 
	 List<Product> listProducts=productDAO.listProducts();
	 m.addAttribute("listproduct",listProducts);
	 
	 m.addAttribute("categorylist",this.getcatList(categoryDAO.listCategories()));
	 
	 System.out.println("inserted");
	 return "Product";
	 
}

@RequestMapping(value="/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId")int productId,Model m)
{
	 
	
	 
	 Product product=productDAO.getProduct(productId);
	 productDAO.deleteProduct(product);
	 
	 Product product2=new Product();
	 m.addAttribute("prod",product2);
	 
	 List<Product> listProducts=productDAO.listProducts();
	 m.addAttribute("listproduct",listProducts);
	 
	 m.addAttribute("categorylist",this.getcatList(categoryDAO.listCategories()));
	 return "Product";
	 
}

@RequestMapping(value="/editProduct/{productId}")
public String editProduct(@RequestParam("productId")int productId,Model m)
{
	 
	
	 
	 Product product=productDAO.getProduct(productId);
	 m.addAttribute("prod",product);
	  
	 List<Product> listProducts=productDAO.listProducts();
	 m.addAttribute("listproduct",listProducts);
	 
	 m.addAttribute("categorylist",this.getcatList(categoryDAO.listCategories()));
	 
	 System.out.println("edited sucessfully!");
	 return "EditProduct";
	 
}

public LinkedHashMap<Integer,String> getcatList(List<Category> listCategory)
{
	LinkedHashMap<Integer,String> listCategories=new LinkedHashMap<Integer,String>();
	for(Category category:listCategory)
	{
		listCategories.put(category.getCategoryId(), category.getCategoryName());
	}
	return listCategories;
}

@RequestMapping(value="/productdisplay")
public String productDisplay(Model m)
{
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("listproduct",listProducts);
	  
	return "ProductDisplay";
	  
}
/*@RequestMapping(value="/totalproductdisplay")
public String totalproductDisplay(@RequestParam("productId")int productId,Model m)
{
	
	System.out.println(productId);
	
	Product pro=productDAO.getProduct(productId);
	m.addAttribute("listproduct",pro);
	  
	  
	  
	return "TotalProductDisplay";
	  
}*/

}



