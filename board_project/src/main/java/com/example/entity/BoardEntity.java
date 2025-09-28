package com.example.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("BoardEntity")
public class BoardEntity {

	private int no;
	private String title;
	private String content;
	private String userid;
	private String name;
}
