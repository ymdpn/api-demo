package com.example.apidemo.controllers;

import com.example.apidemo.services.UserService;
import com.example.apidemo.dto.UserDto;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods = {GET, PUT , POST, DELETE, OPTIONS})
public class UserController {
    @Autowired
    UserService service;

    /**
     * テーブル内の全てのユーザー情報を返却する。
     * 
     * @return　全てのユーザー情報リスト
     */
    @RequestMapping(value = "/", method = GET)
    public List<UserDto> index() {
        return service.findAll();
    }
    
    /**
     * キーに合致するユーザー情報を返却する。
     * 
     * @param userKey user_key
     * @return 条件に合致するユーザー情報
     */
    @RequestMapping(value = "/find/userKey={userKey}", method = GET)
    public UserDto findUser(@PathVariable long userKey) {
    	return service.findUserByUserKey(userKey);
    }
    
    /**
     * 条件に合致するユーザー情報リストを返却する。
     * 
     * @param user　検索条件
     * @return ユーザー情報リスト
     */
    @RequestMapping(value = "/find", method = POST,
    	consumes = MediaType.APPLICATION_JSON_VALUE,
    	produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> findUsers(@RequestBody UserDto dto) {
    	return service.findUsers(dto);
    }
    
    /**
     * ユーザー情報を新規登録する。
     * 
     * @param 新規ユーザー情報
     * @return UserDto 登録済みユーザー情報
     */
    @RequestMapping(value = "/create", method = POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody @Valid UserDto dto) {
    	return service.save(dto);
    }
    
    /**
     * ユーザー情報を更新する。
     * 
     * @param dto 更新ユーザー情報
     * @param userKey user_key
     * @return 更新後ユーザー情報
     */
    @RequestMapping(value = "/update/userkey= {userKey}", method = POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto update(@RequestBody @Valid UserDto dto, @PathVariable long userKey) {
    	dto.setUserKey(userKey);
    	return service.save(dto);
    }
    
    /**
     * キーに合致するユーザー情報を削除する。
     * @param userKey
     */
    @RequestMapping(value = "/delete?userKey={userKey}", method = POST)
    public void deleteUser(@PathVariable long userKey) {
    	service.delete(userKey);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public UserDto handleBadRequest(HttpMessageNotReadableException ex, WebRequest request) {
		return new UserDto();
    }
}