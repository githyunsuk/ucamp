package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.UserEntity;

@Mapper
public interface UserMapper {

	public int insertUsers(UserEntity user);
	
	public UserEntity selectUserById(String id);
}
