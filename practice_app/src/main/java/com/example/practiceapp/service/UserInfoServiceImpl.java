package com.example.practiceapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.mapper.UserInfoMapper;
/**
 * ログイン処理 実装クラス
 * ユーザーIDをもとに、ユーザー情報を取得する。
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
	public Optional<UserInfo> searchUser(String userId) {
		return mapper.findUserByUserId(userId);
	}

}
