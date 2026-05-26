package com.example.demo.team3.Team3Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Team3Entity {
	@NotBlank(message="商品名を入力してください")
	private String name;
	
	@NotNull(message="値段を入力してください")
	@Min(1)
	private int price;
	
	@NotNull(message="個数を入力してください")
	@Min(1)
	private int quantity;

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setName(String name) { 
		this.name = name;
	}
	
    public void setPrice(int price) { 
    		this.price = price; 
    	}
    
    public void setQuantity(int quantity) { 
		this.quantity = quantity; 
	}
}
