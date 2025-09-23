package com.ucamp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {

	private Long no;
	private String writer;
	private String content;
}
