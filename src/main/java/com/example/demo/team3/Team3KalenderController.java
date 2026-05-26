
package com.example.demo.team3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team3.Team3Entity.Team3DayEntity;

@SessionAttributes("day")
@Controller
public class Team3KalenderController {
	
	
	@GetMapping("/Team3kalender")
		public String index(Model model) {
		
			if (!model.containsAttribute("team3DayEntity")) {
	            model.addAttribute("team3DayEntity", new Team3DayEntity());
	        }
			
			return "team3/Team3KalenderIn";
		}
	
	@PostMapping("/Team3kalender")
		public String send(@ModelAttribute("team3DayEntity") 
		@Validated Team3DayEntity form,
	            BindingResult result,
	            Model model) {
		
        if (result.hasErrors()) {
            return "team3/Team3KalenderIn";
        }

        model.addAttribute("day", form.getDay());
        return "team3/Team3displayIn";
    }
		
	@PostMapping("/Team3cancel1")
	public String cancel1() {
		return "team3/Team3KalenderIn";
	}
	
}
