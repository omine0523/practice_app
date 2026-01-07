package com.example.practiceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceapp.dto.CafesSearchCondition;
import com.example.practiceapp.dto.WantUserCafeListDto;
import com.example.practiceapp.mapper.UserCafesMapper;

@Service
public class UserCafesServiceImpl implements UserCafesService {

	@Autowired
	private UserCafesMapper userCafesMapper;
	
	/**
	 * 行きたいカフェリスト
	 * MapperクラスでDBから一覧を取得(検索条件なし)
	 */
	@Override
	public List<WantUserCafeListDto> searchWantCafesByUserId(int userPk) {
		return userCafesMapper.findWantCafesByUserId(userPk);
	}

	/**
	 * 行きたいカフェリスト
	 * MapperクラスでDBから検索条件付きでカフェ一覧を取得
	 */
	@Override
	public List<WantUserCafeListDto> searchWantCafesByUserIdAndCondition(int userPk, CafesSearchCondition condition) {
		return userCafesMapper.findWantCafesByUserIdAndCondition(userPk, condition);
	}

}
