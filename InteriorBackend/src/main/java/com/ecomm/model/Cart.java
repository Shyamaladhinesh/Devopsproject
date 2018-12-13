package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart 
{
	@Id
	   @GeneratedValue
	   int cartId;
	   
	   int productId;
	   String user;
	   
	   String productname;
	   int quantity;
	   int stock;
	   
	   int price;

	public int getCartId()
	{
		return cartId;
	}

	public void setCartId(int cartId)
	{
		this.cartId = cartId;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId) 
	{
		this.productId = productId;
	}

	public String getUser() 
	{
		return user;
	}

	public void setUser(String user) 
	{
		this.user = user;
	}

	public String getProductname() 
	{
		return productname;
	}

	public void setProductname(String productname) 
	{
		this.productname = productname;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public int getStock() 
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	
}
