package com.example.demo.team3.trash;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;

@SessionAttributes({ "team3Entity", "day" })
@RequiredArgsConstructor
@Controller
public class Team3DisplayController {

	//private final Team3Repository repository;
	ArrayList<Team3Entity> ary = new ArrayList<>();

	//追加ボタンを押したら記入内容が同ファイルにとぶ
@GetMapping("/Team3displayOut")
	public String get(Model model) {
		try {
			Team3Calculation calc = new Team3Calculation();
		    int total = calc.sumPrice(ary);
			
			model.addAttribute("team3Entity", new Team3Entity());
			model.addAttribute("ary", ary);
			model.addAttribute("total", total);
		} catch (Exception e) {
			e.printStackTrace();
			return "team3/Error";
		}
		return "team3/Team3DisplayOut";
	}

@PostMapping("/Team3add")
	public String add(
			@ModelAttribute @Validated Team3Entity team3Entity,
			BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("ary", ary);

			// 合計金額を計算して渡す
			Team3Calculation calc = new Team3Calculation();
			int total = calc.sumPrice(ary);
			model.addAttribute("total", total);

			return "team3/Team3displayOut";
		}

		ary.add(team3Entity);

		// 合計金額を計算して渡す
		Team3Calculation calc = new Team3Calculation();
		int total = calc.sumPrice(ary);

		model.addAttribute("ary", ary);
		model.addAttribute("total", total);
		model.addAttribute("team3Entity", new Team3Entity());
		return "team3/Team3displayOut";
	}


@PostMapping("/Team3update")
public String update(
	@ModelAttribute("team3Entity") Team3Entity team3Entity,
	@RequestParam("index") int index,
	Model model) {
try {
	// 更新処理
	ary.set(index, team3Entity);
	// 合計金額を計算
	Team3Calculation calc = new Team3Calculation();
	int total = calc.sumPrice(ary);
	// 画面に渡すデータ
	model.addAttribute("ary", ary);
	model.addAttribute("total", total);
	// 入力フォームを空に戻す
	model.addAttribute("team3Entity", new Team3Entity());

} catch (Exception e) {
	e.printStackTrace();
	return "Team3Error";
}
	return "team3/Team3displayOut";
}

@PostMapping("/Team3delete")
public String delete(
        @RequestParam("index") int index,
        Model model) {
    try {
        // 削除処理
        ary.remove(index);

        // 合計金額を計算
        Team3Calculation calc = new Team3Calculation();
        int total = calc.sumPrice(ary);

        // 画面に渡すデータ
        model.addAttribute("ary", ary);
        model.addAttribute("total", total);

        // 入力フォームを空に戻す
        model.addAttribute("team3Entity", new Team3Entity());

    } catch (Exception e) {
        e.printStackTrace();
        return "team3/Error";
    }
    return "team3/Team3displayOut";
}

@PostMapping("/Team3cancel2")
	public String cancel2() {
		return "team3/Team3KalenderIn";
	}

@PostMapping("/Team3save")
	public String save(
			@ModelAttribute("day") String day,
			@ModelAttribute Team3Entity team3Entity, Model model) {
		try {
			Team3Calculation calc = new Team3Calculation();
			int total = calc.sumPrice(ary);

			model.addAttribute("day", day);
			model.addAttribute("list", ary);
			model.addAttribute("total", total);
		} catch (Exception e) {
			e.printStackTrace();
			return "team3/Error";
		}
		return "team3/Team3displayIn";
	}

}
