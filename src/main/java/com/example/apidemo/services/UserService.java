package com.example.apidemo.services;

import java.util.List;


import com.example.apidemo.repositories.UserRepository;
import com.example.apidemo.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repository;

    /**
     * 全てのユーザー情報リストを返す。
     * 
     * @return List<User> 全ユーザー情報
     */
    public List<User> findAll() {
        return repository.findAll(new Sort(Sort.Direction.ASC, "userKey"));
    }
    
    /**
     * ユーザー情報の保存
     * 
     * @param user
     * @return User 保存されたユーザー情報
     */
    public User save(User user) {
    	return repository.save(user);
    }
    
    /**
     * ユーザー情報の削除
     * 
     * @param user
     */
    public void delete(User user) {
    	repository.delete(user);
    }
}