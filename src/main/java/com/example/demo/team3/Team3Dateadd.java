package com.example.demo.team3;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team3.Team3Entity.Team3Expense;
import com.example.demo.team3.Team3Repository.Team3DateaddRepository;

@Controller
public class Team3Dateadd {

    @Autowired
    private Team3DateaddRepository repository;

    // 入力画面
    @GetMapping("/input")
    public String input(@RequestParam(required = false) String date, Model model) {
    		
    	
//    		model.addAttribute("date",date);
    	   Team3Expense e = new Team3Expense();

    	    if (date != null && !date.isEmpty()) {
//    	    	 	model.addAttribute("team3Expense", e); 
//    	    	 	model.addAttribute("date", 
//    	    	 		e.getDate() != null ? e.getDate().toString() : "");
    	        e.setDate(LocalDate.parse(date));
    	    }

    	    model.addAttribute("team3Expense", e);
    	    model.addAttribute("date", date);
        return "team3/Team3DateaddIn";
        
    }

    // 登録処理
    @PostMapping("/add2")
//    public String add2() {
//    		System.out.println("b");
//    		return "Team3DateaddOut";
//    }
    public String add(@Valid Team3Expense e,
            BindingResult result,
            Model model) {
////    	データの登録
//        Team3Expense e = new Team3Expense();
//
//        e.setDate(LocalDate.parse(date));
//        e.setCategory(category);
//        e.setPrice(price);
//        e.setAmount(amount);
        //e.setResult(price * amount);
    	// エラーがある場合
        if (result.hasErrors()) {
            
        		model.addAttribute("team3Expense", e);
        		model.addAttribute("date", e.getDate() != null ? e.getDate().toString() : "");
            return "team3/Team3DateaddIn";
        }

        
//        データの保存
        repository.save(e);
//        return "Team3DateaddOut";
        return "redirect:/list?date=" + e.getDate();
    }
    

    // 一覧画面
    @GetMapping("/list")
    public String list(@RequestParam(required = false) String date, Model model) {

        if (date == null || date.isEmpty()) {
            return "team3/Team3Dateselect";
        }

        LocalDate localDate = LocalDate.parse(date);

        List<Team3Expense> list = repository.findByDate(localDate);

        Integer total = repository.sumTotalByDate(localDate);

        model.addAttribute("expenses", list);
        model.addAttribute("date", localDate);
        model.addAttribute("total", total);

        return "team3/Team3DateaddOut";
    }
    
//    削除画面
    @PostMapping("/delete2")
    public String delete(@RequestParam int id,@RequestParam String date) {
    	repository.deleteById(id);
        return "redirect:/list?date=" + date;
    }
    
//    編集画面
    @GetMapping("/edit2")
    public String edit(@RequestParam int id, Model model) {

        Team3Expense e = repository.findById(id).orElse(null);

        model.addAttribute("expense", e);

        return "team3/Team3Edit";
    }
    
//    更新画面
    @PostMapping("/update2")
    public String update(@RequestParam int id,
                         @RequestParam String date,
                         @RequestParam String category,
                         @RequestParam int price,
                         @RequestParam int amount) {

        Team3Expense e = repository.findById(id).orElse(null);

        e.setDate(LocalDate.parse(date));
        e.setCategory(category);
        e.setPrice(price);
        e.setAmount(amount);

        repository.save(e);

        return "redirect:/list?date=" + date;
    }
    
//    保存ボタンの追加
    @PostMapping("/saveAndBack")
    public String saveAndBack(@RequestParam int id,
                              @RequestParam String date,
                              @RequestParam String category,
                              @RequestParam int price,
                              @RequestParam int amount) {

        Team3Expense e = repository.findById(id).orElse(null);
//        値を保持するためそれぞれ代入
        if (e != null) {
            e.setDate(LocalDate.parse(date));
            e.setCategory(category);
            e.setPrice(price);
            e.setAmount(amount);

            repository.save(e);
        }

        return "redirect:/list?date=" + date;
    }
    
//    グラフの表示
    @GetMapping("/chart")
    public String chart(@RequestParam String date, Model model) {

        LocalDate localDate = LocalDate.parse(date);

        List<Team3Expense> list = repository.findByDate(localDate);

        // カテゴリ別集計
        Map<String, Integer> map = new HashMap<>();

        for (Team3Expense e : list) {
            int value = e.getPrice() * e.getAmount();
            map.put(e.getCategory(),
                    map.getOrDefault(e.getCategory(), 0) + value);
        }

        model.addAttribute("map", map);
        model.addAttribute("date", date);

        return "team3/Team3Chart";
    }
}