package com.example.practiceapp.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.form.LoginForm;
import com.example.practiceapp.service.UserInfoService;


@Controller
public class LoginController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	
	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginForm loginForm, Model model) {
		//ブラウザ言語設定と同じ言語を取得
		Locale locale = LocaleContextHolder.getLocale();
		
		// プロパティファイルからメッセージを取得
		String userNotFound = messageSource.getMessage("login.error.usernotfound", null, locale);
	    String invalid = messageSource.getMessage("login.error.invalid", null, locale);
	    
	    // ★ フォーム入力された userId を取得
	    String userId = loginForm.getUserId();
	    // ServiceからUserInfoの情報を取得
	    Optional<UserInfo> userOpt = userInfoService.findUser(userId);
	    
	    // ユーザーが存在しない場合
	    if (userOpt.isEmpty()) {
	        model.addAttribute("errorMsg", userNotFound);
	        return "login";
	    }
	    // Optional から中身を取り出す
	    UserInfo loginUser = userOpt.get();

		if(loginForm.getPassword().equals(loginUser.getPassword())) {
			return "redirect:/home"; // ログイン後の遷移先
		} else {
			// ログイン失敗
	        model.addAttribute("errorMsg", invalid);
			return "login";
		}
	}
	
	
}
