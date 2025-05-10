package com.gildong.gildongE.repository;

import com.gildong.gildongE.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}