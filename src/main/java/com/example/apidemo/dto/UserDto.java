package com.example.apidemo.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ユーザー検索条件DTO
 * @author ishiiryousuke
 *
 */
public class UserDto {
	
	/**
	 * シリアルキー
	 */
	@Id
	private Long userKey;
	
	/**
	 * ユーザーID
	 */
    @NotBlank
	private String userId;
	
	/**
	 * ユーザー名
	 */
    @NotBlank
	private String userName;
	
	/**
	 * パスワード
	 */
    @NotNull
	private String password;

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
