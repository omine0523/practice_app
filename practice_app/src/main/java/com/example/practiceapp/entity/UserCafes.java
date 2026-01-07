package com.example.practiceapp.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserCafes {

	/** id */
	private int id;
	/** ユーザーID */
	private String fkUserId;
	/** 店名 */
	private String storeName;
	/** 住所 */
	private String address;
	/** エリア */
	private CafesArea area;
	/** ジャンル */
	private CafesGenre genre;
	/** ステータス */
	private String status;
	/** メモ */
	private String memo;
	/** 訪問日 */
	private LocalDate visitedDate;

}