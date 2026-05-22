package com.example.demo.team3;

import java.util.List;

public class Team3Calculation {

	//計算メソッドを追加してください。
	 public int sumPrice(List<Team3House> list) {
	        int sum = 0;
	        for (Team3House item : list) {
	            sum += item.getPrice();
	        }
	        return sum;
	 }
}
