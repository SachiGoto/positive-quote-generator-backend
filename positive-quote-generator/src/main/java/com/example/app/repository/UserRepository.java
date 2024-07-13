package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}