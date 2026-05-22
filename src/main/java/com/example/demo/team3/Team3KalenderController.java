
package com.example.demo.team3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("day")
@Controller
public class Team3KalenderController {
	
	
	@GetMapping("/Team3kalender")
		public String index() {
			
			return "team3/Team3KalenderIn";
		}
	
	@PostMapping("/Team3kalender")
		public String send(@RequestParam("day") String day,Model model) {
		try {
			model.addAttribute("day",day);
		}catch(Exception e) {
			 e.printStackTrace();
			 return "team3/Error";
		}
		
		return "team3/Team3displayIn";
	}
		
	@PostMapping("/Team3cancel1")
	public String cancel1() {
		return "team3/Team3KalenderIn";
	}
	
}
