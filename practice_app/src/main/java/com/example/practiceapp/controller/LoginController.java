package com.example.practiceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practiceapp.form.LoginForm;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	
	
	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginForm loginForm, Model model ) {
		
		
		
		if(loginForm.getPassword().equals("aa")) {
			return "redirect:/home"; // ログイン後の遷移先
		} else {
			// ログイン失敗
	        model.addAttribute("errormsg", "ユーザーIDまたはパスワードが違います");
			return "login";
		}
	}
	
	
}
