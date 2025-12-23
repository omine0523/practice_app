package com.example.practiceapp.controller;

import java.util.Locale;
import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.service.UserInfoService;

@Controller
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * 初期表示
	 */
	@GetMapping("/user-top")
	public String showHome(Model model, HttpSession session) {
		// セッション情報からuserIdを取得
		String userId = (String) session.getAttribute("userId");
		
		// セッション情報からuserIdが取得できなかった場合、エラーメッセージを返却
		if (userId == null) {
	        model.addAttribute("errorMsg", messageSource.getMessage("user.login.required", null, Locale.JAPAN));
	        // ログイン画面に戻す
	        return "login";
	    }
		
		// userIdを元にユーザー情報を取得
		Optional<UserInfo> userOpt = userInfoService.findUser(userId);
		// ユーザーが存在しなかった場合、エラーメッセージを返却しログイン画面に戻す
		if (userOpt.isEmpty()) {
		    model.addAttribute("errorMsg", messageSource.getMessage("login.error.usernotfound", null, Locale.JAPAN));
		    return "login";
		}
		// Optionalの中にUserInfoが存在する場合、UserInfoオブジェクトを取得
		UserInfo userInfo = userOpt.get();
		// userName をモデルに詰めて画面に渡す
        model.addAttribute("userName", userInfo.getUserName());
		// ユーザートップを表示
		return "user/user-top";
	}

}
