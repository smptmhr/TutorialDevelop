package com.techacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

// サービスクラスであることを示す。
// @Serviceをつけたクラスは、Spring起動時にDIコンテナに登録される。
// ↓ DIコンテナに登録されるアノテーションの例
// @Component, @Controller, @Service, @Repository, @RestController, @Service
@Service
public class UserService {

    @Autowired // コンポーネントの利用
    private UserRepository userRepository;
    
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
