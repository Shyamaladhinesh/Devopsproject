package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController
{
	     @Autowired
		CategoryDAO categoryDAO;
	     
	     @RequestMapping(value="/category")
	     public String showCategory(Model m)
	     {
	    	 List<Category> listcategories=categoryDAO.listCategories();
	    	 m.addAttribute("listcat",listcategories);
	    	 
	    	 return "Category";
	     }
	     @RequestMapping(value="/addCategory",method=RequestMethod.POST)
	     public String addCategoryDetail(@RequestParam("CategoryName")String CategoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	     {
	    	 Category category=new Category();
	    	 category.setCategoryName(CategoryName);
	    	 category.setCategoryDesc(categoryDesc);
	    	 categoryDAO.add(category);
	    	 
	    	 List<Category> listcategories=categoryDAO.listCategories();
	    	 m.addAttribute("listcat",listcategories);
	    	 
	
	    	 return "Category";
	    	 
	     }
		
	    @RequestMapping(value="/deleteCategory/{CategoryId}")
	     public String deleteCategory(@PathVariable("CategoryId")int CategoryId,Model m)
	     {
	    	 Category category=categoryDAO.getCategory(CategoryId);
	         categoryDAO.delete(category);
	         
	    	 
	    	 List<Category> listcategories=categoryDAO.listCategories();
	    	 m.addAttribute("listcat",listcategories);  
	    	 
	    	 return "Category";	    	 
	     }
	    
	    @RequestMapping(value="/editCategory/{CategoryId}")
	     public String editCategory(@PathVariable("CategoryId")int CategoryId,Model m)
	     {
	    	 Category category=categoryDAO.getCategory(CategoryId);
	         m.addAttribute("CategoryId");  
	    	 
	    	 return "UpdateCategory";	    	 
	     }
	    
	    
	    
	     @RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	     public String updateCategory(@RequestParam("CategoryId")int CategoryId,@RequestParam("CategoryName")String CategoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	     
	     {
	    	 Category category=categoryDAO.getCategory(CategoryId);
	    	 category.setCategoryName(CategoryName);
	    	 category.setCategoryDesc(categoryDesc);
	    	 
	         categoryDAO.update(category);
	         
	    	 List<Category> listcategories=categoryDAO.listCategories();
	    	 m.addAttribute("listcat",listcategories);
	    	 	 
	    	 return "Category";
	    	 
	     }
	     
	     
}
