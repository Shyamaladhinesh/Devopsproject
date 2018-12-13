package com.ecomm.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController
{
@Autowired
CartDAO cartDAO;
@Autowired
ProductDAO productDAO;

@RequestMapping(value="/cart")
public  String showCart(Model m,HttpSession session)
{
	String user=(String)session.getAttribute("user");
	
	 List<Cart> listCartItems=cartDAO.listCartItems(user);
	 
	 m.addAttribute("cartItems",listCartItems);
	 m.addAttribute("grandTotal",this.calcTotalPrice(listCartItems));
	 
	
	return "Cart";
	
}

@RequestMapping(value="/addToCart/{productId}")
public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
{
	Cart cart=new Cart();
	
	String user=(String)session.getAttribute("user");
	
	Product product=productDAO.getProduct(productId);
    cart.setProductId(productId);
    cart.setPrice(product.getPrice());
    cart.setProductname(product.getProductName());
    cart.setQuantity(quantity);
    cart.setUser("suthan");
    cart.setUser(user);
    cartDAO.addToCart(cart);
    
    List<Cart> listCartItems=cartDAO.listCartItems(user);
    
    m.addAttribute("cartItems",listCartItems);
    m.addAttribute("grandTotal",this.calcTotalPrice(listCartItems));
    
    return "Cart";
	
}

public int calcTotalPrice(List<Cart> listCartItems)
{

		int grandTotal=0;
		
		int count=0;
		
		while(count<listCartItems.size())
		{
			Cart cart=listCartItems.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		
		return grandTotal;
		
}	

@RequestMapping(value="/updateCartItem/{cartId}")
 public String updateCartItem(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m,HttpSession session)	
 {
	 
	 String user="suthan";
	 Cart cart=cartDAO.getCart(cartId);
	 cart.setQuantity(quantity);
	 cartDAO.updateCart(cart);
	 
	 List<Cart> listCartItems=cartDAO.listCartItems(user);
	 
	 m.addAttribute("cartItems",listCartItems);
	 m.addAttribute("grandTotal",this.calcTotalPrice(listCartItems));
	 
	 return "Cart";
	 
 }
	 
 
		
@RequestMapping(value="/deleteCartItem/{cartId}")	
public String deleteCartItem(@PathVariable("cartId")int cartId,Model m,HttpSession session)
{
	String user="suthan";
	Cart cart=cartDAO.getCart(cartId);
	cartDAO.deleteCart(cart);
	
    List<Cart> listCartItems=cartDAO.listCartItems(user);
	 
	 m.addAttribute("cartItems",listCartItems);
	 m.addAttribute("grandTotal",this.calcTotalPrice(listCartItems));
	 
	 return "Cart";
	 
}


		
}






 
