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
/*
 * ユーザートップ画面を遷移先を制御する controller
 */
@Controller
public class UserTopController {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * ログイン後に表示するユーザートップ画面のマッピング
	 */
	@GetMapping("/user-top")
	public String showHome(HttpSession session, Model model) {
		// セッション情報からuserIdを取得する
		String userId = (String) session.getAttribute("userId");
		
		// セッション情報からuserIdが取得できなかった場合、エラーメッセージを返却する
		if (userId == null) {
	        model.addAttribute("errorMsg", messageSource.getMessage("user.login.required", null, Locale.JAPAN));
	        // ログイン画面に戻す
	        return "login";
	    }
		
		// userIdを元にユーザー情報を取得する
		Optional<UserInfo> userOpt = userInfoService.searchUser(userId);
		// ユーザーが存在しなかった場合、エラーメッセージを返却しログイン画面に戻す
		if (userOpt.isEmpty()) {
		    model.addAttribute("errorMsg", messageSource.getMessage("login.error.usernotfound", null, Locale.JAPAN));
		    return "login";
		}
		// Optionalの中にUserInfoが存在する場合、UserInfoオブジェクトを取得する
		UserInfo userInfo = userOpt.get();
		// userName をモデルに詰めて画面に渡す
        model.addAttribute("userName", userInfo.getUserName());
		// ユーザートップを表示する
		return "user/user-top";
	}

}
