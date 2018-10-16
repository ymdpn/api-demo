package com.example.apidemo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.apidemo.models.User;


@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6165535832510389201L;

	/**
	 * シリアルキー
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_key")
    private Long userKey;
	
	public Long getUserKey() {
		return userKey;
	}
	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	/**
	 * ユーザーID
	 */
    @Column(name = "user_id")
    @NotBlank
    private String userId;
    
    public String getUserId() {
    	return userId;
    }
    public void setUserId(String userId) {
    	this.userId = userId;
    }

    /**
     * ユーザー名
     */
    @Column(name = "user_name")
    @NotBlank
    private String userName;
    
    public String getUserName() {
    	return userName;
    }
    public void setUserName(String userName) {
    	this.userName = userName;
    }

    /**
     * パスワード
     */
    @Column
    @NotNull
    private String password;
    
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }

}