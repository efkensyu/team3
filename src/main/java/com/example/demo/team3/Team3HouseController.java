package com.example.demo.team3;




import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team3HouseController {
	
	//private final Team3Repository repository;
ArrayList<Team3House> ary = new ArrayList<>();
	
//	//Todo2というHTMLファイルを探す
//	@GetMapping("/controller")
//	public String start(Model model) {
//		model.addAttribute("ary", ary);
//		return "/Team3displayOut";
//	}
	
	//追加ボタンを押したら記入内容が同ファイルにとぶ
	@GetMapping("/Team3displayOut")
	public String get(Model model) {
		model.addAttribute("ary", ary);
		return "/Team3displayOut";
	}
	
	@PostMapping("/recontroller")
	public String add(@ModelAttribute Team3House team3House) {
		ary.add(team3House);
		return "redirect:/Team3displayOut";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("index")int index) {
		ary.remove(index);
		return "redirect:/Team3displayOut";
	}
	
	@PostMapping("/update")
	public String update(
					@ModelAttribute("team3House") Team3House team3House ,
					@RequestParam("index") int index) {
		ary.set(index, team3House);
		return "redirect:/Team3displayOut";
	}
	

}
