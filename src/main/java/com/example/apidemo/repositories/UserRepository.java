package com.example.apidemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apidemo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByUserIdContainingAndUserNameContaining(String userId, String userName);
	public List<User> findByUserIdContaining(String userId);
	public List<User> findByUserNameContaining(String userName);
}