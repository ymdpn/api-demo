package com.example.apidemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todos_key")
	@Getter
	@Setter
	/**
	 * key
	 */
	private long todosKey;
	
	@Column
	@Getter
	@Setter
	/**
	 * タイトル
	 */
	private String title;
	
	@Column(name =" text_value")
	@Getter
	@Setter
	/**
	 * 本文
	 */
	private String textValue;
	
	@Column
	@Getter
	@Setter
	/**
	 * 作成者(外部キー:users.user_key)
	 */
	private long author;
}