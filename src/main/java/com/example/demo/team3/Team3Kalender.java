
package com.example.demo.team3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("day")
@Controller
public class Team3Kalender {
	
	
	@GetMapping("/kalender")
		public String index() {
			
			return "Team3KalenderIn";
		}
	
	@PostMapping("/kalender")
		public String send(@RequestParam("day") String day,Model model) {
		model.addAttribute("day",day);
		return "Team3displayIn";
	}
		
	@PostMapping("/cancel1")
	public String cancel1() {
		return "/Team3KalenderIn";
	}
	
}
