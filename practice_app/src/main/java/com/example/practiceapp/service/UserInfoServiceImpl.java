package com.example.practiceapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceapp.entity.UserInfo;
import com.example.practiceapp.mapper.UserInfoMapper;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper mapper;

	@Override
	public Optional<UserInfo> findUser(String userId) {
		return mapper.getUser(userId);
	}

}
