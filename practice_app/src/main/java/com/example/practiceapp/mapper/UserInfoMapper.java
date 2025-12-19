package com.example.practiceapp.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.practiceapp.entity.UserInfo;

/*
 * Mapperインターフェース
 * メソッド名をidとして、UserInfoMapper.xmlに定義されたSQLを実行する
 */
@Mapper
public interface UserInfoMapper {
	/**
     * userId を条件にユーザー情報を取得するselect文。
     */
	 Optional<UserInfo> getUser (String userId);
	 
}
