package com.example.demo.team3;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Team3House {
	
	@NotBlank(message="商品名を入力してください。")
	private String name;
	@NotNull(message="値段を入力してください。")
	@Min(0)
	private int price;

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void setName(String name) { 
		this.name = name;
	}
	
    public void setPrice(int price) { 
    		this.price = price; 
    	}
}
