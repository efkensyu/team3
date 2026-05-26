package com.example.demo.team3.Team3Entity;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team3DayEntity {
	
    @NotBlank(message = "日付を選択してください")
    private String day;
    
    public String getDay() {
		return day;
	}
    
    public void setDay(String day) { 
		this.day = day; 
	}

}
