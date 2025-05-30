package com.gildong.gildongE.repository;

import com.gildong.gildongE.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByUserName(String userName);
}