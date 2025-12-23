package com.example.practiceapp.controller;

import java.util.Locale;
import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.form.LoginForm;
import com.example.practiceapp.service.UserInfoService;

/*
 * ログイン画面 コントローラーs
 */
@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserInfoService userInfoService;

	/*
	 * 初期表示
	 */
	@GetMapping("/login")
	public String showLogin(Model model) {
		//フォームの初期化
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	/*
	 * 登録ボタン押下時
	 */
	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginForm loginForm, Model model, HttpSession session) {

		// フォームで入力された userId を取得
		String userId = loginForm.getUserId();
		// userIdを元にユーザー情報を取得
		Optional<UserInfo> userOpt = userInfoService.findUser(userId);

		// ユーザーが存在しなかった場合、エラーメッセージを返却しログイン画面に戻す
		if (userOpt.isEmpty()) {
			model.addAttribute("errorMsg", messageSource.getMessage("login.error.usernotfound", null, Locale.JAPAN));
			return "login";
		}
		// Optionalの中にUserInfoが存在する場合、UserInfoオブジェクトを取得
		UserInfo loginUser = userOpt.get();

		// フォームで入力されたパスワードとテーブルに登録されているパスワードを比較
		if (loginForm.getPassword().equals(loginUser.getPassword())) {
			// パスワードが一致している場合、セッションにuserIdを保存
			session.setAttribute("userId", loginUser.getUserId());
			// ホーム画面を表示
			return "redirect:/user-top";
		} else {
			// パスワードが不一致の場合、エラーメッセージを返却しログイン画面に戻す
			model.addAttribute("errorMsg", messageSource.getMessage("login.error.invalid", null, Locale.JAPAN));
			return "login";
		}
	}

}
