package com.example.demo.team3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team3.Team3Entity.Team3Expense;
import com.example.demo.team3.Team3Repository.Team3DateaddRepository;

@Controller
public class Team3Expence {
	@Autowired
	private Team3DateaddRepository repository;

 @GetMapping("/view")
	public String list(Model model) {

	  List<Team3Expense> list = repository.findAll(); // ← SELECT * FROM

	    model.addAttribute("list", list);

	  return "View";
	    
	}
}
