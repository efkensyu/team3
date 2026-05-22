package com.example.demo.team3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team3LoginController {
	//画面遷移でカレンダー画面にとぶ。
	
		@GetMapping("/Team3Login")
		public String index() {
			return "team3/Team3LoginIn";
		}
		
		@PostMapping("/Team3Login")
		public String index2() {
			return "team3/Team3KalenderIn";
		}
	//最終的にif文を使って、ユーザー名とログイン名を合致するためのメソッドを作成する。

}
