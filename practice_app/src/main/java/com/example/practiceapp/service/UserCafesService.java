package com.example.practiceapp.service;

import java.util.List;

import com.example.practiceapp.dto.CafesSearchCondition;
import com.example.practiceapp.dto.WantUserCafeListDto;

/*
 * カフェリスト インターフェース
 * カフェリストの一覧情報を取得
 */
public interface UserCafesService {

	/**
	 * 行きたいカフェリスト
	 * 一覧を取得(検索条件なし)
	 */
	List<WantUserCafeListDto> searchWantCafesByUserId(int userPk);

	/**
	 * 行きたいカフェリスト
	 * 検索条件付きでカフェ一覧取得
	 */
	List<WantUserCafeListDto> searchWantCafesByUserIdAndCondition(int userPk, CafesSearchCondition condition);
}
