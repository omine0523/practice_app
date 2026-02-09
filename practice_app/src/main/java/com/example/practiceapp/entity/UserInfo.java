package com.example.practiceapp.entity;

import lombok.Data;

@Data
public class UserInfo {
	
	/** id（主キー） */
	private Integer userPk;
	/** ユーザーID */
	private String userId;
	/** パスワード */
	private String password;
	/** ユーザー名 */
	private String userName;

}
