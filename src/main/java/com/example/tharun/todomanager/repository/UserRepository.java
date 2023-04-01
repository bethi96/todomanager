package com.example.tharun.todomanager.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tharun.todomanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select email,password from todos.user where email = :email")
	public User findByEmail(String email);
	
}
