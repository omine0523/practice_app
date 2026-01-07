package com.example.practiceapp.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.practiceapp.dto.CafesSearchCondition;
import com.example.practiceapp.service.UserInfoService;

@Controller
public class WantToGoListController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * 初期表示
	 */
	@GetMapping("/user/want-to-go-cafes")
	public String showWentToGosCafesList(@ModelAttribute CafesSearchCondition condition,
			HttpSession session, Model model) {
		// userId を使って行きたいカフェ一覧を取得
	    // model.addAttribute("cafes", cafeList);

	    return "user/cafes/want-to-go-list";
	}
	
}
