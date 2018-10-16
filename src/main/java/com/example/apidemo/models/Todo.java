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


@Entity
@Table(name = "todos")
public class Todo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2014544499288446537L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todos_key")
	/**
	 * key
	 */
	private Long todosKey;
	
	public Long getTodosKey() {
		return todosKey;
	}
	public void setTodosKey(Long todosKey) {
		this.todosKey = todosKey;
	}
	
	@Column
	@NotBlank
	/**
	 * タイトル
	 */
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name =" text_value")
	/**
	 * 本文
	 */
	private String textValue;
	
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	
	@Column
	@NotNull
	/**
	 * 作成者(外部キー:users.user_key)
	 */
	private Long author;
	
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
}