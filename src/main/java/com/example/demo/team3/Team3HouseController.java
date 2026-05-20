package com.example.demo.team3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team3HouseController {
	
	//private final Team3Repository repository;
ArrayList<Team3House> ary = new ArrayList<>();
	
//	//Todo2というHTMLファイルを探す
//	@GetMapping("/team3_controll")
//	public String start(Model model) {
//		model.addAttribute("ary", ary);
//		return "/Todo2";
//	}
	
	//追加ボタンを押したら記入内容が同ファイルにとぶ
	@PostMapping("/controller")
	public String add(@ModelAttribute() Team3House team3House) {
		ary.add(team3House);
		return "redirect:/displayOut";
	}
	
//	@PostMapping("/delete")
//	public String delete(@RequestParam() int price) {
//		ary.remove(price);
//		return "redirect:/displayOut";
//	}
//	
//	@PostMapping("/update")
//	public String update(
//					@ModelAttribute("team3House") Team3House team3House ,
//					@RequestParam("price") int price) {
//		ary.set(price, team3House);
//		return "redirect:/displayOut";
//	}
//	

}
