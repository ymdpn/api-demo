package com.example.apidemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	/**
	 * 引数のオブジェクトをJSON文字列に変換して返す。
	 * 
	 * @param オブジェクト
	 * @return String JSON文字列
	 * @throws JsonProcessingException 
	 */
	public static String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
