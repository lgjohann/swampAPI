package com.johann.swampAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.johann.swampAPI.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
