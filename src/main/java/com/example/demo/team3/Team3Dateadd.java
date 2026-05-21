package com.example.demo.team3;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team3.Team3Entity.Team3Expense;
import com.example.demo.team3.Team3Repository.Team3DateaddRepository;

@Controller
public class Team3Dateadd {

    @Autowired
    private Team3DateaddRepository repository;

    // 入力画面
    @GetMapping("/input")
    public String input() {
        return "Team3DateaddIn";
    }

    // 登録処理
    @PostMapping("/add")
    public String add(String date,
                      String category,
                      int price,
                      int amount) {

        Team3Expense e = new Team3Expense();

        e.setDate(LocalDate.parse(date));
        e.setCategory(category);
        e.setPrice(price);
        e.setAmount(amount);
        e.setResult(price * amount);

        repository.save(e);

        return "redirect:/list";  // ← ここ重要
    }

    // 一覧画面
    @GetMapping("/list")
    public String list(Model model) {

        List<Team3Expense> list = repository.findAll();

        model.addAttribute("expenses", list);

        return "Team3DateaddOut";
    }
}