package com.example.apidemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apidemo.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	/**
	 * 作成者キーとタイトルに紐付くTodoリストを返却する。
	 * 
	 * @param author 完全一致
	 * @param title 部分一致
	 * @return Todoエンティティリスト
	 */
	public List<Todo> findByAuthorAndTitleContaining(Long author, String title);
	
	/**
	 * 作成者キーと本文に紐付くTodoリストを返却する。
	 * 
	 * @param author 完全一致
	 * @param textValue 部分一致
	 * @return Todoエンティティリスト
	 */
	public List<Todo> findByAuthorAndTextValueContaining(Long author, String textValue);

}
