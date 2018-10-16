package com.example.apidemo.dto;

/**
 * TodoクラスDTO
 * @author ishiiryousuke
 *
 */
public class TodoDto {
	
	/**
	 * シリアルキー
	 */
	private Long todosKey;
	/**
	 * タイトル
	 */
	private String title;
	/**
	 * 本文
	 */
	private String textValue;
	/**
	 * 作成者(外部キー:users.user_key)
	 */
	private Long author;
	public Long getTodosKey() {
		return todosKey;
	}
	public void setTodosKey(Long todosKey) {
		this.todosKey = todosKey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
}
