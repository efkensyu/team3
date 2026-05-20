package com.example.demo.team3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team3Login {
	//画面遷移でカレンダー画面にとぶ。
	
		@GetMapping("/team3")
		public String index() {
			return "Team3LoginIn";
		}
		
		@PostMapping("/team3")
		public String index2() {
			return "Team3KalenderIn";
		}
	//最終的にif文を使って、ユーザー名とログイン名を合致するためのメソッドを作成する。

}
