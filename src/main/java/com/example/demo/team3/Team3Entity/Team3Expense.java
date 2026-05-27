package com.example.demo.team3.Team3Entity;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "team3_syohin_tbl")
public class Team3Expense {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@PastOrPresent(message = "商品名は必須です")
	private LocalDate date;

	@NotBlank(message = "商品名は必須です")
	private String category;
	
	@Min(value=1,message = "価格を１以上の値で入力してください")
	@Max(value=9999999,message = "価格は100億円以下の値を入力してください")
	private int price;

	@Min(value=1,message="数量は１以上を入力してください")
	@Max(value=9999999,message = "価格は100億個以下の値を入力してください")
	private int amount;

	@Column(name="result",insertable = false,updatable=false)
	private int result;

	    // getter / setter
//	ここでデータをテーブルに入れているまたは出している（参照）
	public int getId() {
	    return id;
	}

	public LocalDate getDate() {
	    return date;
	}

	public void setDate(LocalDate date) {
	    this.date = date;
	}

	public String getCategory() {
	    return category;
	}

	public void setCategory(String category) {
	    this.category = category;
	}

	public int getPrice() {
	    return price;
	}

	public void setPrice(int price) {
	    this.price = price;
	}

	public int getAmount() {
	    return amount;
	}

	public void setAmount(int amount) {
	    this.amount = amount;
	}

	public int getResult() {
	    return result;
	}

	public void setResult(int result) {
	    this.result = result;
	}

//private Long id;
//private LocalDate date;
//private String category;
//private Integer amount;

	
}