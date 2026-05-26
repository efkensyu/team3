package com.example.demo.team3.trash;

import java.util.List;

public class Team3Calculation {

	//計算メソッドを追加してください。
	 public int sumPrice(List<Team3Entity> list) {
	        int sum = 0;
	        for (Team3Entity item : list) {
	            sum += item.getPrice() * item.getQuantity();
	        }
	        return sum;
	 }
}
