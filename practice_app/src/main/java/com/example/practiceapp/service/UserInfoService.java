package com.example.practiceapp.service;

import java.util.Optional;

import com.example.practiceapp.entity.UserInfo;

/*
 * ログイン処理 インターフェース
 * ユーザーIDをもとに、ユーザー情報を取得する。
 */
public interface UserInfoService {

	/**
     * ユーザーIDをキーにユーザー情報を取得する。
     * @param userId ユーザーID
     * @return ユーザー情報（存在しない場合はOptional.empty）
     */
	 Optional<UserInfo> findUser(String userId);
}
