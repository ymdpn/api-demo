package com.example.apidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.apidemo.repositories.UserRepository;
import com.example.apidemo.dto.UserDto;
import com.example.apidemo.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repository;

    /**
     * 全てのユーザー情報リストを返す。
     * 
     * @return List<UserDto> 全ユーザー情報
     */
    public List<UserDto> findAll() {
        var list = repository.findAll(new Sort(Sort.Direction.ASC, "userKey"));
        return list.stream().map(entity -> userToDto(entity)).collect(Collectors.toList());
    }
    
    /**
     * user_keyに合致するユーザー情報を返却する。
     * 
     * @param userKey シリアルキー
     * @return UserDto ユーザー情報
     */
    public UserDto findUserByUserKey(long userKey) {
    	var user =  repository.findById(userKey).get();
    	return userToDto(user);
    }
    
    /**
     * 引数のユーザー情報に合致するユーザー情報リストを返却する。<br>
     * 
     * 条件：<br>
     * userKeyが指定されている： userKeyの完全一致<br>
     * userIdとuserNameが指定されている： userIdの部分一致 AND userNameの部分一致<br>
     * userIdのみ指定されている: userIdの部分一致<br>
     * userNameのみ指定されている: userNameの部分一致
     * 
     * @param 検索条件DTO
     * @return ユーザー情報リスト
     */
    public List<UserDto> findUsers(UserDto dto) {
    	List<User> list;
    	if (dto.getUserKey() != null) {
    		list = new ArrayList<User>();
    		var user = repository.findById(dto.getUserKey()).get();
    		list.add(user);
    	} else if (!StringUtils.isEmpty(dto.getUserId()) && !StringUtils.isEmpty(dto.getUserName())) {
    		list = repository.findByUserIdContainingAndUserNameContaining(
    		    			dto.getUserId(), dto.getUserName());
    	} else if (!StringUtils.isEmpty(dto.getUserId())) {
    		list = repository.findByUserIdContaining(dto.getUserId());
    	} else if (!StringUtils.isEmpty(dto.getUserName())) {
    		list = repository.findByUserNameContaining(dto.getUserName());
    	} else {
    		return new ArrayList<UserDto>();
    	}
        return list.stream().map(entity -> userToDto(entity)).collect(Collectors.toList());
    }
    
    /**
     * ユーザー情報を保存する。
     * 
     * @param userDto
     * @return UserDto 保存されたユーザー情報
     */
    public UserDto save(UserDto dto) {
    	var user = dtoToUser(dto);
    	return userToDto(repository.save(user));
    }
    
    /**
     * ユーザー情報の削除
     * 
     * @param userKey
     */
    public void delete(Long userKey) {
    	repository.deleteById(userKey);
    }
    
    private User dtoToUser(UserDto dto) {
    	var user = new User();
    	user.setUserKey(dto.getUserKey());
    	user.setUserId(dto.getUserId());
    	user.setUserName(dto.getUserName());
    	user.setPassword(dto.getPassword());
 
    	return user;
    }
    
    private UserDto userToDto(User user) {
    	var dto  = new UserDto();
    	dto.setUserKey(user.getUserKey());
    	dto.setUserId(user.getUserId());
    	dto.setUserName(user.getUserName());
    	dto.setPassword(user.getPassword());
    	
    	return dto;
    }
}