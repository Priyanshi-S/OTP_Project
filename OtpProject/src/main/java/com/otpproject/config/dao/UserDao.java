package com.otpproject.config.dao;

import org.springframework.stereotype.Repository;

import com.otpproject.config.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<Users, String>{

}
