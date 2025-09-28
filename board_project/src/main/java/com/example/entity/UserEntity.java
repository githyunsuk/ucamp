package com.example.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("UserEntity")
public class UserEntity {

	private String id;
	private String password;
	private String name;
}
