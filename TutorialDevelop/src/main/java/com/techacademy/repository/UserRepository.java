package com.techacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techacademy.entity.User;

// 本来Repositoryクラスには@Repositoryをつける必要があるが、
// 継承元のJpaRepositoryで既に宣言されているため今回は不要。
public interface UserRepository extends JpaRepository<User, Integer>{

}
