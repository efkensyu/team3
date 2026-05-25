package com.example.demo.team3;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team3.Team3Entity.LoginEntity;
import com.example.demo.team3.Team3Repository.Team3LoginRepository;


@Controller
@SessionAttributes("loginEntity")
public class Team3LoginController {
	//画面遷移でカレンダー画面にとぶ。
	
		@Autowired
	    Team3LoginRepository repository;

	
		@GetMapping("/Team3Login")
		public String index(Model model) {
			model.addAttribute("loginEntity",new LoginEntity());
			return "team3/Team3LoginIn";
		}
		
		
		// =========================
	    // ログイン処理
	    // =========================
		@PostMapping("/Team3Login")
		public String index2( 
				@Valid LoginEntity loginEntity,BindingResult result,
			@RequestParam("username") String name){
//			@RequestParam("password") String pass
			
			LoginEntity login = repository.findByUsername(name);
			
			  // Validationエラー
	        if (result.hasErrors()) {
	            return "team3/Team3LoginIn";
	        }
				
			//ユーザー存在チェック
			 if (login != null) {
					 return "team3/Team3KalenderIn";
			 }else {
				 return "team3/Team3LoginIn";
			 }
	}
		
		
		// 新規登録画面表示
		@GetMapping("/Team3UserAdd")
		public String userAdd(Model model) {

		    model.addAttribute("loginEntity",new LoginEntity());
		    return "team3/Team3UserAddIn";
		}
		
		// =========================
	    // 新規登録処理
	    // =========================
	    @PostMapping("/Team3UserAdd")
	    public String userAdd2(@Valid LoginEntity loginEntity,BindingResult result,
	            Model model){
	    	
	    	
	    	// Validationエラー
	        if (result.hasErrors()) {
	            return "team3/Team3UserAddIn";
	        }
	        // 同じユーザー名チェック
	        LoginEntity check =
	                repository.findByUsername(loginEntity.getUsername());
	        
	     

	        // 既に存在する場合
	        if (check != null) {
	            return "team3/Team3UserAddIn";
	        }

	        // DB保存
	        repository.save(loginEntity);

	        // ログイン画面へ
	        return "team3/Team3LoginIn";
	    }
}
