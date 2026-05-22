package com.example.demo.team3;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String input() {
//    		System.out.println("a");
        return "Team3DateaddIn";
        
    }

    // 登録処理
    @PostMapping("/add2")
//    public String add2() {
//    		System.out.println("b");
//    		return "Team3DateaddOut";
//    }
    public String add(String date,
                      String category,
                      int price,
                      int amount) {
//    	データの登録
        Team3Expense e = new Team3Expense();

        e.setDate(LocalDate.parse(date));
        e.setCategory(category);
        e.setPrice(price);
        e.setAmount(amount);
        //e.setResult(price * amount);
        
//        データの保存
        repository.save(e);
//        return "Team3DateaddOut";
      return "redirect:/list";  // ← ここ重要
    }
    

    // 一覧画面
    @GetMapping("/list")
    public String list(Model model) {

        List<Team3Expense> list = repository.findAll();

        model.addAttribute("expenses", list);

        return "Team3DateaddOut";
    }
    
//    削除画面
    @PostMapping("/delete2")
    public String delete(@RequestParam int id) {
    	repository.deleteById(id);
        return "redirect:/list";
    }
    
//    編集画面
    @GetMapping("/edit2")
    public String edit(@RequestParam int id, Model model) {

        Team3Expense e = repository.findById(id).orElse(null);

        model.addAttribute("expense", e);

        return "Team3Edit";
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

        return "redirect:/list";
    }
}