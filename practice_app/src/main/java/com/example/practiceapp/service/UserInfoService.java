package com.example.practiceapp.service;

import java.util.Optional;

import com.example.practiceapp.entity.UserInfo;

public interface UserInfoService {
	 Optional<UserInfo> findUser(String userId);
}
