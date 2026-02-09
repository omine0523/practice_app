package com.example.practiceapp.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.practiceapp.entity.UserInfo;

/*
 * Mapperインターフェース
 * メソッド名をidとして、UserInfoMapper.xmlに定義されたSQLを実行する
 */
@Mapper
public interface UserInfoMapper {
	/**
     * ユーザーID を条件に完全一致するユーザー情報を取得する。
     * @param userId ユーザー情報 ユーザーID
     * @return 該当ユーザーがいない場合　
     */
	 Optional<UserInfo> findUserByUserId (@Param("userId") String userId);
	 
}
