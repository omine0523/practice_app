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
 * ログイン画面の処理を制御する controller
 */
@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserInfoService userInfoService;

	/*
	 * ログイン画面の表示をする
	 */
	@GetMapping("/login")
	public String showLogin(Model model) {
		//フォームの初期化
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	/*
	 * ログインボタン押下時の送信情報を判定する
	 */
	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginForm loginForm, Model model, HttpSession session) {

		// フォームで入力された userId を取得
		String userId = loginForm.getUserId();
		// userIdを元にユーザー情報を取得
		Optional<UserInfo> userOpt = userInfoService.searchUser(userId);

		// ユーザーが存在しなかった場合、エラーメッセージを返却しログイン画面に戻す
		if (userOpt.isEmpty()) {
			model.addAttribute("errorMsg", messageSource.getMessage("login.error.usernotfound", null, Locale.JAPAN));
			return "login";
		}
		// Optionalの中にUserInfoが存在する場合、UserInfoオブジェクトを取得する
		UserInfo loginUser = userOpt.get();

		// フォームで入力されたパスワードとテーブルに登録されているパスワードを比較する
		if (loginForm.getPassword().equals(loginUser.getPassword())) {
			// パスワードが一致している場合、セッションに id（主キー）と ユーザーID を保存する
			session.setAttribute("userPk", loginUser.getUserPk());
			session.setAttribute("userId", loginUser.getUserId());
			// ユーザートップ画面を表示する
			return "redirect:/user-top";
		} else {
			// パスワードが不一致の場合、エラーメッセージを返却しログイン画面に戻す
			model.addAttribute("errorMsg", messageSource.getMessage("login.error.invalid", null, Locale.JAPAN));
			return "login";
		}
	}

}
