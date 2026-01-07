package com.example.practiceapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.practiceapp.dto.CafesSearchCondition;
import com.example.practiceapp.dto.WantUserCafeListDto;

/*
 * CafesListMapperインターフェース
 * メソッド名をidとして、CafesListMapper.xmlに定義されたSQLを実行する
 */
@Mapper
public interface UserCafesMapper {

	/**
	 * DTOに定義されている項目のcafeslistを一覧取得
	 */
	List<WantUserCafeListDto> findWantCafesByUserId(@Param("userPk") int userPk);
	/**
	 * 条件付きでcafeslistを一覧取得
	 */
	List<WantUserCafeListDto> findWantCafesByUserIdAndCondition(
			@Param("userPk")int userPk, 
			@Param("condition") CafesSearchCondition condition);
	
}