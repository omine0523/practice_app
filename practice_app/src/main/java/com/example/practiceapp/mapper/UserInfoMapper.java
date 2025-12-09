package com.example.practiceapp.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.practiceapp.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
	
	 Optional<UserInfo> getUser (String userId);
	 
}
