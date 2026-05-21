package com.example.demo.team3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;
@SessionAttributes({"team3House","ary"})
@RequiredArgsConstructor
@Controller	
public class Team3HouseController {
	
	//private final Team3Repository repository;
ArrayList<Team3House> ary = new ArrayList<>();
	

	@GetMapping("/Team3displayOut")
	public String get(Model model) {
		model.addAttribute("team3House", new Team3House());
		model.addAttribute("ary", ary);
		return "/Team3displayOut";
	}
	
	//追加
	@PostMapping("/add")
	public String add(
			@ModelAttribute Team3House team3House ,
			@ModelAttribute("ary") ArrayList<Team3House> ary) {
		ary.add(team3House);
		return "redirect:/Team3displayOut";
	}
	
	//削除
//	@PostMapping("/delete")
//	public String delete(@RequestParam("index")int index) {
//		ary.remove(index);
//		return "redirect:/Team3displayOut";
//	}
//	
//	//更新
//	@PostMapping("/update")
//	public String update(
//					@ModelAttribute("team3House") Team3House team3House ,
//					@RequestParam("index") int index) {
//		ary.set(index, team3House);
//		return "redirect:/Team3displayOut";
//	}
	
	//カレンダーに戻る
	@PostMapping("/cancel")
	public String cancel() {
		return "/Team3KalenderIn";
	}
	
	//displayin
	@PostMapping("/save")
	public String save(@ModelAttribute Team3House team3House, Model model) {
		model.addAttribute("ary",ary);
		model.addAttribute("team3House", team3House);
		return "/Team3displayIn";
	}
	

}
