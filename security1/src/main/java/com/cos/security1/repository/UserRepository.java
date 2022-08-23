package com.cos.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security1.model.User;

// JpaRepository인터페이스를 상속하면 @Repository를 안적어도 의존성 주입이 됨.
public interface UserRepository extends JpaRepository<User, Integer> {

	
}
