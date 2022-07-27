package com.example.vsii.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vsii.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
