package com.example.practiceapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.mapper.UserInfoMapper;
/**
 * ログイン処理 実装クラス
 * ユーザーIDをもとにユーザー情報を取得し結果を返す
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper mapper;
	
	/*
	 * ユーザー情報取得処理
	 * userIdをキーにMapperクラスのレコード取得結果を返却
	 */
	@Override
	public Optional<UserInfo> findUser(String userId) {
		return mapper.getUser(userId);
	}

}
