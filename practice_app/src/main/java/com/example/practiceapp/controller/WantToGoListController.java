package com.example.practiceapp.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.practiceapp.dto.CafesSearchCondition;
import com.example.practiceapp.service.UserCafesService;

/**
 * 行きたいカフェリストを画面に表示し、
 * 検索を行ったり、新規登録画面へ遷移させる controller クラス
 */
@Controller
public class WantToGoListController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserCafesService userCafesService;

	/**
	 * 自分が登録している行きたいカフェをリスト形式で画面を表示する。
	 * 
	 * TODO: これからcondition実装予定
	 * @param condition DB操作用に変換してまとめた検索条件
	 * @param session ログイン中のユーザーのセッション情報
	 * @param model 画面に渡して表示のためのモデル
	 * @return カフェリスト取得結果を表示する
	 */
	@GetMapping("/user/want-to-go-cafes")
	public String showWentToGosCafest(@ModelAttribute CafesSearchCondition condition,
			HttpSession session, Model model) {
		// 一覧を取得のためセッションに保存している ユーザー情報のid（主キー）を取り出す。
		Integer userPk = (Integer) session.getAttribute("userPk");
		// セッションから取得した userPk でログインしているユーザーの行きたいカフェを全件を取得して、モデルに詰めて画面に渡す。
		model.addAttribute("wantUserCafes", userCafesService.searchWantCafesByUserId(userPk));
		// カフェリスト取得結果を画面を表示する。
		return "user/cafes/want-to-go-list";
	}

}
