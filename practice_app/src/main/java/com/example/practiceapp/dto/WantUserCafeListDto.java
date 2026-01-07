package com.example.practiceapp.dto;

import lombok.Data;

@Data
public class WantUserCafeListDto {

	/** id */
//	private int id;
	/** 店名 */
	private String storeName;
	/** 住所 */
	private String address;
	/** エリア名 */
	private String areaName;
	/** ジャンル名 */
	private String genreName;
	/** ステータス */
	private String status;
	/** メモ */
	private String memo;
	
}
